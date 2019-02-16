package com.tdo.showbox.p117b;

import android.content.res.Configuration;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.activeandroid.query.Select;
import com.tdo.showbox.ParsersFuck;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.NewsDetailsActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2734l;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C3016f;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p124a.C2985h;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.News;
import com.tdo.showbox.models.Trailer;
import com.tdo.showbox.models.TrendingResponse;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.p117b.C2963p;
import com.tdo.showbox.p121g.p122c.C3206a;
import com.tdo.showbox.p121g.p122c.C3209b;
import com.tdo.showbox.p121g.p122c.C3209b.C2951a;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3180g;
import com.tdo.showbox.views.hrecyclerviewparalax.ParallaxRecyclerView;
import java.util.List;

/* compiled from: TrendingFragment */
/* renamed from: com.tdo.showbox.b.p */
public class C2963p extends C2769a {
    /* renamed from: A */
    private ParallaxRecyclerView f11719A;
    /* renamed from: B */
    private C3209b<Trailer> f11720B;
    /* renamed from: C */
    private View f11721C;
    /* renamed from: D */
    private View f11722D;
    /* renamed from: E */
    private ParallaxRecyclerView f11723E;
    /* renamed from: F */
    private C3209b<MovieItem> f11724F;
    /* renamed from: G */
    private View f11725G;
    /* renamed from: H */
    private View f11726H;
    /* renamed from: I */
    private ParallaxRecyclerView f11727I;
    /* renamed from: J */
    private C3209b<TvItem> f11728J;
    /* renamed from: K */
    private LinearLayoutManager f11729K;
    /* renamed from: L */
    private LinearLayoutManager f11730L;
    /* renamed from: M */
    private LinearLayoutManager f11731M;
    /* renamed from: N */
    private ScrollView f11732N;
    /* renamed from: O */
    private LinearLayout f11733O;
    /* renamed from: P */
    private LinearLayout f11734P;
    /* renamed from: Q */
    private LinearLayout f11735Q;
    /* renamed from: R */
    private int f11736R;
    /* renamed from: S */
    private int f11737S;
    /* renamed from: T */
    private int f11738T;
    /* renamed from: U */
    private int f11739U;
    /* renamed from: V */
    private View f11740V;
    /* renamed from: W */
    private int f11741W;
    /* renamed from: X */
    private PointF f11742X;
    /* renamed from: c */
    private C2734l f11743c = new C2734l();
    /* renamed from: d */
    private C3074a f11744d;
    /* renamed from: e */
    private boolean f11745e;
    /* renamed from: f */
    private View f11746f;
    /* renamed from: g */
    private ScrollView f11747g;
    /* renamed from: h */
    private View f11748h;
    /* renamed from: i */
    private View f11749i;
    /* renamed from: j */
    private ListView f11750j;
    /* renamed from: k */
    private C3206a f11751k;
    /* renamed from: l */
    private View f11752l;
    /* renamed from: m */
    private View f11753m;
    /* renamed from: n */
    private ListView f11754n;
    /* renamed from: o */
    private C3206a f11755o;
    /* renamed from: p */
    private Integer f11756p;
    /* renamed from: q */
    private Integer f11757q;
    /* renamed from: r */
    private Integer f11758r;
    /* renamed from: s */
    private Integer f11759s;
    /* renamed from: t */
    private Integer f11760t;
    /* renamed from: u */
    private Integer f11761u;
    /* renamed from: v */
    private Integer f11762v;
    /* renamed from: w */
    private Integer f11763w;
    /* renamed from: x */
    private TrendingResponse f11764x;
    /* renamed from: y */
    private View f11765y;
    /* renamed from: z */
    private View f11766z;

    /* compiled from: TrendingFragment */
    /* renamed from: com.tdo.showbox.b.p$2 */
    class C29532 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2963p f11703a;

        C29532(C2963p c2963p) {
            this.f11703a = c2963p;
        }

