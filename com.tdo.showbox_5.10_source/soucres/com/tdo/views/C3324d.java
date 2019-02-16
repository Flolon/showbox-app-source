package com.tdo.showbox.views;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;

/* compiled from: TorrentAlertDialog */
/* renamed from: com.tdo.showbox.views.d */
public class C3324d {

    /* compiled from: TorrentAlertDialog */
    /* renamed from: com.tdo.showbox.views.d$a */
    public interface C2744a {
        /* renamed from: a */
        void mo2027a();
    }

    /* renamed from: a */
    public static final void m17541a(Context context, int i, final C2744a c2744a) {
        if (C3088f.m16682b("IS_SHOW_TORRENT_ALERT_DIALOG") || i != 7) {
            c2744a.mo2027a();
            return;
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dlg_torrent_alert);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.is_ask_again);
        dialog.findViewById(R.id.btn_ok).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                C3088f.m16680a("IS_SHOW_TORRENT_ALERT_DIALOG", checkBox.isChecked());
                c2744a.mo2027a();
            }
        });
        dialog.show();
    }
}
