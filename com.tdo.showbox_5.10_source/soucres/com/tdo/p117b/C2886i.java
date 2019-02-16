package com.tdo.showbox.p117b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2719h;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SettingsFragment */
/* renamed from: com.tdo.showbox.b.i */
public class C2886i extends C2769a {
    /* renamed from: c */
    private C2719h f11443c = new C2719h();
    /* renamed from: d */
    private Spinner f11444d;
    /* renamed from: e */
    private List<String> f11445e;
    /* renamed from: f */
    private TextView f11446f;
    /* renamed from: g */
    private CheckBox f11447g;
    /* renamed from: h */
    private CheckBox f11448h;
    /* renamed from: i */
    private View f11449i;
    /* renamed from: j */
    private RadioGroup f11450j;
    /* renamed from: k */
    private View f11451k;

    /* compiled from: SettingsFragment */
    /* renamed from: com.tdo.showbox.b.i$1 */
    class C28811 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2886i f11438a;

        C28811(C2886i c2886i) {
            this.f11438a = c2886i;
        }

        public void onClick(View view) {
            this.f11438a.f11444d.performClick();
        }
    }

    /* compiled from: SettingsFragment */
    /* renamed from: com.tdo.showbox.b.i$2 */
    class C28822 implements OnItemSelectedListener {
        /* renamed from: a */
        final /* synthetic */ C2886i f11439a;

        C28822(C2886i c2886i) {
            this.f11439a = c2886i;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f11439a.f11446f.setText((CharSequence) this.f11439a.f11445e.get(i));
            this.f11439a.f11444d.setSelection(i);
            C3088f.m16677a("PREFS_PLAYER_MODE", i);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: SettingsFragment */
    /* renamed from: com.tdo.showbox.b.i$3 */
    class C28833 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ C2886i f11440a;

        C28833(C2886i c2886i) {
            this.f11440a = c2886i;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3088f.m16680a("PREFS_SETTINGS_AUTO_DOWNLOADING", z);
            this.f11440a.f11451k.setVisibility(z ? 8 : 0);
            this.f11440a.f11450j.setAlpha(z ? 1.0f : 0.5f);
            if (z) {
                ((RadioButton) this.f11440a.a.findViewById(C3088f.m16684c("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE") == 0 ? R.id.auto_opt0 : R.id.auto_opt1)).setChecked(true);
            } else {
                this.f11440a.f11450j.clearCheck();
            }
            C3065b.m16568a(z ? "auto_torrent_tv_enabled" : "auto_torrent_tv_disabled");
        }
    }

    /* compiled from: SettingsFragment */
    /* renamed from: com.tdo.showbox.b.i$4 */
    class C28844 implements OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ C2886i f11441a;

        C28844(C2886i c2886i) {
            this.f11441a = c2886i;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3088f.m16680a("PREFS_SETTINGS_AUTO_REMOVING", z);
            if (z) {
                C3065b.m16568a("auto_torrent_tv_removing_enabled");
            }
        }
    }

    /* compiled from: SettingsFragment */
    /* renamed from: com.tdo.showbox.b.i$5 */
    class C28855 implements RadioGroup.OnCheckedChangeListener {
        /* renamed from: a */
        final /* synthetic */ C2886i f11442a;

        C28855(C2886i c2886i) {
            this.f11442a = c2886i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.auto_opt0) {
                C3088f.m16677a("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE", 0);
            } else if (i == R.id.auto_opt1) {
                C3088f.m16677a("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE", 1);
            }
        }
    }

    /* renamed from: a */
    public static C2886i m15917a() {
        return new C2886i();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_settings, null);
        this.f11444d = (Spinner) this.a.findViewById(R.id.player_spinner);
        this.f11446f = (TextView) this.a.findViewById(R.id.btn_player);
        this.f11447g = (CheckBox) this.a.findViewById(R.id.auto_downloading);
        this.f11448h = (CheckBox) this.a.findViewById(R.id.auto_removing);
        this.f11449i = this.a.findViewById(R.id.auto_modes_container);
        this.f11451k = this.a.findViewById(R.id.radio_overlay);
        this.f11450j = (RadioGroup) this.a.findViewById(R.id.modes_radio);
        this.f11447g.setChecked(C3088f.m16682b("PREFS_SETTINGS_AUTO_DOWNLOADING"));
        boolean b = C3088f.m16682b("PREFS_SETTINGS_AUTO_DOWNLOADING");
        this.f11451k.setVisibility(b ? 8 : 0);
        this.f11450j.setAlpha(b ? 1.0f : 0.5f);
        if (b) {
            ((RadioButton) this.a.findViewById(C3088f.m16684c("PREFS_SETTINGS_AUTO_DOWNLOADING_MODE") == 0 ? R.id.auto_opt0 : R.id.auto_opt1)).setChecked(true);
        } else {
            this.f11450j.clearCheck();
        }
        this.f11448h.setChecked(C3088f.m16682b("PREFS_SETTINGS_AUTO_REMOVING"));
        this.f11445e = new ArrayList();
        this.f11445e.add(m15484h().getString(R.string.player_internal));
        this.f11445e.add(m15484h().getString(R.string.player_internal_vlc));
        this.f11445e.add(m15484h().getString(R.string.player_external));
        int b2 = C3088f.m16681b("PREFS_PLAYER_MODE", 1);
        this.a.findViewById(R.id.player_root_container).setOnClickListener(new C28811(this));
        SpinnerAdapter arrayAdapter = new ArrayAdapter(m15484h(), 17367048, this.f11445e);
        arrayAdapter.setDropDownViewResource(R.layout.item_epizode_spinner);
        this.f11444d.setAdapter(arrayAdapter);
        try {
            this.f11444d.setSelection(b2);
            this.f11446f.setText((CharSequence) this.f11445e.get(b2));
        } catch (Exception e) {
        }
        this.f11444d.setOnItemSelectedListener(new C28822(this));
        this.f11447g.setOnCheckedChangeListener(new C28833(this));
        this.f11448h.setOnCheckedChangeListener(new C28844(this));
        this.f11450j.setOnCheckedChangeListener(new C28855(this));
        return this.a;
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11443c;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11443c;
    }

    /* renamed from: e */
    public void mo2064e() {
        try {
            this.f11443c.m15379b();
        } catch (Exception e) {
        }
    }
}
