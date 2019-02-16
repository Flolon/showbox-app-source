package com.tdo.showbox.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.p113d.C2974h;
import com.tdo.showbox.views.VideoQualityView.C3287a;
import com.tdo.showbox.views.VideoQualityView.C3288b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VideoOptionsDialog */
/* renamed from: com.tdo.showbox.views.f */
public class C3336f extends Dialog {
    /* renamed from: a */
    private MainActivity f12887a;
    /* renamed from: b */
    private boolean f12888b;
    /* renamed from: c */
    private int f12889c;
    /* renamed from: d */
    private List<String> f12890d;
    /* renamed from: e */
    private int f12891e;
    /* renamed from: f */
    private Subtitle f12892f;
    /* renamed from: g */
    private Spinner f12893g;
    /* renamed from: h */
    private MovieItem f12894h;
    /* renamed from: i */
    private TvItem f12895i;
    /* renamed from: j */
    private C2745a f12896j;
    /* renamed from: k */
    private Button f12897k;
    /* renamed from: l */
    private Button f12898l;
    /* renamed from: m */
    private boolean f12899m;
    /* renamed from: n */
    private int f12900n;
    /* renamed from: o */
    private long f12901o;
    /* renamed from: p */
    private String[] f12902p;
    /* renamed from: q */
    private String[] f12903q;
    /* renamed from: r */
    private float f12904r;
    /* renamed from: s */
    private VideoQualityView f12905s;
    /* renamed from: t */
    private List<C3288b> f12906t;
    /* renamed from: u */
    private C3288b f12907u;
    /* renamed from: v */
    private View f12908v;

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$a */
    public interface C2745a {
        /* renamed from: a */
        void mo2028a(int i);

        /* renamed from: a */
        void mo2029a(Subtitle subtitle);

        /* renamed from: b */
        void mo2030b(int i);
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$1 */
    class C33291 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3336f f12880a;

        C33291(C3336f c3336f) {
            this.f12880a = c3336f;
        }

        public void onClick(View view) {
            this.f12880a.m17575a(null);
            this.f12880a.dismiss();
            this.f12880a.f12887a = null;
        }
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$2 */
    class C33302 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3336f f12881a;

        C33302(C3336f c3336f) {
            this.f12881a = c3336f;
        }

        public void onClick(View view) {
            this.f12881a.f12893g.performClick();
        }
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$3 */
    class C33313 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3336f f12882a;

        C33313(C3336f c3336f) {
            this.f12882a = c3336f;
        }

        public void onClick(View view) {
            if (this.f12882a.f12894h != null) {
                this.f12882a.m17557a(this.f12882a.f12894h);
            } else {
                this.f12882a.m17556a();
            }
        }
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$4 */
    class C33324 implements OnItemSelectedListener {
        /* renamed from: a */
        final /* synthetic */ C3336f f12883a;

