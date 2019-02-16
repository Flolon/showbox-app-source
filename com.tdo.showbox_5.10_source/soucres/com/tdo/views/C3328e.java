package com.tdo.showbox.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import java.util.Random;

/* compiled from: UserInfoDialog */
/* renamed from: com.tdo.showbox.views.e */
public class C3328e extends Dialog {
    /* renamed from: a */
    private MainActivity f12873a;
    /* renamed from: b */
    private String f12874b = null;
    /* renamed from: c */
    private String f12875c = null;
    /* renamed from: d */
    private Button f12876d;
    /* renamed from: e */
    private Spinner f12877e;
    /* renamed from: f */
    private Spinner f12878f;
    /* renamed from: g */
    private C2622a f12879g;

    /* compiled from: UserInfoDialog */
    /* renamed from: com.tdo.showbox.views.e$a */
    public interface C2622a {
        /* renamed from: a */
        void mo1992a(String str, String str2);
    }

    /* compiled from: UserInfoDialog */
    /* renamed from: com.tdo.showbox.views.e$3 */
    class C33273 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3328e f12872a;

        C33273(C3328e c3328e) {
            this.f12872a = c3328e;
        }

        public void onClick(View view) {
            if (this.f12872a.f12875c == null) {
                Toast.makeText(this.f12872a.f12873a, R.string.usir_info_gender_empty, 0).show();
            } else if (this.f12872a.f12875c.equals(this.f12872a.f12873a.getString(R.string.gender))) {
                Toast.makeText(this.f12872a.f12873a, R.string.usir_info_gender_empty, 0).show();
            } else if (this.f12872a.f12874b == null) {
                Toast.makeText(this.f12872a.f12873a, R.string.usir_info_age_empty, 0).show();
            } else if (this.f12872a.f12874b.equals(this.f12872a.f12873a.getString(R.string.age))) {
                Toast.makeText(this.f12872a.f12873a, R.string.usir_info_age_empty, 0).show();
            } else {
                int intValue;
                int nextInt;
                this.f12872a.f12878f.setSelection(0);
                this.f12872a.f12877e.setSelection(0);
                Random random = new Random();
                try {
                    String[] split = this.f12872a.f12874b.split("-");
                    intValue = Integer.valueOf(split[0]).intValue();
                    nextInt = random.nextInt(Integer.valueOf(split[1]).intValue() - intValue);
                } catch (Exception e) {
                    intValue = Integer.valueOf(this.f12872a.f12874b.replace("+", "")).intValue();
                    nextInt = random.nextInt(70);
                }
                if (this.f12872a.f12879g != null) {
                    this.f12872a.f12879g.mo1992a("" + (nextInt + intValue), this.f12872a.f12875c);
                }
                this.f12872a.dismiss();
            }
        }
    }

    public C3328e(MainActivity mainActivity, C2622a c2622a) {
        super(mainActivity, R.style.custom_dialog);
        this.f12879g = c2622a;
        this.f12873a = mainActivity;
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dlg_user_age);
        setCancelable(false);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().getAttributes().dimAmount = 0.75f;
        getWindow().addFlags(2);
        this.f12876d = (Button) findViewById(R.id.btn_ok);
        this.f12878f = (Spinner) findViewById(R.id.sort_year_spinner);
        this.f12877e = (Spinner) findViewById(R.id.sort_gender_spinner);
        final String[] stringArray = this.f12873a.getResources().getStringArray(R.array.age_array);
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this.f12873a, 17367050, stringArray);
        arrayAdapter.setDropDownViewResource(R.layout.item_sort);
        this.f12878f.setAdapter(arrayAdapter);
        final String[] stringArray2 = this.f12873a.getResources().getStringArray(R.array.gender);
        SpinnerAdapter arrayAdapter2 = new ArrayAdapter(this.f12873a, 17367050, stringArray2);
        arrayAdapter2.setDropDownViewResource(R.layout.item_sort);
        this.f12877e.setAdapter(arrayAdapter2);
        this.f12878f.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3328e f12869b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                this.f12869b.f12874b = stringArray[i];
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                this.f12869b.f12874b = null;
            }
        });
        this.f12877e.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3328e f12871b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                this.f12871b.f12875c = stringArray2[i];
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                this.f12871b.f12875c = null;
            }
        });
        this.f12876d.setOnClickListener(new C33273(this));
    }
}
