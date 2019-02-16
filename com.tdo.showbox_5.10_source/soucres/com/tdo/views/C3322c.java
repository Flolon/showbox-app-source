package com.tdo.showbox.views;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C3011d;
import com.tdo.showbox.data.api.C3011d.C2625a;
import com.tdo.showbox.data.api.C3015e;
import com.tdo.showbox.data.api.C3015e.C3012a;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p124a.C2983f;
import com.tdo.showbox.models.LanguageRating;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.subtitle.PopSubtitleResponse;
import com.tdo.showbox.p113d.C2974h;
import com.tdo.showbox.p121g.C3210c;
import com.tdo.showbox.p121g.C3236n;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.p131f.C3185k;
import com.tdo.showbox.views.C3322c.15.C33051;
import com.tdo.showbox.views.C3322c.16.C33081;
import com.tdo.showbox.views.c.AnonymousClass15;
import com.tdo.showbox.views.c.AnonymousClass16;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SubtitlesSelectionDialog */
/* renamed from: com.tdo.showbox.views.c */
public class C3322c extends Dialog implements OnClickListener {
    /* renamed from: L */
    private static boolean f12827L = false;
    /* renamed from: A */
    private MovieItem f12828A;
    /* renamed from: B */
    private View f12829B;
    /* renamed from: C */
    private EditText f12830C;
    /* renamed from: D */
    private EditText f12831D;
    /* renamed from: E */
    private List<LanguageRating> f12832E;
    /* renamed from: F */
    private ArrayList<LanguageRating> f12833F;
    /* renamed from: G */
    private String[] f12834G;
    /* renamed from: H */
    private String[] f12835H;
    /* renamed from: I */
    private String[] f12836I;
    /* renamed from: J */
    private String[] f12837J;
    /* renamed from: K */
    private int f12838K;
    /* renamed from: a */
    private MainActivity f12839a;
    /* renamed from: b */
    private C2974h f12840b;
    /* renamed from: c */
    private View f12841c;
    /* renamed from: d */
    private View f12842d;
    /* renamed from: e */
    private ListView f12843e;
    /* renamed from: f */
    private C3210c f12844f;
    /* renamed from: g */
    private ListView f12845g;
    /* renamed from: h */
    private C3236n f12846h;
    /* renamed from: i */
    private String f12847i = "";
    /* renamed from: j */
    private String f12848j;
    /* renamed from: k */
    private String f12849k;
    /* renamed from: l */
    private TextView f12850l;
    /* renamed from: m */
    private View f12851m;
    /* renamed from: n */
    private View f12852n;
    /* renamed from: o */
    private View f12853o;
    /* renamed from: p */
    private View f12854p;
    /* renamed from: q */
    private TextView f12855q;
    /* renamed from: r */
    private boolean f12856r;
    /* renamed from: s */
    private C3015e f12857s;
    /* renamed from: t */
    private View f12858t;
    /* renamed from: u */
    private View f12859u;
    /* renamed from: v */
    private boolean f12860v;
    /* renamed from: w */
    private Subtitle f12861w;
    /* renamed from: x */
    private String f12862x;
    /* renamed from: y */
    private String f12863y;
    /* renamed from: z */
    private TvItem f12864z;

    /* compiled from: SubtitlesSelectionDialog */
    /* renamed from: com.tdo.showbox.views.c$4 */
    class C33144 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3322c f12814a;

        C33144(C3322c c3322c) {
            this.f12814a = c3322c;
        }

