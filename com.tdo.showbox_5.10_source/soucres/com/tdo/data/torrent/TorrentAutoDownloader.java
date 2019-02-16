package com.tdo.showbox.data.torrent;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.IBinder;
import android.text.TextUtils;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.loader.C3124f;
import com.tdo.showbox.data.torrent.C3139a.C2750a;
import com.tdo.showbox.models.CatCRTorrentItem;
import com.tdo.showbox.models.DelayedEpisode;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p131f.C3172a;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3178f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TorrentAutoDownloader extends Service {

    /* renamed from: com.tdo.showbox.data.torrent.TorrentAutoDownloader$4 */
    static class C31344 implements OnClickListener {
        C31344() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C3065b.m16569a("auto_torrent_tv_removing_popup", "action", "cancel");
        }
    }

    /* renamed from: a */
    public static void m16855a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(context.getApplicationContext(), TorrentAutoDownloader.class);
        intent.putExtra("CMD", 765);
        intent.putExtra("ARG_POSTER", str);
        intent.putExtra("ARG_SHOW_TITLE", str2);
        intent.putExtra("ARG_SHOW_IMDB", str3);
        intent.putExtra("ARG_SHOW_SEASON", str4);
        intent.putExtra("ARG_SHOW_EPISODE", str5);
        intent.putExtra("ARG_SHOW_EPISODE_TITLE", str6);
        context.getApplicationContext().startService(intent);
    }

    /* renamed from: a */
    public static void m16852a(Context context) {
        C3088f.m16676a(context.getApplicationContext());
        if (C3088f.m16682b("PREFS_SETTINGS_AUTO_DOWNLOADING")) {
            Intent intent = new Intent(context.getApplicationContext(), TorrentAutoDownloader.class);
            intent.putExtra("CMD", 7657);
            context.getApplicationContext().startService(intent);
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("CMD", -1);
                if (intExtra == 765) {
                    m16856a(getApplicationContext(), intent.getStringExtra("ARG_POSTER"), intent.getStringExtra("ARG_SHOW_TITLE"), intent.getStringExtra("ARG_SHOW_IMDB"), intent.getStringExtra("ARG_SHOW_SEASON"), intent.getStringExtra("ARG_SHOW_EPISODE"), intent.getStringExtra("ARG_SHOW_EPISODE_TITLE"), true);
                } else if (intExtra == 7657) {
                    for (DelayedEpisode delayedEpisode : new Select().from(DelayedEpisode.class).execute()) {
                        if (System.currentTimeMillis() - delayedEpisode.getFirstCheckedTime() > 86400000) {
                            new Delete().from(DelayedEpisode.class).where("imdb='" + delayedEpisode.getImdb() + "'").execute();
                        } else {
                            m16853a(getApplicationContext(), delayedEpisode);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    public static void m16857a(Context context, boolean z) {
        C3088f.m16680a("PREFS_WIFI_CONNECTED", z);
        int c = C3088f.m16684c("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE");
        if ((C3088f.m16682b("PREFS_CHARGER_PLUGGED") || c == 0) && z) {
            m16861b(context);
        } else {
            m16863c(context);
        }
    }

    /* renamed from: b */
    public static void m16862b(Context context, boolean z) {
        C3088f.m16680a("PREFS_CHARGER_PLUGGED", z);
        C3088f.m16680a("PREFS_WIFI_CONNECTED", C3178f.m16971a(context) == 2);
        int c = C3088f.m16684c("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE");
        if (C3088f.m16682b("PREFS_WIFI_CONNECTED") && (z || c == 0)) {
            m16861b(context);
        } else {
            m16863c(context);
        }
    }

    /* renamed from: a */
    private void m16853a(Context context, DelayedEpisode delayedEpisode) {
        m16856a(context, delayedEpisode.getShowPoster(), delayedEpisode.getShowTitle(), delayedEpisode.getImdb(), delayedEpisode.getSeason(), delayedEpisode.getEpisode(), delayedEpisode.getEpisodeTitle(), false);
    }

    /* renamed from: a */
    private void m16856a(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        C3094j.m16698a("TorrentAutoDownloader", "addEpisodeToQueue: " + str2);
        new Delete().from(DownloadEpisode.class).where("isDeleted=1").execute();
        if (((DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + str5 + " AND season_num=" + str4 + " AND title=" + DatabaseUtils.sqlEscapeString(str2)).executeSingle()) != null) {
            C3094j.m16698a("TorrentAutoDownloader", "addEpisodeToQueue. Episode already downloaded");
            return;
        }
        final Context context2 = context;
        final String str7 = str3;
        final String str8 = str2;
        final String str9 = str;
        final String str10 = str4;
        final String str11 = str5;
        final String str12 = str6;
        final boolean z2 = z;
        new C3139a(new C2999a(context)).m16877a("", Integer.valueOf(str4).intValue(), Integer.valueOf(str5).intValue(), str3, new C2750a(this) {
            /* renamed from: i */
            final /* synthetic */ TorrentAutoDownloader f12203i;

            /* renamed from: com.tdo.showbox.data.torrent.TorrentAutoDownloader$1$1 */
            class C31301 implements Comparator<CatCRTorrentItem> {
                /* renamed from: a */
                final /* synthetic */ C31311 f12194a;

                C31301(C31311 c31311) {
                    this.f12194a = c31311;
                }

                public /* synthetic */ int compare(Object obj, Object obj2) {
                    return m16849a((CatCRTorrentItem) obj, (CatCRTorrentItem) obj2);
                }

                /* renamed from: a */
                public int m16849a(CatCRTorrentItem catCRTorrentItem, CatCRTorrentItem catCRTorrentItem2) {
                    return Long.valueOf(catCRTorrentItem.getSize()).compareTo(Long.valueOf(catCRTorrentItem2.getSize()));
                }
            }

            /* renamed from: a */
            public void mo2033a(List<CatCRTorrentItem> list) {
                if (list == null || list.size() <= 0) {
                    if (z2) {
                        this.f12203i.m16860a(str9, str8, str7, str10, str11, str12);
                    }
                    C3094j.m16698a("TorrentAutoDownloader", "onTorrentListObtained. List empty");
                    return;
                }
                C3094j.m16698a("TorrentAutoDownloader", "onTorrentListObtained: " + list.size());
                List arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(list.get(i));
                    if (i >= 2) {
                        break;
                    }
                }
                Collections.sort(arrayList, new C31301(this));
                CatCRTorrentItem catCRTorrentItem = (CatCRTorrentItem) arrayList.get(0);
                if (((long) (((double) catCRTorrentItem.getSize()) * 1.2d)) > C3176e.m16965a()) {
                    C3094j.m16698a("TorrentAutoDownloader", "No available storage space");
                } else {
                    this.f12203i.m16854a(context2, str7, str8, str9, str10, str11, catCRTorrentItem, str12);
                }
            }
        });
    }

    /* renamed from: a */
    private void m16860a(String str, String str2, String str3, String str4, String str5, String str6) {
        new Delete().from(DelayedEpisode.class).where("imdb='" + str3 + "'").execute();
        DelayedEpisode delayedEpisode = new DelayedEpisode();
        delayedEpisode.setEpisode(str5);
        delayedEpisode.setEpisodeTitle(str6);
        delayedEpisode.setImdb(str3);
        delayedEpisode.setFirstCheckedTime(System.currentTimeMillis());
        delayedEpisode.setShowPoster(str);
        delayedEpisode.setShowTitle(str2);
        delayedEpisode.setSeason(str4);
        delayedEpisode.save();
    }

    /* renamed from: a */
    private void m16854a(Context context, String str, String str2, String str3, String str4, String str5, CatCRTorrentItem catCRTorrentItem, String str6) {
        String torrentLink = catCRTorrentItem.getTorrentLink();
        new Delete().from(DelayedEpisode.class).where("imdb='" + str + "'").execute();
        if (!TextUtils.isEmpty(torrentLink)) {
            long longValue = Long.valueOf(str5).longValue();
            long hashCode = longValue + ((long) str6.hashCode());
            BaseVideoSource baseVideoSource = new BaseVideoSource();
            baseVideoSource.setSource_mode_id(7);
            baseVideoSource.setStatic_link(torrentLink);
            Context context2 = context;
            String str7 = str2;
            DownloadEpisode a = C3172a.m16954a(context2, hashCode, torrentLink, str7, Integer.valueOf(str4).intValue(), context.getString(R.string.episode) + " " + str5, str3, 2, longValue, baseVideoSource);
            a.setAuto(1);
            C3124f a2 = C3124f.m16794a(context.getApplicationContext());
            a2.m16800a(a).m16809a(null).m16822g();
            int c = C3088f.m16684c("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE");
            if ((C3088f.m16682b("PREFS_CHARGER_PLUGGED") || c == 0) && C3088f.m16682b("PREFS_WIFI_CONNECTED")) {
                a2.m16800a(a).m16809a(null).m16810a();
            }
        }
    }

    /* renamed from: b */
    private static void m16861b(Context context) {
        C3094j.m16698a("TorrentAutoDownloader", "resumeDownloading");
        List<DownloadEpisode> execute = new Select().from(DownloadEpisode.class).where("percent!=100 AND auto=1").orderBy("Id DESC").execute();
        C3124f a = C3124f.m16794a(context.getApplicationContext());
        for (DownloadEpisode downloadEpisode : execute) {
            if (downloadEpisode.getStatus() == 3 || downloadEpisode.getStatus() == 1 || downloadEpisode.getStatus() == 0) {
                a.m16800a(downloadEpisode).m16809a(null).m16810a();
            }
        }
    }

    /* renamed from: c */
    private static void m16863c(Context context) {
        C3094j.m16698a("TorrentAutoDownloader", "stopDownloading");
        List<DownloadEpisode> execute = new Select().from(DownloadEpisode.class).where("percent!=100 AND auto=1").orderBy("Id DESC").execute();
        C3124f a = C3124f.m16794a(context.getApplicationContext());
        for (DownloadEpisode downloadEpisode : execute) {
            downloadEpisode.setIs_downloading(0);
            downloadEpisode.setStatus(3);
            downloadEpisode.save();
            a.m16800a(downloadEpisode).m16809a(null).m16816d();
        }
    }

    /* renamed from: a */
    public static void m16851a(Activity activity) {
        if (C3088f.m16682b("PREFS_SETTINGS_AUTO_REMOVING")) {
            final List execute = new Select().from(DownloadEpisode.class).where("is_viewed=1 AND auto=1").orderBy("Id DESC").execute();
            if (execute.size() != 0) {
                CharSequence[] charSequenceArr = new String[execute.size()];
                final boolean[] zArr = new boolean[execute.size()];
                for (int i = 0; i < execute.size(); i++) {
                    DownloadEpisode downloadEpisode = (DownloadEpisode) execute.get(i);
                    zArr[i] = true;
                    charSequenceArr[i] = downloadEpisode.getTitle() + ". " + downloadEpisode.getShows_info();
                }
                Builder builder = new Builder(activity);
                builder.setTitle(R.string.alert_title_viewed_episodes);
                builder.setMultiChoiceItems(charSequenceArr, zArr, new OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                        zArr[i] = z;
                    }
                });
                builder.setPositiveButton(R.string.do_it, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int i2 = 0; i2 < execute.size(); i2++) {
                            if (zArr[i2]) {
                                DownloadEpisode downloadEpisode = (DownloadEpisode) execute.get(i2);
                                try {
                                    new File(downloadEpisode.getFull_path()).delete();
                                } catch (Exception e) {
                                }
                                new Delete().from(DownloadEpisode.class).where("episode_id=" + downloadEpisode.getEpisode_id()).execute();
                            }
                        }
                        C3065b.m16569a("auto_torrent_tv_removing_popup", "action", "ok");
                    }
                });
                builder.setNegativeButton(R.string.no_thanks, new C31344());
                builder.show();
            }
        }
    }
}
