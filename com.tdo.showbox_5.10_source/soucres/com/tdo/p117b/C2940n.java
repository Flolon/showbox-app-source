package com.tdo.showbox.p117b;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2727j;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p112c.C2754b;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p119b.p120a.C3031c;
import com.tdo.showbox.data.p119b.p120a.C3031c.C2747a;
import com.tdo.showbox.models.Category;
import com.tdo.showbox.models.Trailer;
import com.tdo.showbox.models.TrailerDetails;
import com.tdo.showbox.models.TrailerDetailsItem;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.p121g.C3239o;
import com.tdo.showbox.p131f.C3174c;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3182i;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import java.net.URL;

/* compiled from: TrailerDetailsFragment */
/* renamed from: com.tdo.showbox.b.n */
public class C2940n extends C2769a implements OnItemClickListener {
    /* renamed from: c */
    private ImageView f11645c;
    /* renamed from: d */
    private ImageView f11646d;
    /* renamed from: e */
    private String f11647e;
    /* renamed from: f */
    private C3239o f11648f;
    /* renamed from: g */
    private View f11649g;
    /* renamed from: h */
    private ExtListView f11650h;
    /* renamed from: i */
    private View f11651i;
    /* renamed from: j */
    private Bitmap f11652j;
    /* renamed from: k */
    private FrameLayout f11653k;
    /* renamed from: l */
    private C3031c f11654l;
    /* renamed from: m */
    private boolean f11655m;
    /* renamed from: n */
    private TextView f11656n;
    /* renamed from: o */
    private TextView f11657o;
    /* renamed from: p */
    private View f11658p;
    /* renamed from: q */
    private View f11659q;
    /* renamed from: r */
    private View f11660r;
    /* renamed from: s */
    private TrailerDetails f11661s;
    /* renamed from: t */
    private Trailer f11662t;
    /* renamed from: u */
    private C3074a f11663u;
    /* renamed from: v */
    private C2727j f11664v = new C2727j();
    /* renamed from: w */
    private View f11665w;
    /* renamed from: x */
    private TextView f11666x;
    /* renamed from: y */
    private TextView f11667y;

    /* compiled from: TrailerDetailsFragment */
    /* renamed from: com.tdo.showbox.b.n$1 */
    class C29331 implements C2747a {
        /* renamed from: a */
        final /* synthetic */ C2940n f11637a;

        C29331(C2940n c2940n) {
            this.f11637a = c2940n;
        }

        /* renamed from: a */
        public void mo2032a() {
            if (this.f11637a.f11653k != null && this.f11637a.m16135b().m16433b() != null) {
                this.f11637a.f11653k.removeAllViews();
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                int dimensionPixelSize = this.f11637a.m15484h().getResources().getDimensionPixelSize(R.dimen.ad_rect_padding_top_bottom);
                layoutParams.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                layoutParams.gravity = 17;
                this.f11637a.f11653k.addView(this.f11637a.m16135b().m16433b(), layoutParams);
                this.f11637a.m16138c();
            }
        }
    }

    /* compiled from: TrailerDetailsFragment */
    /* renamed from: com.tdo.showbox.b.n$2 */
    class C29342 implements C2746a {
        /* renamed from: a */
        final /* synthetic */ C2940n f11638a;

        C29342(C2940n c2940n) {
            this.f11638a = c2940n;
        }

        /* renamed from: a */
        public void mo2031a() {
            this.f11638a.f11650h.m17205a();
            this.f11638a.m16135b().m16438g();
        }
    }

    /* compiled from: TrailerDetailsFragment */
    /* renamed from: com.tdo.showbox.b.n$3 */
    class C29363 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2940n f11640a;

        /* compiled from: TrailerDetailsFragment */
        /* renamed from: com.tdo.showbox.b.n$3$1 */
        class C29351 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C29363 f11639a;

            C29351(C29363 c29363) {
                this.f11639a = c29363;
            }