        public void run() {
            this.f12814a.m17481a(true);
        }
    }

    /* compiled from: SubtitlesSelectionDialog */
    /* renamed from: com.tdo.showbox.views.c$5 */
    class C33155 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3322c f12815a;

        C33155(C3322c c3322c) {
            this.f12815a = c3322c;
        }

        public void run() {
            Builder builder = new Builder(this.f12815a.f12839a);
            builder.setPositiveButton(R.string.ok, null);
            builder.setMessage(R.string.alert_cant_load_file);
            builder.show();
            this.f12815a.m17514e();
        }
    }

    /* compiled from: SubtitlesSelectionDialog */
    /* renamed from: com.tdo.showbox.views.c$6 */
    class C33166 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3322c f12816a;

        C33166(C3322c c3322c) {
            this.f12816a = c3322c;
        }

        public void run() {
            Builder builder = new Builder(this.f12816a.f12839a);
            builder.setPositiveButton(R.string.ok, null);
            builder.setMessage(R.string.alert_cant_load_file);
            builder.show();
            this.f12816a.m17480a(null);
        }
    }

    /* renamed from: a */
    public static File m17460a(Activity activity) {
        File file = new File(activity.getExternalFilesDir(null), "show_box_subtitles");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public C3322c(MovieItem movieItem, MainActivity mainActivity, String str, Subtitle subtitle, C2974h c2974h) {
        super(mainActivity, R.style.custom_dialog);
        this.f12840b = c2974h;
        this.f12839a = mainActivity;
        this.f12847i = str;
        this.f12861w = subtitle;
        this.f12828A = movieItem;
        C3094j.m16698a("SubtitlesSelectionDialog", "IMDB ID: " + str);
    }

    public C3322c(TvItem tvItem, MainActivity mainActivity, String str, Subtitle subtitle, String str2, String str3, C2974h c2974h) {
        super(mainActivity, R.style.custom_dialog);
        this.f12840b = c2974h;
        this.f12839a = mainActivity;
        this.f12847i = str;
        this.f12861w = subtitle;
        this.f12862x = str2;
        this.f12863y = str3;
        this.f12864z = tvItem;
        C3094j.m16698a("SubtitlesSelectionDialog", "IMDB ID: " + str);
    }

    /* renamed from: a */
    private boolean m17485a(final TvItem tvItem) {
        if (tvItem == null) {
            return false;
        }
        if (tvItem.getImdb_id() == null) {
            m17496b(this.f12839a.getString(R.string.loading_movie));
            this.f12839a.m15142F().m16340b(tvItem.getItemId(), "tv", new AsyncHttpResponseHandler(this) {
                /* renamed from: b */
                final /* synthetic */ C3322c f12806b;

                public void onSuccess(int i, String str) {
                    super.onSuccess(i, str);
                    try {
                        String string = new JSONObject(str).getString("imdb_id");
                        tvItem.setImdb_id(string);
                        tvItem.save();
                        this.f12806b.f12847i = string;
                    } catch (Exception e) {
                    }
                    this.f12806b.m17505c();
                }

                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    this.f12806b.m17505c();
                }
            });
            return false;
        }
        m17505c();
        return true;
    }

    /* renamed from: a */
    private boolean m17484a(final MovieItem movieItem) {
        if (movieItem == null) {
            return false;
        }
        if (movieItem.getImdb_id() == null) {
            m17496b(this.f12839a.getString(R.string.loading_movie));
            this.f12839a.m15142F().m16340b(movieItem.getMovieId(), "movie", new AsyncHttpResponseHandler(this) {
                /* renamed from: b */
                final /* synthetic */ C3322c f12826b;

                public void onSuccess(int i, String str) {
                    super.onSuccess(i, str);
                    try {
                        String string = new JSONObject(str).getString("imdb_id");
                        movieItem.setImdb_id(string);
                        movieItem.save();
                        this.f12826b.f12847i = string;
                    } catch (Exception e) {
                    }
                    this.f12826b.m17505c();
                }

                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    this.f12826b.m17505c();
                }
            });
            return false;
        }
        m17505c();
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_lang_subtitles);
        setCancelable(true);
        this.f12838K = -1;
        this.f12856r = false;
        this.f12860v = false;
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().getAttributes().dimAmount = 0.75f;
        getWindow().addFlags(2);
        ((TextView) findViewById(R.id.login_info_view)).setMovementMethod(LinkMovementMethod.getInstance());
        this.f12843e = (ListView) findViewById(R.id.lang_list_view);
        this.f12842d = findViewById(R.id.btn_close);
        this.f12841c = findViewById(R.id.off_view);
        this.f12845g = (ListView) findViewById(R.id.subs_list_view);
        this.f12858t = findViewById(R.id.btn_back);
        this.f12859u = findViewById(R.id.img_back);
        this.f12858t.setVisibility(4);
        this.f12859u.setVisibility(4);
        this.f12850l = (TextView) findViewById(R.id.txtv_title);
        this.f12855q = (TextView) findViewById(R.id.txtv_search_label);
        this.f12854p = findViewById(R.id.progress_container);
        this.f12852n = findViewById(R.id.langs_container);
        this.f12853o = findViewById(R.id.subtitles_container);
        this.f12851m = findViewById(R.id.login_container);
        this.f12831D = (EditText) this.f12851m.findViewById(R.id.edttx_passwd);
        this.f12830C = (EditText) this.f12851m.findViewById(R.id.edttx_username);
        this.f12829B = this.f12851m.findViewById(R.id.btn_login);
        this.f12829B.setOnClickListener(this);
        this.f12841c.setOnClickListener(this);
        this.f12842d.setOnClickListener(this);
        this.f12858t.setOnClickListener(this);
        this.f12859u.setOnClickListener(this);
        m17493b();
        if (this.f12828A == null) {
            m17485a(this.f12864z);
        }
        if (this.f12864z == null) {
            m17484a(this.f12828A);
        }
    }

    /* renamed from: b */
    private void m17493b() {
        this.f12832E = new Select().from(LanguageRating.class).where("is_pop=0").orderBy("rating DESC").execute();
        this.f12833F = (ArrayList) this.f12832E;
        this.f12834G = m17490a(this.f12833F, this.f12839a.getResources().getStringArray(R.array.languages));
        this.f12835H = m17503b(this.f12833F, this.f12839a.getResources().getStringArray(R.array.languages_ids));
        String str = null;
        if (this.f12861w != null) {
            str = this.f12861w.getLang();
        }
        this.f12844f = new C3210c(this.f12839a, this.f12834G, str, this.f12835H);
        this.f12843e.setAdapter(this.f12844f);
        this.f12843e.setOnItemClickListener(new OnItemClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C3322c f12783a;

            {
                this.f12783a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (C3088f.m16675a("PREF_OPEN_SUB_USER").length() == 0) {
                    this.f12783a.m17465a(i);
                    return;
                }
                this.f12783a.f12848j = this.f12783a.f12834G[i];
                this.f12783a.f12849k = this.f12783a.f12835H[i];
                C3094j.m16698a("onItemClick", " initOpenSubtitlesLangList : " + this.f12783a.f12848j);
                C3094j.m16698a("onItemClick", " initOpenSubtitlesLangList2 : " + this.f12783a.f12849k);
                this.f12783a.m17478a(this.f12783a.f12848j, this.f12783a.f12849k, 0);
                this.f12783a.m17506c(this.f12783a.f12849k);
            }
        });
    }

    /* renamed from: a */
    private void m17478a(String str, String str2, int i) {
        LanguageRating languageRating = (LanguageRating) new Select().from(LanguageRating.class).where("is_pop=" + i + " AND langID = '" + str2 + "'").executeSingle();
        if (languageRating == null) {
            languageRating = new LanguageRating(str, str2);
            languageRating.setIs_pop(i);
        }
        languageRating.incrisRaing();
        languageRating.save();
    }

    /* renamed from: a */
    private String[] m17490a(ArrayList<LanguageRating> arrayList, String[] strArr) {
        int i = 0;
        if (arrayList.size() == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (m17487a(strArr, ((LanguageRating) arrayList.get(i3)).getLang())) {
                strArr2[i2] = ((LanguageRating) arrayList.get(i3)).getLang();
                i2++;
            }
        }
        while (i < strArr.length) {
            if (!m17486a((ArrayList) arrayList, strArr[i])) {
                strArr2[i2] = strArr[i];
                i2++;
            }
            i++;
        }
        return strArr2;
    }

    /* renamed from: a */
    private boolean m17487a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2 != null && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17486a(ArrayList<LanguageRating> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LanguageRating languageRating = (LanguageRating) it.next();
            if (languageRating != null && languageRating.getLang() != null && languageRating.getLang().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m17499b(ArrayList<LanguageRating> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LanguageRating languageRating = (LanguageRating) it.next();
            if (languageRating != null && languageRating.getLangID() != null && languageRating.getLangID().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String[] m17503b(ArrayList<LanguageRating> arrayList, String[] strArr) {
        int i = 0;
        if (arrayList.size() == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (m17487a(strArr, ((LanguageRating) arrayList.get(i3)).getLangID())) {
                strArr2[i2] = ((LanguageRating) arrayList.get(i3)).getLangID();
                i2++;
            }
        }
        while (i < strArr.length) {
            if (!m17499b((ArrayList) arrayList, strArr[i])) {
                strArr2[i2] = strArr[i];
                i2++;
            }
            i++;
        }
        return strArr2;
    }

    /* renamed from: c */
    private void m17505c() {
        m17498b(this.f12847i, this.f12862x, this.f12863y);
    }

    /* renamed from: a */
    private void m17477a(final String str, final String str2) {
        if (C3178f.m16973b(this.f12839a)) {
            C3184j.m16982a(this.f12839a, this.f12831D);
            C3184j.m16982a(this.f12839a, this.f12830C);
            if (str == null || str.length() != 0) {
                m17496b("");
                m17517f().m16393a(str, str2, "Eng", "ShowBox", new C3012a(this) {
                    /* renamed from: c */
                    final /* synthetic */ C3322c f12786c;

                    /* renamed from: a */
                    public void mo2090a(Object obj) {
                        try {
                            HashMap hashMap = (HashMap) obj;
                            if (((String) hashMap.get("status")).toLowerCase().contains("200")) {
                                String str = (String) hashMap.get("token");
                                str.charAt(1);
                                this.f12786c.m17479a(str, str, str2);
                                return;
                            }
                            this.f12786c.m17509d();
                        } catch (Exception e) {
                            this.f12786c.m17509d();
                        }
                    }

                    /* renamed from: a */
                    public void mo2091a(String str, String str2) {
                        this.f12786c.m17509d();
                    }
                });
                return;
            }
            m17509d();
            return;
        }
        Toast.makeText(this.f12839a, R.string.error_connection, 1).show();
    }

    /* renamed from: d */
    private void m17509d() {
        if (this.f12839a != null) {
            m17476a(this.f12839a.getString(R.string.error_auth));
        }
    }

    /* renamed from: a */
    private void m17476a(final String str) {
        C3088f.m16679a("PREF_OPEN_SUB_USER", "");
        C3088f.m16679a("PREF_OPEN_SUB_PASWD", "");
        C3088f.m16679a("PREF_OPEN_SUBS_TOKEN", "");
        if (this.f12839a != null) {
            this.f12839a.runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C3322c f12788b;

                public void run() {
                    Toast.makeText(this.f12788b.f12839a, str, 1).show();
                    this.f12788b.m17465a(this.f12788b.f12838K);
                }
            });
        }
    }

    /* renamed from: a */
    private void m17479a(String str, String str2, String str3) {
        C3088f.m16679a("PREF_OPEN_SUB_USER", str2);
        C3088f.m16679a("PREF_OPEN_SUB_PASWD", str3);
        C3088f.m16679a("PREF_OPEN_SUBS_TOKEN", str);
        if (this.f12839a != null) {
            this.f12839a.runOnUiThread(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C3322c f12789a;

                {
                    this.f12789a = r1;
                }

                public void run() {
                    this.f12789a.f12848j = this.f12789a.f12834G[this.f12789a.f12838K];
                    this.f12789a.f12849k = this.f12789a.f12835H[this.f12789a.f12838K];
                    this.f12789a.m17478a(this.f12789a.f12848j, this.f12789a.f12849k, 0);
                    this.f12789a.m17506c(this.f12789a.f12849k);
                }
            });
        }
    }

    /* renamed from: b */
    private void m17496b(String str) {
        this.f12854p.setVisibility(0);
        this.f12852n.setVisibility(8);
        this.f12853o.setVisibility(8);
        this.f12851m.setVisibility(8);
        if (str != null) {
            this.f12855q.setText(str);
        }
    }

    /* renamed from: a */
    private void m17465a(int i) {
        this.f12838K = i;
        this.f12854p.setVisibility(8);
        this.f12852n.setVisibility(8);
        this.f12853o.setVisibility(8);
        this.f12851m.setVisibility(0);
        this.f12850l.setText(R.string.auth);
        this.f12858t.setVisibility(8);
        this.f12859u.setVisibility(8);
        this.f12860v = false;
    }

    /* renamed from: e */
    private void m17514e() {
        this.f12838K = -1;
        this.f12854p.setVisibility(8);
        this.f12852n.setVisibility(0);
        this.f12850l.setText(R.string.language_title);
        this.f12853o.setVisibility(8);
        this.f12851m.setVisibility(8);
        this.f12858t.setVisibility(8);
        this.f12859u.setVisibility(8);
        this.f12860v = false;
    }

    /* renamed from: a */
    private void m17480a(final List<Subtitle> list) {
        this.f12854p.setVisibility(8);
        this.f12852n.setVisibility(8);
        this.f12850l.setText(R.string.s_title);
        this.f12858t.setVisibility(0);
        this.f12859u.setVisibility(0);
        this.f12853o.setVisibility(0);
        this.f12851m.setVisibility(8);
        if (list != null) {
            this.f12846h = new C3236n(this.f12839a, list, this.f12861w);
            this.f12845g.setAdapter(this.f12846h);
            this.f12845g.setOnItemClickListener(new OnItemClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C3322c f12791b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Subtitle subtitle = (Subtitle) list.get(i);
                    if (this.f12791b.m17540c(subtitle)) {
                        this.f12791b.m17494b(subtitle, this.f12791b.m17539b(subtitle));
                    } else {
                        this.f12791b.m17515e(subtitle);
                    }
                }
            });
        }
        this.f12860v = true;
    }

    /* renamed from: c */
    private void m17506c(String str) {
        String str2 = "";
        if (this.f12847i != null) {
            if (this.f12847i.startsWith("tt")) {
                str2 = this.f12847i.replace("tt", "");
            } else {
                str2 = this.f12847i;
            }
            m17497b(str2, str);
        }
    }

    /* renamed from: d */
    private void m17510d(Subtitle subtitle) {
        if (this.f12840b != null) {
            this.f12840b.mo2169a(subtitle);
        }
    }

    public void onBackPressed() {
        if (this.f12860v) {
            m17514e();
        } else {
            super.onBackPressed();
        }
    }

    /* renamed from: b */
    private void m17498b(final String str, final String str2, final String str3) {
        m17496b(null);
        new Thread(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C3322c f12799d;

            /* compiled from: SubtitlesSelectionDialog */
            /* renamed from: com.tdo.showbox.views.c$15$1 */
            class C33051 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass15 f12792a;

                C33051(AnonymousClass15 anonymousClass15) {
                    this.f12792a = anonymousClass15;
                }

                public void run() {
                    if (C3322c.f12827L) {
                        this.f12792a.f12799d.m17514e();
                        this.f12792a.f12799d.m17493b();
                        return;
                    }
                    this.f12792a.f12799d.m17481a(false);
                }
            }

            public void run() {
                try {
                    String str = "http://sub.ukfrnlge.com/list?imdb=" + str;
                    if (!(str2 == null || str3 == null)) {
                        str = str + "&s=" + str2 + "&ep=" + str3;
                    }
                    final PopSubtitleResponse a = C2983f.m16304a(this.f12799d.f12839a, this.f12799d.f12839a.m15142F().m16346d(str), str);
                    if (a.getCountries().size() != 0 && a.getSubtitles().size() != 0) {
                        ArrayList arrayList = new ArrayList(a.getCountries());
                        ArrayList arrayList2 = new ArrayList(arrayList.size());
                        String[] stringArray = this.f12799d.f12839a.getResources().getStringArray(R.array.subtitles_name_pop);
                        String[] stringArray2 = this.f12799d.f12839a.getResources().getStringArray(R.array.subtitles_iso_pop);
                        for (int i = 0; i < arrayList.size(); i++) {
                            Object obj;
                            str = (String) arrayList.get(i);
                            for (int i2 = 0; i2 < stringArray2.length; i2++) {
                                if (str.equals(stringArray2[i2])) {
                                    arrayList2.add(stringArray[i2]);
                                    obj = null;
                                    break;
                                }
                            }
                            int i3 = 1;
                            if (obj != null) {
                                arrayList.set(i, null);
                            }
                        }
                        arrayList.removeAll(Collections.singleton(null));
                        this.f12799d.f12832E = new Select().from(LanguageRating.class).where("is_pop=1").orderBy("rating DESC").execute();
                        this.f12799d.f12833F = (ArrayList) this.f12799d.f12832E;
                        this.f12799d.f12836I = this.f12799d.m17490a(this.f12799d.f12833F, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                        this.f12799d.f12837J = this.f12799d.m17503b(this.f12799d.f12833F, (String[]) arrayList.toArray(new String[arrayList.size()]));
                        if (this.f12799d.f12839a != null) {
                            this.f12799d.f12839a.runOnUiThread(new Runnable(this) {
                                /* renamed from: b */
                                final /* synthetic */ AnonymousClass15 f12795b;

                                /* compiled from: SubtitlesSelectionDialog */
                                /* renamed from: com.tdo.showbox.views.c$15$2$1 */
                                class C33061 implements OnItemClickListener {
                                    /* renamed from: a */
                                    final /* synthetic */ C33072 f12793a;

                                    C33061(C33072 c33072) {
                                        this.f12793a = c33072;
                                    }

                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                        Subtitle subtitle;
                                        this.f12793a.f12795b.f12799d.f12848j = this.f12793a.f12795b.f12799d.f12836I[i];
                                        this.f12793a.f12795b.f12799d.f12849k = this.f12793a.f12795b.f12799d.f12837J[i];
                                        C3094j.m16698a("onItemClick", " searchOnPop : " + this.f12793a.f12795b.f12799d.f12848j);
                                        C3094j.m16698a("onItemClick", " searchOnPop2 : " + this.f12793a.f12795b.f12799d.f12849k);
                                        this.f12793a.f12795b.f12799d.m17478a(this.f12793a.f12795b.f12799d.f12848j, this.f12793a.f12795b.f12799d.f12849k, 1);
                                        List subtitles = a.getSubtitles();
                                        int i2 = 0;
                                        while (i2 < subtitles.size()) {
                                            if (((Subtitle) subtitles.get(i2)).getLang() != null && ((Subtitle) subtitles.get(i2)).getLang().equals(this.f12793a.f12795b.f12799d.f12849k)) {
                                                subtitle = (Subtitle) subtitles.get(i2);
                                                break;
                                            }
                                            i2++;
                                        }
                                        subtitle = null;
                                        if (subtitle != null) {
                                            subtitle.setLanguageName(this.f12793a.f12795b.f12799d.f12848j);
                                            subtitle.setImdb_id(str);
                                            String absolutePath = new File(C3322c.m17460a(this.f12793a.f12795b.f12799d.f12839a), this.f12793a.f12795b.f12799d.m17538a(subtitle)).getAbsolutePath();
                                            this.f12793a.f12795b.f12799d.m17466a(subtitle, absolutePath + ".zip", absolutePath);
                                            return;
                                        }
                                        this.f12793a.f12795b.f12799d.m17521g();
                                    }
                                }

                                public void run() {
                                    String str = null;
                                    if (this.f12795b.f12799d.f12861w != null) {
                                        str = this.f12795b.f12799d.f12861w.getLang();
                                    }
                                    this.f12795b.f12799d.m17514e();
                                    this.f12795b.f12799d.f12844f.m17075a(this.f12795b.f12799d.f12836I, str, this.f12795b.f12799d.f12837J);
                                    this.f12795b.f12799d.f12843e.setOnItemClickListener(new C33061(this));
                                }
                            });
                        }
                    } else if (this.f12799d.f12839a != null) {
                        this.f12799d.f12839a.runOnUiThread(new C33051(this));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /* renamed from: a */
    private void m17466a(final Subtitle subtitle, final String str, final String str2) {
        m17496b(null);
        new C3011d(subtitle.getZipDownloadLink(), str, new C2625a(this) {
            /* renamed from: d */
            final /* synthetic */ C3322c f12804d;

            /* compiled from: SubtitlesSelectionDialog */
            /* renamed from: com.tdo.showbox.views.c$16$1 */
            class C33081 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass16 f12800a;

                C33081(AnonymousClass16 anonymousClass16) {
                    this.f12800a = anonymousClass16;
                }

                public void run() {
                    try {
                        C3185k.m16989a(str, str2);
                        try {
                            new File(str).delete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        File[] listFiles = new File(str2).listFiles();
                        String str = "";
                        for (File file : listFiles) {
                            if (file.getAbsolutePath().toLowerCase().endsWith(".srt")) {
                                str = file.getAbsolutePath();
                                break;
                            }
                        }
                        this.f12800a.f12804d.m17494b(subtitle, str);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        this.f12800a.f12804d.m17521g();
                    }
                }
            }

            /* renamed from: a */
            public void mo1993a() {
                if (this.f12804d.f12839a != null) {
                    this.f12804d.f12839a.runOnUiThread(new C33081(this));
                }
            }

            /* renamed from: a */
            public void mo1995a(String str) {
                this.f12804d.m17521g();
            }

            /* renamed from: a */
            public void mo1994a(int i) {
            }

            /* renamed from: b */
            public void mo1996b() {
            }
        }).start();
    }

    /* renamed from: f */
    private C3015e m17517f() {
        if (this.f12857s == null) {
            this.f12857s = new C3015e(this.f12839a);
        }
        return this.f12857s;
    }

    /* renamed from: a */
    private void m17481a(final boolean z) {
        Builder builder = new Builder(this.f12839a);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3322c f12808b;

            public void onClick(DialogInterface dialogInterface, int i) {
                if (z) {
                    this.f12808b.m17514e();
                } else {
                    this.f12808b.dismiss();
                }
            }
        });
        builder.setMessage(R.string.alert_no_subtitles);
        builder.setCancelable(z);
        builder.show();
    }

    /* renamed from: b */
    private void m17497b(final String str, final String str2) {
        m17496b(null);
        String str3 = str;
        m17517f().m16394a(C3088f.m16675a("PREF_OPEN_SUBS_TOKEN"), str3, new String[]{str2}, this.f12862x, this.f12863y, new C3012a(this) {
            /* renamed from: c */
            final /* synthetic */ C3322c f12813c;

            /* compiled from: SubtitlesSelectionDialog */
            /* renamed from: com.tdo.showbox.views.c$3$1 */
            class C33121 implements C3012a {
                /* renamed from: a */
                final /* synthetic */ C33133 f12810a;

                /* compiled from: SubtitlesSelectionDialog */
                /* renamed from: com.tdo.showbox.views.c$3$1$1 */
                class C33111 implements C3012a {
                    /* renamed from: a */
                    final /* synthetic */ C33121 f12809a;

                    C33111(C33121 c33121) {
                        this.f12809a = c33121;
                    }

                    /* renamed from: a */
                    public void mo2090a(Object obj) {
                        Object obj2 = ((HashMap) obj).get("data");
                        if (obj2 instanceof Object[]) {
                            this.f12809a.f12810a.f12813c.m17482a((Object[]) obj2, str2);
                            return;
                        }
                        this.f12809a.f12810a.f12813c.m17512d("No results found");
                    }

                    /* renamed from: a */
                    public void mo2091a(String str, String str2) {
                        this.f12809a.f12810a.f12813c.m17512d(str);
                    }
                }

                C33121(C33133 c33133) {
                    this.f12810a = c33133;
                }

                /* renamed from: a */
                public void mo2090a(Object obj) {
                    try {
                        HashMap hashMap = (HashMap) obj;
                        if (((String) hashMap.get("status")).toLowerCase().contains("200")) {
                            String str = (String) hashMap.get("token");
                            str.charAt(1);
                            C3088f.m16679a("PREF_OPEN_SUBS_TOKEN", str);
                            this.f12810a.f12813c.m17517f().m16394a(C3088f.m16675a("PREF_OPEN_SUBS_TOKEN"), str, new String[]{str2}, this.f12810a.f12813c.f12862x, this.f12810a.f12813c.f12863y, new C33111(this));
                            return;
                        }
                        this.f12810a.f12813c.m17509d();
                    } catch (Exception e) {
                        this.f12810a.f12813c.m17509d();
                    }
                }

                /* renamed from: a */
                public void mo2091a(String str, String str2) {
                    this.f12810a.f12813c.m17512d(str);
                }
            }

            /* renamed from: a */
            public void mo2090a(Object obj) {
                Object obj2 = ((HashMap) obj).get("data");
                if (obj2 instanceof Object[]) {
                    this.f12813c.m17482a((Object[]) obj2, str2);
                } else if (obj2 instanceof Boolean) {
                    this.f12813c.m17512d("No results found");
                } else {
                    this.f12813c.m17517f().m16393a(C3088f.m16675a("PREF_OPEN_SUB_USER"), C3088f.m16675a("PREF_OPEN_SUB_PASWD"), "Eng", "ShowBox", new C33121(this));
                }
            }

            /* renamed from: a */
            public void mo2091a(String str, String str2) {
                this.f12813c.m17512d(str);
            }
        });
    }

    /* renamed from: d */
    private void m17512d(String str) {
        this.f12839a.runOnUiThread(new C33144(this));
    }

    /* renamed from: g */
    private void m17521g() {
        this.f12839a.runOnUiThread(new C33155(this));
    }

    /* renamed from: h */
    private void m17523h() {
        this.f12839a.runOnUiThread(new C33166(this));
    }

    /* renamed from: a */
    private void m17482a(Object[] objArr, String str) {
        objArr = objArr;
        final List arrayList = new ArrayList();
        for (Object obj : objArr) {
            HashMap hashMap = (HashMap) obj;
            String str2 = (String) hashMap.get("ZipDownloadLink");
            String str3 = (String) hashMap.get("LanguageName");
            String str4 = (String) hashMap.get("SubAddDate");
            String str5 = (String) hashMap.get("SubFileName");
            String str6 = (String) hashMap.get("UserNickName");
            String str7 = (String) hashMap.get("MovieReleaseName");
            String str8 = (String) hashMap.get("SubDownloadsCnt");
            String str9 = (String) hashMap.get("MovieYear");
            String str10 = (String) hashMap.get("IDSubtitleFile");
            if (str5.endsWith("srt") || str5.endsWith(".SRT")) {
                Subtitle subtitle = new Subtitle();
                subtitle.setImdb_id(this.f12847i);
                subtitle.setLang(str);
                subtitle.setLanguageName(str3);
                subtitle.setSubAddDate(str4);
                subtitle.setSubFileName(str5);
                subtitle.setUserNickName(str6);
                subtitle.setZipDownloadLink(str2);
                subtitle.setMovieReleaseName(str7);
                subtitle.setMovieYear(str9);
                subtitle.setSubDownloadsCnt(str8);
                subtitle.setIDSubtitleFile(str10);
                arrayList.add(subtitle);
            }
        }
        if (this.f12839a != null) {
            this.f12839a.runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C3322c f12818b;

                public void run() {
                    this.f12818b.m17480a(arrayList);
                }
            });
        }
    }

    /* renamed from: a */
    public String m17538a(Subtitle subtitle) {
        try {
            return "" + subtitle.getImdb_id() + subtitle.getLang() + subtitle.getMovieReleaseName().hashCode() + subtitle.getUserNickName().hashCode() + ".srt";
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: b */
    public String m17539b(Subtitle subtitle) {
        try {
            return new File(C3322c.m17460a(this.f12839a), m17538a(subtitle)).getAbsolutePath();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: c */
    public boolean m17540c(Subtitle subtitle) {
        try {
            return new File(C3322c.m17460a(this.f12839a), m17538a(subtitle)).exists();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private String m17461a(Subtitle subtitle, String str) {
        try {
            String absolutePath = new File(C3322c.m17460a(this.f12839a), m17538a(subtitle)).getAbsolutePath();
            C3176e.m16966a(absolutePath, new FileInputStream(str));
            return absolutePath;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private void m17494b(Subtitle subtitle, String str) {
        if (subtitle != null) {
            subtitle.setFile(str);
            m17510d(subtitle);
            dismiss();
        }
    }

    /* renamed from: e */
    private void m17515e(final Subtitle subtitle) {
        if (C3178f.m16973b(this.f12839a)) {
            m17496b(this.f12839a.getString(R.string.loading_movie));
            m17517f().m16392a(this.f12839a, C3088f.m16675a("PREF_OPEN_SUBS_TOKEN"), subtitle.getIDSubtitleFile(), new C3012a(this) {
                /* renamed from: b */
                final /* synthetic */ C3322c f12824b;

                /* renamed from: a */
                public void mo2090a(final Object obj) {
                    if (this.f12824b.f12839a != null) {
                        this.f12824b.f12839a.runOnUiThread(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C33208 f12820b;

                            public void run() {
                                try {
                                    File file = new File((String) obj);
                                    File[] listFiles = file.listFiles();
                                    String str = "";
                                    int i = 0;
                                    while (i < listFiles.length) {
                                        if (listFiles[i].getAbsolutePath().endsWith("srt") || listFiles[i].getAbsolutePath().endsWith("SRT")) {
                                            str = this.f12820b.f12824b.m17461a(subtitle, listFiles[i].getAbsolutePath());
                                            break;
                                        }
                                        i++;
                                    }
                                    C3176e.m16968a(file);
                                    str.charAt(2);
                                    this.f12820b.f12824b.m17494b(subtitle, str);
                                } catch (Exception e) {
                                    this.f12820b.f12824b.m17523h();
                                }
                            }
                        });
                    }
                }

                /* renamed from: a */
                public void mo2091a(String str, final String str2) {
                    if (this.f12824b.f12839a != null) {
                        this.f12824b.f12839a.runOnUiThread(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C33208 f12822b;

                            public void run() {
                                if (str2 == null || !str2.equals("407")) {
                                    this.f12822b.f12824b.m17523h();
                                } else if (this.f12822b.f12824b.f12839a != null) {
                                    String string = this.f12822b.f12824b.f12839a.getString(R.string.error_limit);
                                    this.f12822b.f12824b.f12857s = null;
                                    this.f12822b.f12824b.m17476a(string);
                                } else {
                                    this.f12822b.f12824b.m17509d();
                                }
                            }
                        });
                    }
                }
            });
            return;
        }
        Toast.makeText(this.f12839a, R.string.error_connection, 0).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                m17514e();
                return;
            case R.id.btn_close:
                this.f12856r = true;
                dismiss();
                return;
            case R.id.btn_login:
                m17477a(this.f12830C.getText().toString(), this.f12831D.getText().toString());
                return;
            case R.id.img_back:
                m17514e();
                return;
            case R.id.off_view:
                m17510d(null);
                dismiss();
                return;
            default:
                return;
        }
    }
}
