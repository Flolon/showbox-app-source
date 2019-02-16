package com.tdo.showbox.activities;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p131f.C3180g;
import com.tdo.showbox.p131f.C3182i;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.vlc.PlayerVTorrentActivity;
import java.io.File;
import java.util.Calendar;

/* compiled from: BaseActivity */
/* renamed from: com.tdo.showbox.activities.b */
public class C2632b extends C2631a {
    /* renamed from: b */
    private ProgressDialog f10752b;
    /* renamed from: c */
    private ProgressDialog f10753c;

    /* compiled from: BaseActivity */
    /* renamed from: com.tdo.showbox.activities.b$1 */
    class C27421 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2632b f11048a;

        C27421(C2632b c2632b) {
            this.f11048a = c2632b;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f11048a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.mxtech.videoplayer.ad")));
            } catch (Exception e) {
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        if (C3088f.m16684c("PREFS_BANNER_HEIGHT") == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = (int) (((float) i) / 6.3f);
            i2 = C3184j.m16980a((Context) this, 50);
            C3088f.m16677a("PREFS_SCREEN_WIDTH", i);
            C3088f.m16677a("PREFS_BANNER_HEIGHT", i2);
        }
        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    /* renamed from: i */
    protected void mo2006i() {
    }

    /* renamed from: a */
    public void m15090a(boolean z) {
        try {
            if (this.f10753c != null) {
                this.f10753c.dismiss();
                this.f10753c = null;
            }
        } catch (Exception e) {
        }
        if (z) {
            try {
                if (this.f10753c == null) {
                    this.f10753c = ProgressDialog.show(this, "", "");
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public void m15085a(String str) {
        try {
            if (this.f10752b == null) {
                this.f10752b = ProgressDialog.show(this, "", str);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: j */
    public void m15093j() {
        try {
            if (this.f10752b != null) {
                this.f10752b.dismiss();
                this.f10752b = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m15089a(String str, Subtitle subtitle, String str2, double d, int i, int i2, String str3) {
        Intent intent = new Intent(this, PlayerVTorrentActivity.class);
        intent.putExtra("uri", str);
        intent.putExtra("subtitle", subtitle);
        intent.putExtra("ARG_TITLE", str2);
        intent.putExtra("ARG_SEASON", i);
        intent.putExtra("ARG_EPIZOD_ID", i2);
        intent.putExtra("ARG_DOUBLE", d);
        intent.putExtra("ARG_URL", str3);
        startActivity(intent);
    }

    /* renamed from: a */
    public void mo2003a(String str, long j, long j2, boolean z, Bundle bundle, String str2, Subtitle subtitle) {
        BaseVideoSource videoSource;
        int i;
        String str3;
        if (bundle.getInt("ARG_TYPE_PLAY") == 1) {
            try {
                Episod episod = (Episod) new Select().from(Episod.class).where("ID=" + j).executeSingle();
                if (episod != null) {
                    videoSource = episod.getVideoSource();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            videoSource = null;
        } else {
            MovieItem movieItem = (MovieItem) new Select().from(MovieItem.class).where("Id=" + j).executeSingle();
            if (movieItem != null) {
                videoSource = MovieItem.getMovieItemMeta(movieItem).getVideoSource();
            }
            videoSource = null;
        }
        int b = C3088f.m16681b("PREFS_PLAYER_MODE", 1);
        if (videoSource != null) {
            str = str.replace("https://", "http://");
            if (videoSource.getSource_mode_id() == 10 && C3180g.m16975b() && b == 1) {
                i = 0;
                str3 = str;
                if (i == 0) {
                    m15091b(str3, j, j2, bundle, str2);
                } else if (i != 1) {
                    m15086a(str3, j, j2, bundle, str2);
                } else {
                    m15088a(str3, j, z, bundle, str2, subtitle);
                }
            }
        }
        i = b;
        str3 = str;
        if (i == 0) {
            m15091b(str3, j, j2, bundle, str2);
        } else if (i != 1) {
            m15088a(str3, j, z, bundle, str2, subtitle);
        } else {
            m15086a(str3, j, j2, bundle, str2);
        }
    }

    /* renamed from: a */
    public void m15086a(String str, long j, long j2, Bundle bundle, String str2) {
        Intent intent = new Intent(this, VideoPlayerIjkActivity.class);
        intent.putExtra("VIDEO_URL", str);
        intent.putExtra("ARG_ID", j);
        intent.putExtra("ARG_VIDEO_POSITION", j2);
        intent.putExtra("ARG_BUNDLE", bundle);
        startActivityForResult(intent, 123);
    }

    /* renamed from: b */
    public void m15091b(String str, long j, long j2, Bundle bundle, String str2) {
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        intent.putExtra("VIDEO_URL", str);
        intent.putExtra("ARG_ID", j);
        intent.putExtra("ARG_VIDEO_POSITION", j2);
        intent.putExtra("ARG_BUNDLE", bundle);
        startActivityForResult(intent, 123);
    }

    /* renamed from: a */
    public void m15088a(String str, long j, boolean z, Bundle bundle, String str2, Subtitle subtitle) {
        BaseVideoSource baseVideoSource = null;
        try {
            Uri fromFile;
            if (bundle.getInt("ARG_TYPE_PLAY") == 1) {
                Episod episod = (Episod) new Select().from(Episod.class).where("ID=" + j).executeSingle();
                if (episod != null) {
                    baseVideoSource = episod.getVideoSource();
                }
            } else {
                MovieItem movieItem = (MovieItem) new Select().from(MovieItem.class).where("Id=" + j).executeSingle();
                if (movieItem != null) {
                    baseVideoSource = MovieItem.getMovieItemMeta(movieItem).getVideoSource();
                }
            }
            if (z) {
                fromFile = Uri.fromFile(new File(str));
            } else {
                fromFile = Uri.parse(str);
            }
            Intent intent = new Intent("android.intent.action.VIEW", fromFile);
            intent.setDataAndType(fromFile, "video/*");
            if (!(baseVideoSource == null || baseVideoSource.getCookies() == null || baseVideoSource.getCookies().length() <= 0)) {
                String cookies = baseVideoSource.getCookies();
                intent.putExtra("headers", new String[]{"Cookie", cookies});
                C3094j.m16698a("ext player", "cookies: " + cookies);
                Bundle bundle2 = new Bundle();
                bundle2.putString("Cookie", cookies);
                intent.putExtra("android.media.intent.extra.HTTP_HEADERS", bundle2);
            }
            if (subtitle != null) {
                fromFile = Uri.fromFile(new File(subtitle.getFile_en()));
                intent.putExtra("subs", new Parcelable[]{fromFile});
                intent.putExtra("subs.enable", new Parcelable[]{fromFile});
            }
            Intent a = C3182i.m16978a((Context) this, intent);
            if (a == null) {
                Builder builder = new Builder(this);
                builder.setMessage(getString(R.string.error_external_player));
                builder.setCancelable(true);
                builder.setPositiveButton(R.string.ok, new C27421(this));
                builder.setNegativeButton(R.string.cancel, null);
                builder.show();
                return;
            }
            startActivityForResult(a, 1113);
        } catch (Exception e) {
        }
    }

    /* renamed from: k */
    public void m15094k() {
        Builder builder = new Builder(this);
        builder.setPositiveButton(getString(R.string.close), null);
        builder.setMessage(getString(R.string.alert_video_not_avalable));
        builder.show();
    }

    /* renamed from: l */
    public boolean m15095l() {
        int c = C3088f.m16684c("VIDEO_VIEWED");
        int c2 = C3088f.m16684c("PREFS_VIDEO_DAY");
        int i = Calendar.getInstance().get(5);
        if (c2 != i) {
            C3088f.m16677a("PREFS_VIDEO_DAY", i);
            C3088f.m16677a("VIDEO_VIEWED", 0);
            c = 0;
        }
        if (c > 50) {
            Builder builder = new Builder(this);
            builder.setMessage(getString(R.string.alert_limit_viewed));
            builder.setPositiveButton(getString(R.string.ok), null);
            builder.show();
            return true;
        }
        C3088f.m16677a("VIDEO_VIEWED", c + 1);
        return false;
    }
}