        C33324(C3336f c3336f) {
            this.f12883a = c3336f;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f12883a.f12891e != i) {
                this.f12883a.f12891e = i;
                this.f12883a.f12897k.setText((CharSequence) this.f12883a.f12890d.get(this.f12883a.f12891e));
                if (this.f12883a.f12896j != null) {
                    this.f12883a.f12896j.mo2028a(this.f12883a.f12891e);
                    this.f12883a.f12908v.setVisibility(0);
                    this.f12883a.f12905s.setVisibility(4);
                    this.f12883a.f12897k.setEnabled(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$5 */
    class C33335 implements C3287a {
        /* renamed from: a */
        final /* synthetic */ C3336f f12884a;

        C33335(C3336f c3336f) {
            this.f12884a = c3336f;
        }

        /* renamed from: a */
        public void mo2168a(C3288b c3288b) {
            C3088f.m16677a("PREFS_SELECTED_QUALITY", c3288b.m17357a());
            if (this.f12884a.f12896j != null) {
                this.f12884a.f12896j.mo2030b(c3288b.m17357a());
            }
        }
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$6 */
    class C33346 implements C2974h {
        /* renamed from: a */
        final /* synthetic */ C3336f f12885a;

        C33346(C3336f c3336f) {
            this.f12885a = c3336f;
        }

        /* renamed from: a */
        public void mo2169a(Subtitle subtitle) {
            if (this.f12885a.f12896j != null) {
                this.f12885a.f12896j.mo2029a(subtitle);
            }
            this.f12885a.m17561b(subtitle);
        }
    }

    /* compiled from: VideoOptionsDialog */
    /* renamed from: com.tdo.showbox.views.f$7 */
    class C33357 implements C2974h {
        /* renamed from: a */
        final /* synthetic */ C3336f f12886a;

        C33357(C3336f c3336f) {
            this.f12886a = c3336f;
        }

        /* renamed from: a */
        public void mo2169a(Subtitle subtitle) {
            if (this.f12886a.f12896j != null) {
                this.f12886a.f12896j.mo2029a(subtitle);
            }
            this.f12886a.m17561b(subtitle);
        }
    }

    /* renamed from: a */
    public void m17570a(float f) {
        this.f12904r = f;
    }

    public C3336f(MainActivity mainActivity, MovieItem movieItem) {
        super(mainActivity, R.style.custom_dialog);
        this.f12887a = mainActivity;
        this.f12894h = movieItem;
        this.f12895i = null;
    }

    public C3336f(MainActivity mainActivity, TvItem tvItem) {
        super(mainActivity, R.style.custom_dialog);
        this.f12887a = mainActivity;
        this.f12894h = null;
        this.f12895i = tvItem;
    }

    /* renamed from: a */
    public void m17575a(C2745a c2745a) {
        this.f12896j = c2745a;
    }

    protected void onStop() {
        this.f12888b = true;
        super.onStop();
    }

    protected void onStart() {
        super.onStart();
        this.f12888b = false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_video_options);
        getWindow().setBackgroundDrawableResource(17170445);
        if (this.f12904r == 0.0f) {
            this.f12904r = 0.75f;
        }
        getWindow().addFlags(2);
        if (this.f12889c > 0) {
            View findViewById = findViewById(R.id.root_container);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = this.f12889c;
            findViewById.setLayoutParams(layoutParams);
        }
        findViewById(R.id.btn_close).setOnClickListener(new C33291(this));
        this.f12908v = findViewById(R.id.switch_progress);
        this.f12897k = (Button) findViewById(R.id.btn_server);
        this.f12898l = (Button) findViewById(R.id.btn_subtitles);
        this.f12893g = (Spinner) findViewById(R.id.server_spinner);
        this.f12905s = (VideoQualityView) findViewById(R.id.quality_container);
        this.f12897k.setOnClickListener(new C33302(this));
        this.f12898l.setOnClickListener(new C33313(this));
        m17561b(this.f12892f);
        if (this.f12890d == null) {
            this.f12890d = new ArrayList();
        }
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this.f12887a, 17367048, this.f12890d);
        arrayAdapter.setDropDownViewResource(R.layout.item_epizode_spinner);
        this.f12893g.setAdapter(arrayAdapter);
        try {
            this.f12893g.setSelection(this.f12891e);
        } catch (Exception e) {
            this.f12893g.setSelection(0);
        }
        this.f12893g.setOnItemSelectedListener(new C33324(this));
        try {
            this.f12897k.setText((CharSequence) this.f12890d.get(this.f12891e));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f12899m) {
            this.f12897k.setText(R.string.source_name_torrent);
            this.f12897k.setOnClickListener(null);
        }
        this.f12905s.setQualityListener(new C33335(this));
        if (this.f12899m || this.f12907u == null) {
            this.f12905s.m17361a(false, null, null);
        } else {
            this.f12905s.m17361a(true, this.f12906t, this.f12907u);
        }
    }

    /* renamed from: a */
    public void m17579a(boolean z, List<C3288b> list, C3288b c3288b) {
        try {
            this.f12908v.setVisibility(8);
            this.f12905s.setVisibility(0);
            this.f12897k.setEnabled(true);
            if (list == null || list.size() != 3) {
                this.f12905s.m17361a(z, list, c3288b);
            } else {
                this.f12905s.m17361a(false, null, null);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m17574a(C3288b c3288b) {
        this.f12907u = c3288b;
    }

    /* renamed from: a */
    public void m17576a(List<C3288b> list) {
        this.f12906t = list;
    }

    /* renamed from: a */
    public void m17578a(boolean z) {
        this.f12899m = z;
    }

    /* renamed from: a */
    public void m17572a(long j) {
        this.f12901o = j;
    }

    /* renamed from: a */
    public void m17571a(int i) {
        this.f12900n = i;
    }

    /* renamed from: a */
    public void m17573a(Subtitle subtitle) {
        this.f12892f = subtitle;
    }

    /* renamed from: a */
    public void m17577a(List<String> list, int i) {
        this.f12890d = list;
        this.f12891e = i;
    }

    /* renamed from: b */
    public void m17580b(int i) {
        this.f12889c = i;
    }

    /* renamed from: b */
    private void m17561b(Subtitle subtitle) {
        if (this.f12887a != null) {
            String string = this.f12887a.getString(R.string.subtitles_none);
            String string2 = this.f12887a.getString(R.string.video_opt_subtitles);
            if (subtitle != null) {
                C3094j.m16698a("VideoOption", "subtuitle lang: " + subtitle.getLang());
            }
            try {
                this.f12898l.setText(string2 + " " + m17569a(subtitle.getLang()));
                this.f12892f = subtitle;
            } catch (Exception e) {
                this.f12892f = null;
                this.f12898l.setText(string2 + " " + string);
            }
        }
    }

    /* renamed from: a */
    public String m17569a(String str) {
        if (this.f12902p == null) {
            this.f12903q = this.f12887a.getResources().getStringArray(R.array.subtitles_iso_pop);
            this.f12902p = this.f12887a.getResources().getStringArray(R.array.subtitles_iso3_pop);
        }
        for (int i = 0; i < this.f12903q.length; i++) {
            if (this.f12903q[i].equals(str)) {
                return this.f12902p[i];
            }
        }
        return str.toUpperCase();
    }

    /* renamed from: a */
    private void m17557a(MovieItem movieItem) {
        new C3322c(movieItem, this.f12887a, movieItem.getImdb_id(), this.f12892f, new C33346(this)).show();
    }

    /* renamed from: a */
    private void m17556a() {
        new C3322c(this.f12895i, this.f12887a, this.f12895i.getImdb_id(), this.f12892f, "" + this.f12900n, "" + this.f12901o, new C33357(this)).show();
    }
}
