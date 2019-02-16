package com.tdo.showbox.p117b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2687c;
import com.tdo.showbox.activities.p115a.C2687c.C2685a;
import com.tdo.showbox.activities.p115a.C2687c.C2686b;
import com.tdo.showbox.data.C3088f;
import java.lang.reflect.Field;

/* compiled from: LibraryFragment */
/* renamed from: com.tdo.showbox.b.e */
public class C2855e extends C2769a implements OnClickListener, C2686b {
    /* renamed from: c */
    private View f11354c;
    /* renamed from: d */
    private View f11355d;
    /* renamed from: e */
    private View f11356e;
    /* renamed from: f */
    private int f11357f;
    /* renamed from: g */
    private View f11358g;
    /* renamed from: h */
    private View f11359h;
    /* renamed from: i */
    private View f11360i;
    /* renamed from: j */
    private C2769a f11361j;
    /* renamed from: k */
    private long f11362k = 0;
    /* renamed from: l */
    private boolean f11363l;
    /* renamed from: m */
    private C2687c f11364m = new C2687c();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_library, null);
        this.f11355d = this.a.findViewById(R.id.shows_marker);
        this.f11354c = this.a.findViewById(R.id.movies_marker);
        this.f11356e = this.a.findViewById(R.id.downloads_marker);
        this.f11358g = this.a.findViewById(R.id.txtv_shows);
        this.f11359h = this.a.findViewById(R.id.txtv_movies);
        this.f11360i = this.a.findViewById(R.id.txtv_downloads);
        this.f11360i.setOnClickListener(this);
        this.f11358g.setOnClickListener(this);
        this.f11359h.setOnClickListener(this);
        this.f11359h.setVisibility(0);
        this.f11362k = 0;
        m15840b();
        this.a.findViewById(R.id.sub_tab_container).setVisibility(8);
        return this.a;
    }

    /* renamed from: b */
    private void m15840b() {
        this.f11364m.m15308a((C2686b) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f11363l = true;
    }

    public void onResume() {
        super.onResume();
        if (this.f11363l) {
            this.f11363l = false;
            int b = C3088f.m16681b("PREF_LIB_SUB_TAB", (int) R.id.txtv_shows);
            this.f11364m.m15307a(b == R.id.txtv_shows ? C2685a.SHOWS : C2685a.MOVIES);
            m15839a(b);
        }
    }

    public void onPause() {
        this.f11363l = false;
        super.onPause();
    }

    /* renamed from: a */
    public void m15842a() {
        try {
            C2769a c2916l = new C2916l();
            switch (this.f11357f) {
                case R.id.txtv_downloads:
                    this.f11356e.setVisibility(0);
                    c2916l = new C2834c();
                    break;
                case R.id.txtv_movies:
                    this.f11354c.setVisibility(0);
                    c2916l = new C2869g();
                    break;
                case R.id.txtv_shows:
                    this.f11355d.setVisibility(0);
                    break;
            }
            m15844a(c2916l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m15839a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11362k <= 350) {
            return false;
        }
        this.f11362k = currentTimeMillis;
        if (this.f11357f != i) {
            this.f11357f = i;
            C3088f.m16677a("PREF_LIB_SUB_TAB", this.f11357f);
            this.f11354c.setVisibility(4);
            this.f11355d.setVisibility(4);
            this.f11356e.setVisibility(4);
            C2769a c2916l = new C2916l();
            switch (i) {
                case R.id.txtv_downloads:
                    this.f11356e.setVisibility(0);
                    c2916l = new C2834c();
                    break;
                case R.id.txtv_movies:
                    this.f11354c.setVisibility(0);
                    c2916l = new C2869g();
                    break;
                case R.id.txtv_shows:
                    this.f11355d.setVisibility(0);
                    break;
            }
            m15844a(c2916l);
        }
        return true;
    }

    public void onDestroy() {
        this.f11363l = false;
        this.f11357f = 0;
        super.onDestroy();
    }

    /* renamed from: a */
    public void m15844a(C2769a c2769a) {
        try {
            this.f11361j = c2769a;
            FragmentTransaction a = getChildFragmentManager().mo59a();
            a.mo22a((int) R.id.frgm_lib_container, (Fragment) c2769a);
            a.mo26b();
        } catch (Exception e) {
        }
    }

    public void onDetach() {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
    }

    public void onClick(View view) {
        m15839a(view.getId());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f11361j != null && (this.f11361j instanceof C2834c)) {
            ((C2834c) this.f11361j).onActivityResult(i, i2, intent);
        }
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        this.f11364m.m15307a(C3088f.m16681b("PREF_LIB_SUB_TAB", (int) R.id.txtv_shows) == R.id.txtv_shows ? C2685a.SHOWS : C2685a.MOVIES);
        return this.f11364m;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        this.f11364m.m15307a(C3088f.m16681b("PREF_LIB_SUB_TAB", (int) R.id.txtv_shows) == R.id.txtv_shows ? C2685a.SHOWS : C2685a.MOVIES);
        return this.f11364m;
    }

    /* renamed from: a */
    public void mo2073a(C2685a c2685a) {
        switch (c2685a) {
            case MOVIES:
                if (!m15839a((int) R.id.txtv_movies)) {
                    this.f11364m.m15307a(C2685a.SHOWS);
                    return;
                }
                return;
            case SHOWS:
                if (!m15839a((int) R.id.txtv_shows)) {
                    this.f11364m.m15307a(C2685a.MOVIES);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