            public void run() {
                this.f11639a.f11640a.f11646d.setImageBitmap(this.f11639a.f11640a.f11652j);
            }
        }

        C29363(C2940n c2940n) {
            this.f11640a = c2940n;
        }

        public void run() {
            try {
                this.f11640a.f11652j = C3174c.m16959a(BitmapFactory.decodeStream(new URL(this.f11640a.f11662t.getPoster()).openStream()), 60);
                this.f11640a.m15484h().runOnUiThread(new C29351(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: TrailerDetailsFragment */
    /* renamed from: com.tdo.showbox.b.n$4 */
    class C29374 implements C2754b {
        /* renamed from: a */
        final /* synthetic */ C2940n f11641a;

        C29374(C2940n c2940n) {
            this.f11641a = c2940n;
        }

        /* renamed from: b */
        public void mo2036b(String str) {
        }

        /* renamed from: a */
        public void mo2035a(String str) {
            this.f11641a.m16134a(str);
        }

        /* renamed from: c */
        public void mo2037c(String str) {
            this.f11641a.m16134a(str);
        }
    }

    /* compiled from: TrailerDetailsFragment */
    /* renamed from: com.tdo.showbox.b.n$6 */
    class C29396 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2940n f11644a;

        C29396(C2940n c2940n) {
            this.f11644a = c2940n;
        }

        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            if (!this.f11644a.f11655m) {
                this.f11644a.f11661s = ObjParser.m16288f(str, this.f11644a.f11647e);
                if (this.f11644a.f11661s == null) {
                    Toast.makeText(this.f11644a.m15484h(), R.string.alert_server_error, 0).show();
                    this.f11644a.m16140c(false);
                    return;
                }
                this.f11644a.f11661s.save();
                this.f11644a.m16154n();
            }
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (!this.f11644a.f11655m) {
                this.f11644a.m16140c(false);
                Toast.makeText(this.f11644a.m15484h(), R.string.alert_server_error, 0).show();
            }
        }
    }

    /* renamed from: a */
    public static C2940n m16129a(Context context, String str) {
        C2940n c2940n = new C2940n();
        if (context.getResources().getBoolean(R.bool.portrait_only)) {
            c2940n.m15479b(true);
        } else {
            c2940n.m15479b(false);
        }
        Bundle bundle = new Bundle();
        bundle.putString("ARG_ID", str);
        c2940n.setArguments(bundle);
        return c2940n;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f11647e = getArguments().getString("ARG_ID");
            this.f11662t = (Trailer) new Select().from(Trailer.class).where("trailer_id='" + this.f11647e + "'").executeSingle();
        } catch (Exception e) {
            this.f11647e = "";
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11655m = false;
        return m16127a(layoutInflater);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (m15484h().m15148L()) {
            m16151l();
        }
        m16155o();
        m16147j();
    }

    public void onResume() {
        super.onResume();
        if (m15484h().m15148L()) {
            m16135b().m16436e();
            m16135b().m16431a(new C29331(this));
        }
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m16135b().m16437f();
            if (this.f11653k != null) {
                this.f11653k.removeAllViews();
            }
        }
    }

    /* renamed from: b */
    private C3031c m16135b() {
        if (this.f11654l == null) {
            this.f11654l = new C3031c("native_trailer_details");
        }
        return this.f11654l;
    }

    /* renamed from: c */
    private void m16138c() {
        this.f11650h.m17206a(this.f11653k, new C29342(this));
    }

    /* renamed from: j */
    private void m16147j() {
        if (m15484h().m15148L()) {
            m16135b().m16429a(m15484h(), (UserInfo) new Select().from(UserInfo.class).executeSingle());
        }
    }

    /* renamed from: k */
    private void m16150k() {
        C3065b.m16568a("trailers_details");
        this.f11667y.setText(m15484h().getString(R.string.trailer_release_date) + " " + this.f11661s.getRelease_info());
        this.f11657o.setText(this.f11661s.getDescription());
        this.f11656n.setText(this.f11662t.getTitle());
        try {
            String[] split = this.f11661s.getCats().split("#");
            if (split.length == 0) {
                throw new Exception();
            }
            boolean z;
            int i = 0;
            CharSequence charSequence = "";
            while (i < split.length) {
                String str = charSequence + ((Category) new Select().from(Category.class).where("cat_id=" + split[i]).executeSingle()).getName();
                if (i != split.length - 1) {
                    str = str + ", ";
                }
                i++;
                Object obj = str;
            }
            this.f11666x.setText(charSequence);
            MainActivity h = m15484h();
            TrailerDetails trailerDetails = this.f11661s;
            if (m15484h().m15148L()) {
                z = false;
            } else {
                z = true;
            }
            this.f11648f = new C3239o(h, trailerDetails, z, m16156p());
            this.f11650h.addHeaderView(this.f11649g);
            this.f11650h.setAdapter(this.f11648f);
            this.f11648f.notifyDataSetChanged();
            this.f11648f.m17004a(this);
            ((LinearLayout) this.f11649g.findViewById(R.id.info_content_container)).addView(this.f11665w);
        } catch (Exception e) {
            this.f11666x.setVisibility(8);
        }
    }

    /* renamed from: a */
    private View m16127a(LayoutInflater layoutInflater) {
        this.a = layoutInflater.inflate(R.layout.frgm_trailer_details, null);
        this.f11649g = layoutInflater.inflate(R.layout.header_frgm_trailer_details, null);
        this.f11665w = layoutInflater.inflate(R.layout.view_movie_info, null);
        this.f11650h = (ExtListView) this.a.findViewById(R.id.list_view);
        this.f11650h.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11653k = (FrameLayout) this.f11649g.findViewById(R.id.rect_ad);
        this.f11646d = (ImageView) this.a.findViewById(R.id.imgv_background);
        this.f11651i = this.f11649g.findViewById(R.id.view_progress_center);
        if (m15484h().m15148L()) {
            this.f11660r = this.f11649g.findViewById(R.id.poster_container);
            this.f11645c = (ImageView) this.f11649g.findViewById(R.id.imgv_poster);
            this.f11665w.findViewById(R.id.txtv_watch_trailer).setVisibility(4);
        } else {
            this.f11660r = this.a.findViewById(R.id.poster_container);
            this.f11645c = (ImageView) this.a.findViewById(R.id.imgv_poster);
            this.f11665w.findViewById(R.id.txtv_watch_trailer).setVisibility(8);
        }
        this.f11659q = this.f11649g.findViewById(R.id.descr_container);
        this.f11658p = this.a.findViewById(R.id.view_root_progress_center);
        this.f11657o = (TextView) this.f11665w.findViewById(R.id.description_view);
        this.f11656n = (TextView) this.f11665w.findViewById(R.id.name_view);
        this.f11666x = (TextView) this.f11665w.findViewById(R.id.category_view);
        this.f11667y = (TextView) this.f11665w.findViewById(R.id.year_view);
        return this.a;
    }

    /* renamed from: l */
    private void m16151l() {
        String a = m15484h().m15139C().m16629a(this.f11662t.getPoster());
        if (a != null) {
            this.f11652j = C3174c.m16959a(BitmapFactory.decodeFile(a), 60);
            this.f11646d.setImageBitmap(this.f11652j);
        } else if (C3178f.m16973b(m15484h())) {
            m16153m();
        }
    }

    /* renamed from: m */
    private void m16153m() {
        new Thread(new C29363(this)).start();
    }

    /* renamed from: a */
    private void m16133a(TrailerDetails trailerDetails) {
        m16150k();
        m16140c(false);
    }

    /* renamed from: n */
    private void m16154n() {
        if (this.f11661s.getPoster_hires() == null || this.f11661s.getPoster_hires().length() == 0) {
            m16134a("");
            this.f11645c.setVisibility(8);
            this.f11660r.setVisibility(8);
            return;
        }
        m16158a().m16636a(new C29374(this));
        m16158a().m16643d((int) R.drawable.im_trans_back);
        m16158a().m16635a(this.f11645c, this.f11661s.getPoster_hires());
    }

    /* renamed from: a */
    private void m16134a(final String str) {
        m15484h().runOnUiThread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C2940n f11643b;

            public void run() {
                if (!(this.f11643b.f11661s == null || this.f11643b.f11651i == null || this.f11643b.f11661s.getPoster_hires() == null || !this.f11643b.f11661s.getPoster_hires().equals(str))) {
                    this.f11643b.f11651i.setVisibility(8);
                }
                this.f11643b.m16133a(this.f11643b.f11661s);
            }
        });
    }

    /* renamed from: c */
    private void m16140c(boolean z) {
        if (z) {
            this.f11658p.setVisibility(0);
            this.f11650h.setVisibility(4);
            return;
        }
        this.f11658p.setVisibility(8);
        this.f11650h.setVisibility(0);
    }

    /* renamed from: o */
    private void m16155o() {
        this.f11661s = (TrailerDetails) new Select().from(TrailerDetails.class).where("trailer_id='" + this.f11647e + "'").executeSingle();
        if (this.f11661s != null) {
            m16154n();
        } else if (C3178f.m16973b(m15484h())) {
            m16140c(true);
            m15484h().m15142F().m16344c(this.f11647e, new C29396(this));
        } else {
            Toast.makeText(m15484h(), R.string.error_connection, 0).show();
        }
    }

    public void onDestroy() {
        if (m15484h().m15148L()) {
            m16135b().m16435d();
        }
        this.f11655m = true;
        m15484h().m15137A().m16641c();
        try {
            this.f11663u.m16639b();
            this.f11663u = null;
        } catch (Exception e) {
        }
        m16158a().m16636a(null);
        try {
            this.f11650h.setAdapter(null);
            this.f11652j.recycle();
            this.f11652j = null;
        } catch (Exception e2) {
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!m15484h().m15148L()) {
            this.f11648f = new C3239o(m15484h(), this.f11661s, !m15484h().m15148L(), m16156p());
            this.f11650h.setAdapter(this.f11648f);
            this.f11648f.m17004a(this);
            this.f11648f.notifyDataSetChanged();
        }
    }

    /* renamed from: p */
    private int m16156p() {
        if (m15484h().getResources().getConfiguration().orientation == 2) {
            return 2;
        }
        return 1;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11664v;
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11664v;
    }

    /* renamed from: a */
    protected C3074a m16158a() {
        if (this.f11663u == null) {
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            animationSet.addAnimation(alphaAnimation);
            this.f11663u = new C3074a(m15484h());
            this.f11663u.m16642c(1);
            animationSet = new AnimationSet(true);
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(600);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(600);
            animationSet2.addAnimation(alphaAnimation2);
            this.f11663u.m16633a(animationSet, animationSet2);
            this.f11663u.m16643d((int) R.drawable.ic_poster_stub_movie);
        }
        return this.f11663u;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3182i.m16979a(m15484h(), ((TrailerDetailsItem) this.f11661s.getTrailerDetailItems().get(i)).getLink());
        C3065b.m16568a("trailers_play");
    }
}
