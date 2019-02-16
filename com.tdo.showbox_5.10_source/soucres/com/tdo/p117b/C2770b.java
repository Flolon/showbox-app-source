package com.tdo.showbox.p117b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.torrent.C3139a;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.MovieItemMeta;
import com.tdo.showbox.p117b.p118a.C2772a;
import com.tdo.showbox.p129e.p130a.C3167a;
import java.util.Calendar;
import java.util.Random;

/* compiled from: BaseMovieDetailsFragment */
/* renamed from: com.tdo.showbox.b.b */
public class C2770b extends C2769a {
    /* renamed from: c */
    protected String f11097c;
    /* renamed from: d */
    protected MovieItem f11098d;
    /* renamed from: e */
    protected boolean f11099e;
    /* renamed from: f */
    protected String f11100f;
    /* renamed from: g */
    protected boolean f11101g;
    /* renamed from: h */
    private C3074a f11102h;
    /* renamed from: i */
    private C3139a f11103i;

    /* compiled from: BaseMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.b$1 */
    class C28221 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2770b f11293a;

        C28221(C2770b c2770b) {
            this.f11293a = c2770b;
        }

        public void onSuccess(String str) {
            super.onSuccess(str);
            C3094j.m16698a("set rating", "onSuccess, movie " + str);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            C3094j.m16698a("set rating", "onFail, movie " + str);
        }
    }

    /* compiled from: BaseMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.b$2 */
    class C28232 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2770b f11294a;

        C28232(C2770b c2770b) {
            this.f11294a = c2770b;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C3167a.m16903a().m16924d();
        }
    }

    /* compiled from: BaseMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.b$3 */
    class C28243 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2770b f11295a;

        C28243(C2770b c2770b) {
            this.f11295a = c2770b;
        }

        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            C3094j.m16698a("MovieDetailsFragment", "marked success: " + str);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            C3094j.m16698a("MovieDetailsFragment", "marked fail: " + str);
        }
    }

    /* renamed from: a */
    public static C2769a m15486a(Activity activity, String str, boolean z, boolean z2) {
        C2769a c2772a;
        if (activity.getResources().getBoolean(R.bool.portrait_only)) {
            c2772a = new C2772a();
            c2772a.m15479b(true);
        } else {
            c2772a = new C2932m();
            c2772a.m15479b(false);
        }
        Bundle bundle = new Bundle();
        bundle.putString("ARG_ID", str);
        bundle.putBoolean("ARG_NEED_REMOVE", z);
        bundle.putBoolean("ARG_BOOL", z2);
        c2772a.setArguments(bundle);
        return c2772a;
    }

    /* renamed from: j */
    protected C3139a m15489j() {
        if (this.f11103i == null) {
            this.f11103i = new C3139a(m15484h().m15142F());
        }
        return this.f11103i;
    }

    /* renamed from: k */
    protected void m15490k() {
        if (new Random().nextInt(6) + 1 == 1) {
            m15484h().m15142F().m16345c(this.f11097c, "MOVIE", new C28221(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f11097c = getArguments().getString("ARG_ID");
        } catch (Exception e) {
            this.f11097c = "";
        }
        try {
            this.f11099e = getArguments().getBoolean("ARG_NEED_REMOVE", false);
        } catch (Exception e2) {
            this.f11099e = false;
        }
        try {
            this.f11101g = getArguments().getBoolean("ARG_BOOL", false);
        } catch (Exception e3) {
            this.f11101g = false;
        }
        try {
            this.f11100f = getArguments().getString("ARG_TITLE");
        } catch (Exception e4) {
            this.f11100f = m15484h().getString(R.string.back_upper);
        }
    }

    /* renamed from: l */
    public void m15491l() {
        Builder builder = new Builder(m15484h());
        builder.setMessage(m15484h().getString(R.string.info_item_loaded));
        builder.setPositiveButton(m15484h().getString(R.string.ok), null);
        builder.show();
    }

    /* renamed from: m */
    protected C3074a m15492m() {
        if (this.f11102h == null) {
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            animationSet.addAnimation(alphaAnimation);
            this.f11102h = new C3074a(m15484h());
            this.f11102h.m16642c(1);
            animationSet = new AnimationSet(true);
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(600);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(600);
            animationSet2.addAnimation(alphaAnimation2);
            this.f11102h.m16633a(animationSet, animationSet2);
            this.f11102h.m16643d((int) R.drawable.ic_poster_stub_movie);
        }
        return this.f11102h;
    }

    /* renamed from: a */
    public boolean m15488a(MovieItem movieItem) {
        if (movieItem == null) {
            return true;
        }
        MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(movieItem);
        long last_cached_time = movieItemMeta.getLast_cached_time();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (last_cached_time + 3600000 >= timeInMillis) {
            return false;
        }
        movieItemMeta.setLast_cached_time(timeInMillis);
        movieItemMeta.save();
        return true;
    }

    /* renamed from: n */
    protected void m15493n() {
        if (getActivity() != null) {
            Builder builder = new Builder(m15484h());
            builder.setCancelable(false);
            builder.setPositiveButton(m15484h().getString(R.string.close), new C28232(this));
            builder.setMessage(m15484h().getString(R.string.error_server));
            builder.show();
        }
    }

    public void onDestroy() {
        m15484h().m15137A().m16641c();
        try {
            this.f11102h.m16639b();
            this.f11102h = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 123) {
            try {
                int intExtra = intent.getIntExtra("ARG_VIDEO_POSITION", 0);
                long longExtra = intent.getLongExtra("ARG_ID", 0);
                MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(this.f11098d);
                movieItemMeta.setMovie_progress((long) intExtra);
                movieItemMeta.save();
                DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + longExtra).executeSingle();
                if (downloadEpisode != null) {
                    downloadEpisode.setView_position((long) intExtra);
                    downloadEpisode.save();
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    protected void m15487a(MovieItem movieItem, String str) {
        C3094j.m16698a("MovieDetailsFragment", "markTorrentBroken");
        m15484h().m15142F().m16336a(movieItem.getMovieId(), "movie", str, "", "", new C28243(this));
    }
}
