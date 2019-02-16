package com.tdo.showbox.data;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.models.AlertInfoMessage;
import com.tdo.showbox.p131f.C3184j;
import java.util.List;

/* compiled from: AlertManager */
/* renamed from: com.tdo.showbox.data.a */
public class C2987a {
    /* renamed from: a */
    private boolean f11804a = false;

    /* renamed from: a */
    public void m16313a(List<AlertInfoMessage> list) {
        for (AlertInfoMessage alertInfoMessage : list) {
            if (((AlertInfoMessage) new Select().from(AlertInfoMessage.class).where("message_id='" + alertInfoMessage.getMessageId() + "'").executeSingle()) == null) {
                alertInfoMessage.save();
            }
        }
    }

    /* renamed from: a */
    public void m16312a(Activity activity) {
        if (activity != null) {
            List execute = new Select().from(AlertInfoMessage.class).where("is_shown=0").orderBy("Id DESC").execute();
            if (execute.size() > 0 && !this.f11804a) {
                this.f11804a = true;
                m16311a(activity, (AlertInfoMessage) execute.get(0));
            }
        }
    }

    /* renamed from: a */
    private void m16311a(final Activity activity, final AlertInfoMessage alertInfoMessage) {
        Builder builder = new Builder(activity);
        builder.setMessage(alertInfoMessage.getText());
        builder.setPositiveButton(R.string.btn_more_info, new OnClickListener(this) {
            /* renamed from: c */
            final /* synthetic */ C2987a f11803c;

            public void onClick(DialogInterface dialogInterface, int i) {
                C3184j.m16983a(activity, alertInfoMessage.getLink());
            }
        });
        builder.show();
        if (alertInfoMessage != null) {
            alertInfoMessage.setIs_shown(1);
            alertInfoMessage.save();
        }
    }
}
