package com.tdo.showbox.p117b;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.p050c.p051a.p059b.C1100d;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2681b;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.loader.C2755a;
import com.tdo.showbox.data.loader.C3124f;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.p121g.C3197a;
import com.tdo.showbox.views.C3324d;
import com.tdo.showbox.views.C3324d.C2744a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: DownloadLibFragment */
/* renamed from: com.tdo.showbox.b.c */
public class C2834c extends C2769a implements OnItemClickListener {
    /* renamed from: c */
    private ListView f11312c;
    /* renamed from: d */
    private C3197a f11313d;
    /* renamed from: e */
    private List<DownloadEpisode> f11314e;
    /* renamed from: f */
    private ArrayList<View> f11315f;
    /* renamed from: g */
    private View f11316g;
    /* renamed from: h */
    private LinearLayout f11317h;
    /* renamed from: i */
    private LayoutInflater f11318i;
    /* renamed from: j */
    private Dialog f11319j;
    /* renamed from: k */
    private TextView f11320k;
    /* renamed from: l */
    private C2681b f11321l = new C2681b();

    /* compiled from: DownloadLibFragment */
    /* renamed from: com.tdo.showbox.b.c$1 */
    class C28251 implements Comparator<DownloadEpisode> {
        /* renamed from: a */
        final /* synthetic */ C2834c f11296a;

        C28251(C2834c c2834c) {
            this.f11296a = c2834c;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m15799a((DownloadEpisode) obj, (DownloadEpisode) obj2);
        }