        public void onClick(View view) {
            if (this.f11703a.f11745e) {
                C3167a.m16903a().m16933m();
            } else {
                C3167a.m16903a().m16928h();
            }
        }
    }

    /* compiled from: TrendingFragment */
    /* renamed from: com.tdo.showbox.b.p$3 */
    class C29543 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2963p f11704a;

        C29543(C2963p c2963p) {
            this.f11704a = c2963p;
        }

        public void run() {
            if (this.f11704a.f11756p != null) {
                this.f11704a.f11747g.scrollTo(0, this.f11704a.f11756p.intValue());
                if (!(this.f11704a.f11758r == null || this.f11704a.f11759s == null || this.f11704a.f11729K == null)) {
                    this.f11704a.f11729K.m3537a(this.f11704a.f11758r.intValue(), this.f11704a.f11759s.intValue());
                }
                if (!this.f11704a.f11745e) {
                    if (!(this.f11704a.f11760t == null || this.f11704a.f11761u == null || this.f11704a.f11730L == null)) {
                        this.f11704a.f11730L.m3537a(this.f11704a.f11760t.intValue(), this.f11704a.f11761u.intValue());
                    }
                    if (this.f11704a.f11762v != null && this.f11704a.f11763w != null && this.f11704a.f11731M != null) {
                        this.f11704a.f11731M.m3537a(this.f11704a.f11762v.intValue(), this.f11704a.f11763w.intValue());
                    }
                }
            }
        }
    }

    /* compiled from: TrendingFragment */
    /* renamed from: com.tdo.showbox.b.p$4 */
    class C29574 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2963p f11710a;

        C29574(C2963p c2963p) {
            this.f11710a = c2963p;
        }

        public void onSuccess(String str, String str2, long j) {
            final String str3 = str;
            final String str4 = str2;
            final long j2 = j;
            new Thread(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ C29574 f11709d;

                /* compiled from: TrendingFragment */
                /* renamed from: com.tdo.showbox.b.p$4$1$1 */
                class C29551 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C29561 f11705a;

                    C29551(C29561 c29561) {
                        this.f11705a = c29561;
                    }

                    public void run() {
                        this.f11705a.f11709d.f11710a.m16203a(this.f11705a.f11709d.f11710a.f11764x);
                    }
                }

                public void run() {
                    this.f11709d.f11710a.f11764x = C2985h.m16307a(str3);
                    C3016f.m16398a(str4, j2, str3);
                    this.f11709d.f11710a.m15484h().runOnUiThread(new C29551(this));
                }
            }).start();
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
        }
    }

    /* compiled from: TrendingFragment */
    /* renamed from: com.tdo.showbox.b.p$7 */
    class C29607 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2963p f11715a;

        C29607(C2963p c2963p) {
            this.f11715a = c2963p;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16916a(false);
        }
    }

    /* compiled from: TrendingFragment */
    /* renamed from: com.tdo.showbox.b.p$9 */
    class C29629 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2963p f11718a;

        C29629(C2963p c2963p) {
            this.f11718a = c2963p;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16916a(true);
        }
    }

    /* renamed from: a */
    public static C2963p m16199a() {
        return new C2963p();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_trending, null);
        this.f11736R = -1;
        this.f11737S = -1;
        this.f11738T = m15484h().getResources().getDimensionPixelSize(R.dimen.dimen_0_5);
        this.f11739U = m15484h().getResources().getDimensionPixelSize(R.dimen.dimen_10);
        m16211c();
        this.f11745e = m15484h().m15148L();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        m15484h().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f11741W = displayMetrics.widthPixels;
        if (!this.f11745e) {
            displayMetrics = new DisplayMetrics();
            m15484h().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f11741W = displayMetrics.widthPixels;
            if (m15484h().getResources().getConfiguration().orientation == 2) {
                this.f11741W = -1;
                m16202a(m15484h().getResources().getConfiguration().orientation, true);
            }
        }
        if (getActivity() != null) {
            ParsersFuck.var(getActivity());
        }
        m16225j();
        return this.a;
    }

    /* renamed from: a */
    private PointF m16197a(int i, boolean z, int i2) {
        float f;
        if (z) {
            f = (((float) i) / 1.5f) - ((float) this.f11738T);
        } else if (i2 == 1) {
            f = (((float) i) / 2.5f) - ((float) (this.f11738T * 2));
        } else {
            f = (((((float) i) - ((float) m15484h().getResources().getDimensionPixelSize(R.dimen.trending_tab_left_width))) - ((float) this.f11739U)) / 2.5f) - ((float) (this.f11738T * 2));
        }
        return new PointF(f, 1.45f * f);
    }

    /* renamed from: c */
    private void m16211c() {
        this.f11746f = this.a.findViewById(R.id.view_progress);
        this.f11747g = (ScrollView) this.a.findViewById(R.id.rootScroll);
        this.f11740V = this.a.findViewById(R.id.divider);
        this.f11748h = this.a.findViewById(R.id.new_movie_container);
        this.f11749i = this.a.findViewById(R.id.new_movie_see_all);
        this.f11750j = (ListView) this.a.findViewById(R.id.news_movie_grid_view);
        this.f11752l = this.a.findViewById(R.id.new_tv_container);
        this.f11753m = this.a.findViewById(R.id.new_tv_see_all);
        this.f11754n = (ListView) this.a.findViewById(R.id.news_tv_grid_view);
        this.f11765y = this.a.findViewById(R.id.trailers_container);
        this.f11766z = this.a.findViewById(R.id.trailers_see_all);
        this.f11719A = (ParallaxRecyclerView) this.a.findViewById(R.id.trailers_recycler_view);
        this.f11721C = this.a.findViewById(R.id.top_movies_container);
        this.f11722D = this.a.findViewById(R.id.top_movies_see_all);
        this.f11723E = (ParallaxRecyclerView) this.a.findViewById(R.id.top_movies_recycler_view);
        this.f11725G = this.a.findViewById(R.id.top_tv_container);
        this.f11726H = this.a.findViewById(R.id.top_tv_see_all);
        this.f11727I = (ParallaxRecyclerView) this.a.findViewById(R.id.top_tv_recycler_view);
        this.f11732N = (ScrollView) this.a.findViewById(R.id.rootScrollRight);
        this.f11733O = (LinearLayout) this.a.findViewById(R.id.rootRigth);
        this.f11734P = (LinearLayout) this.a.findViewById(R.id.right_container);
        this.f11735Q = (LinearLayout) this.a.findViewById(R.id.root);
        ((ViewGroup) this.a.findViewById(R.id.root)).addView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        ((ViewGroup) this.a.findViewById(R.id.rootRigth)).addView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
    }

    /* renamed from: c */
    private void m16212c(boolean z) {
        if (this.f11746f != null) {
            this.f11746f.setVisibility(z ? 0 : 4);
        }
    }

    /* renamed from: a */
    private void m16204a(TrendingResponse trendingResponse, int i) {
        int i2;
        int measuredWidth = this.f11750j.getMeasuredWidth();
        if (this.f11745e) {
            i2 = measuredWidth;
        } else if (i == 2) {
            i2 = m15484h().getResources().getDimensionPixelSize(R.dimen.trending_tab_left_width);
        } else {
            if (this.f11741W == -1) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                m15484h().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.f11741W = displayMetrics.widthPixels;
            }
            i2 = this.f11741W;
        }
        int size = trendingResponse.getMovies_news().size() * ((int) (((float) i2) / 2.036f));
        LayoutParams layoutParams = (LayoutParams) this.f11750j.getLayoutParams();
        layoutParams.height = size;
        this.f11750j.setLayoutParams(layoutParams);
        C3094j.m16698a("TrendingFragment", "movie getMeasuredWidth: " + i2);
        C3094j.m16698a("TrendingFragment", "NewsMoviesListHeight: " + size);
    }

    /* renamed from: b */
    private void m16208b(TrendingResponse trendingResponse, int i) {
        int i2;
        int measuredWidth = this.f11754n.getMeasuredWidth();
        if (this.f11745e) {
            i2 = measuredWidth;
        } else if (i == 2) {
            i2 = m15484h().getResources().getDimensionPixelSize(R.dimen.trending_tab_left_width);
        } else {
            if (this.f11741W == -1) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                m15484h().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.f11741W = displayMetrics.widthPixels;
            }
            i2 = this.f11741W;
        }
        int size = trendingResponse.getTv_news().size() * ((int) (((float) i2) / 2.036f));
        LayoutParams layoutParams = (LayoutParams) this.f11754n.getLayoutParams();
        layoutParams.height = size;
        this.f11754n.setLayoutParams(layoutParams);
        C3094j.m16698a("TrendingFragment", "tv getMeasuredWidth: " + i2);
        C3094j.m16698a("TrendingFragment", "NewTvListHeight: " + size);
    }

    /* renamed from: a */
    private void m16203a(final TrendingResponse trendingResponse) {
        boolean z = true;
        m16212c(false);
        if (trendingResponse.getMovies_news() == null || trendingResponse.getMovies_news().size() <= 0) {
            this.f11748h.setVisibility(8);
        } else {
            this.f11748h.setVisibility(0);
            this.f11751k = new C3206a(m15484h(), m16236b(), trendingResponse.getMovies_news(), !this.f11745e);
            this.f11750j.setAdapter(this.f11751k);
            this.f11751k.notifyDataSetChanged();
            m16204a(trendingResponse, m15484h().getResources().getConfiguration().orientation);
            this.f11751k.m17004a(new OnItemClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2963p f11702b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f11702b.f11756p = Integer.valueOf(this.f11702b.f11747g.getScrollY());
                    this.f11702b.f11757q = Integer.valueOf(this.f11702b.f11732N.getScrollY());
                    C3065b.m16569a("news_details", "tab", "movie");
                    NewsDetailsActivity.m15180a(this.f11702b.m15484h(), this.f11702b.m15484h().m15142F().m16351f(((News) trendingResponse.getMovies_news().get(i)).getNewId()));
                }
            });
            this.f11749i.findViewById(R.id.new_movie_see_all_clickable).setOnClickListener(new C29607(this));
        }
        if (trendingResponse.getTv_news() == null || trendingResponse.getTv_news().size() <= 0) {
            this.f11752l.setVisibility(8);
        } else {
            this.f11752l.setVisibility(0);
            MainActivity h = m15484h();
            C3074a b = m16236b();
            List tv_news = trendingResponse.getTv_news();
            if (this.f11745e) {
                z = false;
            }
            this.f11755o = new C3206a(h, b, tv_news, z);
            this.f11754n.setAdapter(this.f11755o);
            this.f11755o.notifyDataSetChanged();
            m16208b(trendingResponse, m15484h().getResources().getConfiguration().orientation);
            this.f11755o.m17004a(new OnItemClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2963p f11717b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f11717b.f11756p = Integer.valueOf(this.f11717b.f11747g.getScrollY());
                    this.f11717b.f11757q = Integer.valueOf(this.f11717b.f11732N.getScrollY());
                    C3065b.m16569a("news_details", "tab", "tv");
                    NewsDetailsActivity.m15180a(this.f11717b.m15484h(), this.f11717b.m15484h().m15142F().m16351f(((News) trendingResponse.getTv_news().get(i)).getNewId()));
                }
            });
            this.f11753m.findViewById(R.id.new_tv_see_all_clickable).setOnClickListener(new C29629(this));
        }
        int i = this.f11741W;
        if (i == -1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            m15484h().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
        }
        if (this.f11742X == null) {
            this.f11742X = m16197a(i, this.f11745e, m15484h().getResources().getConfiguration().orientation);
        }
        if (trendingResponse.getTrailers() == null || trendingResponse.getTrailers().size() <= 0) {
            this.f11765y.setVisibility(8);
        } else {
            this.f11765y.setVisibility(0);
            this.f11720B = new C3209b(m15484h(), this.f11719A, trendingResponse.getTrailers(), null, m16236b());
            LayoutParams layoutParams = (LayoutParams) this.f11719A.getLayoutParams();
            layoutParams.height = (int) this.f11742X.y;
            this.f11719A.setLayoutParams(layoutParams);
            this.f11720B.m17071a(this.f11742X);
            this.f11731M = new LinearLayoutManager(m15484h());
            this.f11731M.m3536a(0);
            this.f11719A.setLayoutManager(this.f11731M);
            this.f11719A.setAdapter(this.f11720B);
            this.f11720B.m17072a(new C2951a(this) {
                /* renamed from: b */
                final /* synthetic */ C2963p f11694b;

                /* renamed from: a */
                public void mo2081a(int i) {
                    int i2 = 0;
                    this.f11694b.f11756p = Integer.valueOf(this.f11694b.f11747g.getScrollY());
                    this.f11694b.f11757q = Integer.valueOf(this.f11694b.f11732N.getScrollY());
                    try {
                        this.f11694b.f11762v = Integer.valueOf(this.f11694b.f11731M.m3562h());
                        View childAt = this.f11694b.f11719A.getChildAt(0);
                        C2963p c2963p = this.f11694b;
                        if (childAt != null) {
                            i2 = childAt.getLeft() - this.f11694b.f11719A.getPaddingLeft();
                        }
                        c2963p.f11763w = Integer.valueOf(i2);
                        Trailer trailer = (Trailer) trendingResponse.getTrailers().get(i);
                        if (((Trailer) new Select().from(Trailer.class).where("trailer_id=" + trailer.getTrailerID()).executeSingle()) == null) {
                            trailer.save();
                        }
                        C3167a.m16903a().m16912a(((Trailer) trendingResponse.getTrailers().get(i)).getTrailerID());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.f11766z.findViewById(R.id.trailers_see_all_clickable).setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2963p f11695a;

                {
                    this.f11695a = r1;
                }

                public void onClick(View view) {
                    C3167a.m16903a().m16937q();
                }
            });
        }
        if (trendingResponse.getMovies() == null || trendingResponse.getMovies().size() <= 0) {
            this.f11721C.setVisibility(8);
        } else {
            this.f11721C.setVisibility(0);
            this.f11724F = new C3209b(m15484h(), this.f11723E, trendingResponse.getMovies(), null, m16236b());
            layoutParams = (LayoutParams) this.f11723E.getLayoutParams();
            layoutParams.height = (int) this.f11742X.y;
            this.f11723E.setLayoutParams(layoutParams);
            this.f11724F.m17071a(this.f11742X);
            this.f11730L = new LinearLayoutManager(m15484h());
            this.f11730L.m3536a(0);
            this.f11723E.setLayoutManager(this.f11730L);
            this.f11723E.setAdapter(this.f11724F);
            this.f11724F.m17072a(new C2951a(this) {
                /* renamed from: b */
                final /* synthetic */ C2963p f11697b;

                /* renamed from: a */
                public void mo2081a(int i) {
                    int i2 = 0;
                    this.f11697b.f11756p = Integer.valueOf(this.f11697b.f11747g.getScrollY());
                    this.f11697b.f11757q = Integer.valueOf(this.f11697b.f11732N.getScrollY());
                    try {
                        this.f11697b.f11760t = Integer.valueOf(this.f11697b.f11730L.m3562h());
                        View childAt = this.f11697b.f11723E.getChildAt(0);
                        C2963p c2963p = this.f11697b;
                        if (childAt != null) {
                            i2 = childAt.getLeft() - this.f11697b.f11723E.getPaddingLeft();
                        }
                        c2963p.f11761u = Integer.valueOf(i2);
                        MovieItem movieItem = (MovieItem) trendingResponse.getMovies().get(i);
                        if (((MovieItem) new Select().from(MovieItem.class).where("movie_id=" + movieItem.getMovieId()).executeSingle()) == null) {
                            movieItem.save();
                        }
                        try {
                            C3167a.m16903a().m16915a(movieItem.getMovieId(), false, false);
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            this.f11722D.findViewById(R.id.top_movies_see_all_clickable).setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2963p f11698a;

                {
                    this.f11698a = r1;
                }

                public void onClick(View view) {
                    if (this.f11698a.f11745e) {
                        C3167a.m16903a().m16932l();
                    } else {
                        C3167a.m16903a().m16926f();
                    }
                }
            });
        }
        if (trendingResponse.getTv() == null || trendingResponse.getTv().size() <= 0) {
            this.f11725G.setVisibility(8);
        } else {
            this.f11725G.setVisibility(0);
            this.f11728J = new C3209b(m15484h(), this.f11727I, trendingResponse.getTv(), null, m16236b());
            layoutParams = (LayoutParams) this.f11727I.getLayoutParams();
            layoutParams.height = (int) this.f11742X.y;
            this.f11727I.setLayoutParams(layoutParams);
            this.f11728J.m17071a(this.f11742X);
            this.f11729K = new LinearLayoutManager(m15484h());
            this.f11729K.m3536a(0);
            this.f11727I.setLayoutManager(this.f11729K);
            this.f11727I.setAdapter(this.f11728J);
            this.f11728J.m17072a(new C2951a(this) {
                /* renamed from: b */
                final /* synthetic */ C2963p f11700b;

                /* renamed from: a */
                public void mo2081a(int i) {
                    int i2 = 0;
                    this.f11700b.f11756p = Integer.valueOf(this.f11700b.f11747g.getScrollY());
                    this.f11700b.f11757q = Integer.valueOf(this.f11700b.f11732N.getScrollY());
                    try {
                        this.f11700b.f11758r = Integer.valueOf(this.f11700b.f11729K.m3562h());
                        View childAt = this.f11700b.f11727I.getChildAt(0);
                        C2963p c2963p = this.f11700b;
                        if (childAt != null) {
                            i2 = childAt.getLeft() - this.f11700b.f11727I.getPaddingLeft();
                        }
                        c2963p.f11759s = Integer.valueOf(i2);
                        TvItem tvItem = (TvItem) trendingResponse.getTv().get(i);
                        TvItem tvItem2 = (TvItem) new Select().from(TvItem.class).where("item_id=" + tvItem.getItemId()).executeSingle();
                        if (tvItem2 == null) {
                            tvItem.save();
                        }
                        if (tvItem2 == null) {
                            tvItem2 = tvItem;
                        }
                        try {
                            C3167a.m16903a().m16919b(tvItem2.getLast_vieved_season() == 0 ? "-1" : "" + tvItem2.getLast_vieved_season(), tvItem2.getItemId());
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            this.f11726H.findViewById(R.id.top_tv_see_all_clickable).setOnClickListener(new C29532(this));
        }
        this.f11747g.postDelayed(new C29543(this), 10);
    }

    /* renamed from: j */
    private void m16225j() {
        m16212c(true);
        m15484h().m15142F().m16338b(new C29574(this));
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11743c;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11743c;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.f11745e) {
            C3094j.m16698a("TrendingFragment", "orientation changed");
            m16202a(configuration.orientation, false);
        }
    }

    /* renamed from: a */
    private void m16202a(int i, final boolean z) {
        if (i == 2) {
            try {
                this.f11740V.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11747g.getLayoutParams();
                layoutParams.width = m15484h().getResources().getDimensionPixelSize(R.dimen.trending_tab_left_width);
                this.f11747g.setLayoutParams(layoutParams);
                ((ViewGroup) this.f11734P.getParent()).removeView(this.f11734P);
                this.f11733O.addView(this.f11734P, 0);
                if (!z) {
                    this.f11747g.fullScroll(33);
                    this.f11732N.fullScroll(33);
                }
                if (this.f11764x != null) {
                    m16208b(this.f11764x, i);
                    m16204a(this.f11764x, i);
                }
                this.f11747g.postDelayed(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2963p f11712b;

                    public void run() {
                        if (!z) {
                            this.f11712b.f11747g.fullScroll(33);
                            this.f11712b.f11732N.fullScroll(33);
                        } else if (this.f11712b.f11756p != null) {
                            this.f11712b.f11747g.scrollTo(0, this.f11712b.f11756p.intValue());
                            this.f11712b.f11732N.scrollTo(0, this.f11712b.f11757q.intValue());
                            if (!(this.f11712b.f11758r == null || this.f11712b.f11759s == null || this.f11712b.f11729K == null)) {
                                this.f11712b.f11729K.m3537a(this.f11712b.f11758r.intValue(), this.f11712b.f11759s.intValue());
                            }
                            if (!(this.f11712b.f11760t == null || this.f11712b.f11761u == null || this.f11712b.f11730L == null)) {
                                this.f11712b.f11730L.m3537a(this.f11712b.f11760t.intValue(), this.f11712b.f11761u.intValue());
                            }
                            if (this.f11712b.f11762v != null && this.f11712b.f11763w != null && this.f11712b.f11731M != null) {
                                this.f11712b.f11731M.m3537a(this.f11712b.f11762v.intValue(), this.f11712b.f11763w.intValue());
                            }
                        }
                    }
                }, 50);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f11740V.setVisibility(8);
        if (!z) {
            this.f11747g.scrollTo(0, 0);
            this.f11732N.scrollTo(0, 0);
        }
        layoutParams = (RelativeLayout.LayoutParams) this.f11747g.getLayoutParams();
        layoutParams.width = -1;
        this.f11747g.setLayoutParams(layoutParams);
        ((ViewGroup) this.f11734P.getParent()).removeView(this.f11734P);
        this.f11735Q.addView(this.f11734P, 2);
        if (!z) {
            this.f11747g.fullScroll(33);
            this.f11732N.fullScroll(33);
        }
        if (this.f11764x != null) {
            m16208b(this.f11764x, i);
            m16204a(this.f11764x, i);
        }
        this.f11747g.postDelayed(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C2963p f11714b;

            public void run() {
                if (!z) {
                    this.f11714b.f11747g.fullScroll(33);
                    this.f11714b.f11732N.fullScroll(33);
                } else if (this.f11714b.f11756p != null) {
                    this.f11714b.f11747g.scrollTo(0, this.f11714b.f11756p.intValue());
                    this.f11714b.f11732N.scrollTo(0, this.f11714b.f11757q.intValue());
                    if (!(this.f11714b.f11758r == null || this.f11714b.f11759s == null || this.f11714b.f11729K == null)) {
                        this.f11714b.f11729K.m3537a(this.f11714b.f11758r.intValue(), this.f11714b.f11759s.intValue());
                    }
                    if (!(this.f11714b.f11760t == null || this.f11714b.f11761u == null || this.f11714b.f11730L == null)) {
                        this.f11714b.f11730L.m3537a(this.f11714b.f11760t.intValue(), this.f11714b.f11761u.intValue());
                    }
                    if (this.f11714b.f11762v != null && this.f11714b.f11763w != null && this.f11714b.f11731M != null) {
                        this.f11714b.f11731M.m3537a(this.f11714b.f11762v.intValue(), this.f11714b.f11763w.intValue());
                    }
                }
            }
        }, 50);
    }

    public void onDestroy() {
        try {
            if (this.f11744d != null) {
                this.f11744d.m16639b();
            }
            this.f11744d = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    /* renamed from: b */
    public C3074a m16236b() {
        if (this.f11744d == null) {
            this.f11744d = new C3074a(m15484h());
            boolean a = C3180g.m16974a();
            C3094j.m16698a("getImgLoader", "is low = " + a);
            if (a) {
                this.f11744d.m16631a(2);
            }
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f11744d.m16633a(animationSet, animationSet2);
            this.f11744d.m16643d((int) R.drawable.ic_poster_stub);
            if ((m15484h().getResources().getConfiguration().screenLayout & 15) == 4) {
                this.f11744d.m16640b(32);
            }
        }
        return this.f11744d;
    }

    /* renamed from: d */
    public void mo2063d() {
        super.mo2063d();
        try {
            m16225j();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void mo2064e() {
        try {
            this.f11743c.m15416b();
        } catch (Exception e) {
        }
    }
}
