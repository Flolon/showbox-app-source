package com.tdo.showbox.data.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C3011d.C2625a;
import java.io.File;

/* compiled from: AppUpdater */
/* renamed from: com.tdo.showbox.data.api.b */
public class C3007b {
    /* renamed from: a */
    private Activity f11862a;
    /* renamed from: b */
    private Dialog f11863b;
    /* renamed from: c */
    private ProgressBar f11864c;
    /* renamed from: d */
    private View f11865d;
    /* renamed from: e */
    private C3011d f11866e;
    /* renamed from: f */
    private TextView f11867f;
    /* renamed from: g */
    private String f11868g;

    /* compiled from: AppUpdater */
    /* renamed from: com.tdo.showbox.data.api.b$1 */
    class C30021 implements C2625a {
        /* renamed from: a */
        final /* synthetic */ C3007b f11856a;

        /* compiled from: AppUpdater */
        /* renamed from: com.tdo.showbox.data.api.b$1$1 */
        class C30001 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C30021 f11854a;

            C30001(C30021 c30021) {
                this.f11854a = c30021;
            }

            public void run() {
                this.f11854a.f11856a.m16362a(this.f11854a.f11856a.f11862a, this.f11854a.f11856a.f11868g);
            }
        }

        /* compiled from: AppUpdater */
        /* renamed from: com.tdo.showbox.data.api.b$1$2 */
        class C30012 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C30021 f11855a;

            C30012(C30021 c30021) {
                this.f11855a = c30021;
            }

            public void run() {
                Toast.makeText(this.f11855a.f11856a.f11862a, R.string.error_app_update, 0).show();
            }
        }

        C30021(C3007b c3007b) {
            this.f11856a = c3007b;
        }

        /* renamed from: a */
        public void mo1994a(int i) {
            this.f11856a.m16361a(i);
        }

        /* renamed from: b */
        public void mo1996b() {
            this.f11856a.m16367b();
        }

        /* renamed from: a */
        public void mo1993a() {
            this.f11856a.m16367b();
            if (this.f11856a.f11862a != null) {
                this.f11856a.f11862a.runOnUiThread(new C30001(this));
            }
        }

        /* renamed from: a */
        public void mo1995a(String str) {
            this.f11856a.m16367b();
            if (this.f11856a.f11862a != null) {
                this.f11856a.f11862a.runOnUiThread(new C30012(this));
            }
        }
    }

    /* compiled from: AppUpdater */
    /* renamed from: com.tdo.showbox.data.api.b$3 */
    class C30053 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3007b f11860a;

        /* compiled from: AppUpdater */
        /* renamed from: com.tdo.showbox.data.api.b$3$1 */
        class C30041 implements OnClickListener {
            /* renamed from: a */
            final /* synthetic */ C30053 f11859a;

            C30041(C30053 c30053) {
                this.f11859a = c30053;
            }

            public void onClick(View view) {
                if (this.f11859a.f11860a.f11866e != null) {
                    this.f11859a.f11860a.f11866e.interrupt();
                } else {
                    this.f11859a.f11860a.m16367b();
                }
            }
        }

        C30053(C3007b c3007b) {
            this.f11860a = c3007b;
        }

        public void run() {
            try {
                if (this.f11860a.f11863b != null) {
                    this.f11860a.f11863b.dismiss();
                }
            } catch (Exception e) {
            }
            this.f11860a.f11863b = new Dialog(this.f11860a.f11862a);
            this.f11860a.f11863b.requestWindowFeature(1);
            this.f11860a.f11863b.setContentView(R.layout.dialog_app_updating);
            this.f11860a.f11863b.setCancelable(false);
            this.f11860a.f11863b.setCanceledOnTouchOutside(false);
            this.f11860a.f11864c = (ProgressBar) this.f11860a.f11863b.findViewById(R.id.view_progress);
            this.f11860a.f11864c.setMax(100);
            this.f11860a.f11864c.setProgress(0);
            this.f11860a.f11865d = this.f11860a.f11863b.findViewById(R.id.btn_cancel);
            this.f11860a.f11867f = (TextView) this.f11860a.f11863b.findViewById(R.id.txtx_persents);
            this.f11860a.f11865d.setOnClickListener(new C30041(this));
            this.f11860a.f11863b.show();
        }
    }

    /* compiled from: AppUpdater */
    /* renamed from: com.tdo.showbox.data.api.b$4 */
    class C30064 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3007b f11861a;

        C30064(C3007b c3007b) {
            this.f11861a = c3007b;
        }

        public void run() {
            try {
                if (this.f11861a.f11863b != null) {
                    this.f11861a.f11863b.dismiss();
                    this.f11861a.f11863b = null;
                }
            } catch (Exception e) {
            }
        }
    }

    public C3007b(Activity activity) {
        this.f11862a = activity;
    }

    /* renamed from: a */
    public void m16374a(String str) {
        File file;
        C3094j.m16698a("Updater", "url: " + str);
        String str2 = "";
        try {
            file = new File(this.f11862a.getExternalFilesDir(null).getAbsolutePath() + "/download/");
            file.mkdirs();
            this.f11868g = new File(file, "show_box.apk").getAbsolutePath();
        } catch (Exception e) {
            try {
                file = new File(Environment.getExternalStorageDirectory() + "/download/");
                file.mkdirs();
                this.f11868g = new File(file, "show_box.apk").getAbsolutePath();
            } catch (Exception e2) {
                file = new File(this.f11862a.getFilesDir().getAbsolutePath());
                file.mkdirs();
                this.f11868g = new File(file, "show_box.apk").getAbsolutePath();
            }
        }
        this.f11866e = new C3011d(str, this.f11868g, new C30021(this));
        m16360a();
        this.f11866e.start();
    }

    /* renamed from: a */
    private void m16362a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
            System.exit(0);
        } catch (Exception e) {
            Toast.makeText(context.getApplicationContext(), context.getString(R.string.error_app_update), 0).show();
        }
    }

    /* renamed from: a */
    private void m16361a(final int i) {
        if (this.f11862a != null) {
            this.f11862a.runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C3007b f11858b;

                public void run() {
                    if (this.f11858b.f11867f != null) {
                        this.f11858b.f11867f.setText("" + i + "%");
                    }
                    if (this.f11858b.f11864c != null) {
                        this.f11858b.f11864c.setProgress(i);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m16360a() {
        if (this.f11862a != null) {
            this.f11862a.runOnUiThread(new C30053(this));
        }
    }

    /* renamed from: b */
    private void m16367b() {
        if (this.f11862a != null) {
            this.f11862a.runOnUiThread(new C30064(this));
        }
    }
}