        /* renamed from: a */
        public int m15799a(DownloadEpisode downloadEpisode, DownloadEpisode downloadEpisode2) {
            int compareTo = downloadEpisode.getTitle().compareTo(downloadEpisode2.getTitle());
            if (compareTo != 0) {
                return compareTo;
            }
            if (downloadEpisode.getSeason_num() == downloadEpisode2.getSeason_num()) {
                if (downloadEpisode.getEpisode_num() == downloadEpisode2.getEpisode_num()) {
                    return 0;
                }
                if (downloadEpisode.getEpisode_num() > downloadEpisode2.getEpisode_num()) {
                    return 1;
                }
                return -1;
            } else if (downloadEpisode.getSeason_num() > downloadEpisode2.getSeason_num()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    /* compiled from: DownloadLibFragment */
    /* renamed from: com.tdo.showbox.b.c$2 */
    class C28272 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2834c f11299a;

        C28272(C2834c c2834c) {
            this.f11299a = c2834c;
        }

        public void onClick(final View view) {
            C3324d.m17541a(this.f11299a.m15484h(), ((DownloadEpisode) this.f11299a.f11314e.get(((Integer) view.getTag()).intValue())).getVideo_source(), new C2744a(this) {
                /* renamed from: b */
                final /* synthetic */ C28272 f11298b;

                /* renamed from: a */
                public void mo2027a() {
                    DownloadEpisode downloadEpisode = (DownloadEpisode) this.f11298b.f11299a.f11314e.get(((Integer) view.getTag()).intValue());
                    try {
                        Bundle bundle = new Bundle();
                        if (downloadEpisode.getIs_movie() == 1) {
                            bundle.putInt("ARG_TYPE_PLAY", 2);
                        } else {
                            bundle.putInt("ARG_TYPE_PLAY", 3);
                        }
                        bundle.putString("ARG_TITLE", downloadEpisode.getTitle());
                        bundle.putInt("ARG_QUALITY", 0);
                        bundle.putInt("ARG_SEASON_NUM", downloadEpisode.getSeason_num());
                        bundle.putLong("ARG_MOVE_ID", 0);
                        bundle.putString("ARG_SUBTITLES_ID", downloadEpisode.getSubtitle_id());
                        bundle.putLong("ARG_EPIZOD_ID", (long) downloadEpisode.getEpisode_num());
                        bundle.putLong("ARG_OBJECT_ID", downloadEpisode.getId().longValue());
                        if (!this.f11298b.f11299a.m15482f()) {
                            this.f11298b.f11299a.m15484h().m15076a().m16467a(true, "download_page_btn_watch__");
                        }
                        this.f11298b.f11299a.m15484h().mo2003a(downloadEpisode.getFull_path(), downloadEpisode.getEpisode_id(), downloadEpisode.getView_position(), true, bundle, downloadEpisode.getTitle(), (Subtitle) new Select().from(Subtitle.class).where("parrent_id='" + downloadEpisode.getSubtitle_id() + "'").executeSingle());
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    /* compiled from: DownloadLibFragment */
    /* renamed from: com.tdo.showbox.b.c$3 */
    class C28293 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2834c f11302a;

        C28293(C2834c c2834c) {
            this.f11302a = c2834c;
        }

        public void onClick(final View view) {
            Builder builder = new Builder(this.f11302a.m15484h());
            builder.setMessage(this.f11302a.getString(R.string.delete_alert));
            builder.setPositiveButton(this.f11302a.getString(R.string.yes), new DialogInterface.OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C28293 f11301b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        if (this.f11301b.f11302a.f11319j != null) {
                            this.f11301b.f11302a.f11319j.dismiss();
                        }
                    } catch (Exception e) {
                    }
                    try {
                        DownloadEpisode downloadEpisode = (DownloadEpisode) this.f11301b.f11302a.f11314e.remove(((Integer) view.getTag()).intValue());
                        try {
                            new File(downloadEpisode.getFull_path()).delete();
                        } catch (Exception e2) {
                        }
                        new Delete().from(DownloadEpisode.class).where("episode_id=" + downloadEpisode.getEpisode_id()).execute();
                        if (this.f11301b.f11302a.f11313d != null) {
                            this.f11301b.f11302a.f11313d.m17022a(this.f11301b.f11302a.f11314e);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            });
            builder.setNegativeButton(this.f11302a.getString(R.string.download_cancel), null);
            this.f11302a.f11319j = builder.show();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_download, null);
        this.f11312c = (ListView) this.a.findViewById(R.id.downloads_list_view);
        this.f11320k = (TextView) this.a.findViewById(R.id.empty_txtv);
        this.f11318i = LayoutInflater.from(m15484h());
        this.f11316g = this.f11318i.inflate(R.layout.download_header, null);
        this.f11317h = (LinearLayout) this.f11316g.findViewById(R.id.main_container);
        m15813b();
        m15815c();
        return this.a;
    }

    /* renamed from: a */
    private void m15811a() {
        Collections.sort(this.f11314e, new C28251(this));
    }

    /* renamed from: b */
    private void m15813b() {
        new Delete().from(DownloadEpisode.class).where("isDeleted=1").execute();
        this.f11314e = new Select().from(DownloadEpisode.class).where("percent=100").execute();
        m15811a();
        this.f11313d = new C3197a(m15484h(), this.f11314e);
        this.f11316g.setVisibility(8);
        this.f11312c.addFooterView(this.f11316g);
        this.f11312c.setAdapter(this.f11313d);
        this.f11313d.m17023b(new C28272(this));
        this.f11313d.m17021a(new C28293(this));
    }

    /* renamed from: c */
    private void m15815c() {
        this.f11317h.removeAllViews();
        this.f11315f = new ArrayList();
        List<DownloadEpisode> execute = new Select().from(DownloadEpisode.class).where("percent!=100").orderBy("Id DESC").execute();
        if (this.f11314e.size() == 0 && execute.size() == 0) {
            this.f11320k.setText(m15484h().getString(R.string.lib_downloads_empty));
            this.f11320k.setVisibility(0);
        }
        for (final DownloadEpisode downloadEpisode : execute) {
            int i;
            if (this.f11316g.getVisibility() == 8) {
                this.f11316g.setVisibility(0);
            }
            final View inflate = this.f11318i.inflate(R.layout.item_downloads, null);
            TextView textView = (TextView) inflate.findViewById(R.id.txtv_title);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.load_progress);
            progressBar.setProgress(downloadEpisode.getPercent());
            textView.setText(downloadEpisode.getTitle());
            textView = (TextView) inflate.findViewById(R.id.txtv_season);
            if (downloadEpisode.getShows_info() != null) {
                textView.setText(downloadEpisode.getShows_info());
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.imgv_tv);
            TextView textView2 = (TextView) inflate.findViewById(R.id.txtv_download_info);
            File file = new File(downloadEpisode.getFull_path());
            progressBar.setVisibility(0);
            long length = file.length();
            if (downloadEpisode.getVideo_source() != 7) {
                i = (int) (length / 1000000);
            } else {
                i = (int) (downloadEpisode.getProgress() / 1000000);
            }
            if (downloadEpisode.getPercent() != 0) {
                int percent = downloadEpisode.getPercent();
                textView2.setText(m15484h().getString(R.string.info_downloaded) + " " + i + m15484h().getString(R.string.mb) + " " + m15484h().getString(R.string.of) + " " + (downloadEpisode.getFile_size() / 1000000) + m15484h().getString(R.string.mb) + " (" + percent + "%)");
                progressBar.setProgress(percent);
            } else {
                textView2.setText(m15484h().getString(R.string.info_downloaded) + " " + i + m15484h().getString(R.string.mb) + " " + m15484h().getString(R.string.of) + " " + (downloadEpisode.getFile_size() / 1000000) + m15484h().getString(R.string.mb) + " (" + 0 + "%)");
                progressBar.setProgress(0);
            }
            if (downloadEpisode.getFile_size() / 1000000 <= 0) {
                textView2.setText(m15484h().getString(R.string.info_downloaded) + " : " + i + m15484h().getString(R.string.mb));
            }
            if (downloadEpisode.getShows_info() != null) {
                textView.setText(downloadEpisode.getShows_info());
            }
            C1100d.m5641a().m5644a(downloadEpisode.getPoster(), imageView);
            inflate.setTag(Long.valueOf(downloadEpisode.getEpisode_id()));
            inflate.findViewById(R.id.btn_cancel).setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2834c f11305b;

                /* compiled from: DownloadLibFragment */
                /* renamed from: com.tdo.showbox.b.c$4$1 */
                class C28301 implements DialogInterface.OnClickListener {
                    /* renamed from: a */
                    final /* synthetic */ C28314 f11303a;

                    C28301(C28314 c28314) {
                        this.f11303a = c28314;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            if (this.f11303a.f11305b.f11319j != null) {
                                this.f11303a.f11305b.f11319j.dismiss();
                            }
                        } catch (Exception e) {
                        }
                        try {
                            long longValue = ((Long) inflate.getTag()).longValue();
                            this.f11303a.f11305b.f11317h.removeView(inflate);
                            this.f11303a.f11305b.f11315f.remove(inflate);
                            DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + longValue).executeSingle();
                            if (downloadEpisode != null) {
                                downloadEpisode.setDeleted(1);
                                downloadEpisode.save();
                            }
                            this.f11303a.f11305b.m15484h().m15177x().m16800a(downloadEpisode).m16818e();
                            this.f11303a.f11305b.m15484h().m15177x().m16800a(downloadEpisode).m16812b();
                            if (this.f11303a.f11305b.f11314e.size() == 0 && this.f11303a.f11305b.f11315f.size() == 0) {
                                this.f11303a.f11305b.f11320k.setText(this.f11303a.f11305b.m15484h().getString(R.string.lib_downloads_empty));
                                this.f11303a.f11305b.f11320k.setVisibility(0);
                            }
                        } catch (Exception e2) {
                        }
                    }
                }

                public void onClick(View view) {
                    Builder builder = new Builder(this.f11305b.m15484h());
                    builder.setMessage(this.f11305b.getString(R.string.delete_alert));
                    builder.setPositiveButton(this.f11305b.getString(R.string.yes), new C28301(this));
                    builder.setNegativeButton(this.f11305b.m15484h().getString(R.string.cancel), null);
                    this.f11305b.f11319j = builder.show();
                }
            });
            final Button button = (Button) inflate.findViewById(R.id.btn_pause);
            button.setText(m15484h().getString(R.string.download_resume));
            final C2755a c28325 = new C2755a(this) {
                /* renamed from: c */
                final /* synthetic */ C2834c f11308c;

                /* renamed from: f */
                public void mo2044f(DownloadEpisode downloadEpisode) {
                    button.setVisibility(0);
                    if (downloadEpisode.getStatus() == 3) {
                        button.setText(this.f11308c.m15484h().getString(R.string.download_resume));
                    } else if (downloadEpisode.getStatus() == 1 || downloadEpisode.getStatus() == 0) {
                        button.setText(this.f11308c.m15484h().getString(R.string.download_start));
                        ((TextView) inflate.findViewById(R.id.txtv_download_info)).setText(this.f11308c.m15484h().getString(R.string.download_waiting));
                    } else if (downloadEpisode.getStatus() == 4) {
                        button.setVisibility(4);
                        ((TextView) inflate.findViewById(R.id.txtv_download_info)).setText(this.f11308c.m15484h().getString(R.string.peers_waiting));
                    } else if (downloadEpisode.getStatus() == 5) {
                        button.setVisibility(4);
                        ((TextView) inflate.findViewById(R.id.txtv_download_info)).setText(this.f11308c.m15484h().getString(R.string.torrent_broken));
                    } else {
                        button.setText(this.f11308c.m15484h().getString(R.string.download_pause));
                    }
                }

                /* renamed from: e */
                public void mo2043e(DownloadEpisode downloadEpisode) {
                    this.f11308c.f11316g.setVisibility(0);
                    button.setText(this.f11308c.m15484h().getString(R.string.download_pause));
                }

                /* renamed from: c */
                public void mo2041c(DownloadEpisode downloadEpisode) {
                    button.setText(this.f11308c.m15484h().getString(R.string.download_pause));
                    C3094j.m16698a("DownloadLibFragment", "onResumeMovie");
                }

                /* renamed from: a */
                public void mo2038a(DownloadEpisode downloadEpisode) {
                    this.f11308c.f11316g.setVisibility(0);
                    button.setVisibility(0);
                    ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.load_progress);
                    progressBar.setProgress(downloadEpisode.getPercent());
                    TextView textView = (TextView) inflate.findViewById(R.id.txtv_download_info);
                    int progress = (int) (downloadEpisode.getProgress() / 1000000);
                    long file_size = downloadEpisode.getFile_size() / 1000000;
                    textView.setText(this.f11308c.m15484h().getString(R.string.info_downloaded) + " " + progress + this.f11308c.m15484h().getString(R.string.mb) + " " + this.f11308c.m15484h().getString(R.string.of) + " " + file_size + this.f11308c.m15484h().getString(R.string.mb) + " (" + downloadEpisode.getPercent() + "%)");
                    if (file_size <= 0) {
                        progressBar.setVisibility(4);
                        textView.setText(this.f11308c.m15484h().getString(R.string.info_downloaded) + " : " + progress + this.f11308c.m15484h().getString(R.string.mb));
                        return;
                    }
                    progressBar.setVisibility(0);
                }

                /* renamed from: b */
                public void mo2039b(DownloadEpisode downloadEpisode) {
                    button.setText(this.f11308c.m15484h().getString(R.string.download_resume));
                    C3094j.m16698a("DownloadLibFragment", "onPauseMovie");
                }

                /* renamed from: d */
                public void mo2042d(DownloadEpisode downloadEpisode) {
                    C3094j.m16698a("DownloadLibFragment", "onFinishMovie");
                    this.f11308c.f11315f.remove(inflate);
                    this.f11308c.f11317h.removeView(inflate);
                    try {
                        if (this.f11308c.f11314e == null) {
                            this.f11308c.f11314e = new ArrayList();
                        }
                        this.f11308c.f11314e.add(downloadEpisode);
                        this.f11308c.m15811a();
                        this.f11308c.f11313d.m17022a(this.f11308c.f11314e);
                    } catch (Exception e) {
                    }
                }

                /* renamed from: c */
                public void mo2040c() {
                    if (((DownloadEpisode) new Select().from(DownloadEpisode.class).where("percent!=100").executeSingle()) == null) {
                        C3094j.m16698a("DownloadLibFragment", "onFinishAll");
                        this.f11308c.f11316g.setVisibility(8);
                        this.f11308c.f11317h.removeAllViews();
                        this.f11308c.f11315f.clear();
                    }
                }
            };
            button.setOnClickListener(new OnClickListener(this) {
                /* renamed from: c */
                final /* synthetic */ C2834c f11311c;

                public void onClick(View view) {
                    DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + downloadEpisode.getEpisode_id()).executeSingle();
                    if (downloadEpisode.getStatus() == 3 || downloadEpisode.getStatus() == 1 || downloadEpisode.getStatus() == 0) {
                        this.f11311c.m15484h().m15177x().m16800a(downloadEpisode).m16809a(c28325).m16810a();
                        return;
                    }
                    downloadEpisode.setIs_downloading(0);
                    downloadEpisode.setStatus(3);
                    downloadEpisode.save();
                    this.f11311c.m15484h().m15177x().m16800a(downloadEpisode).m16809a(c28325).m16816d();
                }
            });
            try {
                m15484h().m15177x().m16800a(downloadEpisode).m16809a(c28325).m16820f();
                m15484h().m15177x().m16800a(downloadEpisode).m16809a(c28325).m16822g();
                if (downloadEpisode.getStatus() == 2) {
                    m15484h().m15177x().m16800a(downloadEpisode).m16809a(c28325).m16810a();
                }
                this.f11317h.addView(inflate, 0);
                this.f11315f.add(inflate);
            } catch (Exception e) {
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDestroy() {
        C3124f.m16796a();
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 123) {
            try {
                int intExtra = intent.getIntExtra("ARG_VIDEO_POSITION", 0);
                long longExtra = intent.getLongExtra("ARG_ID", 0);
                int intExtra2 = intent.getIntExtra("ARG_VIDEO_PART_NUMBER", 0);
                DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + longExtra).executeSingle();
                downloadEpisode.setView_position((long) intExtra);
                downloadEpisode.setPart_progress((long) intExtra);
                downloadEpisode.setPart_last_number(intExtra2);
                downloadEpisode.save();
                for (DownloadEpisode downloadEpisode2 : this.f11314e) {
                    if (downloadEpisode2.getEpisode_id() == longExtra) {
                        downloadEpisode2.setView_position((long) intExtra);
                        downloadEpisode2.setPart_progress((long) intExtra);
                        downloadEpisode2.setPart_last_number(intExtra2);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11321l;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11321l;
    }
}
