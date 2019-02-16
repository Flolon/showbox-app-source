package com.tdo.showbox.views;

import android.content.Context;
import android.widget.MediaController;
import com.tdo.showbox.p113d.C2655c;

/* compiled from: MediaControllerEx */
/* renamed from: com.tdo.showbox.views.b */
public class C3304b extends MediaController {
    /* renamed from: a */
    private C2655c f12782a;

    public void setMediaControllerListener(C2655c c2655c) {
        this.f12782a = c2655c;
    }

    public C3304b(Context context) {
        super(context);
    }

    public void hide() {
        super.hide();
        if (this.f12782a != null) {
            this.f12782a.mo2025l();
        }
    }

    public void show() {
        super.show();
        if (this.f12782a != null) {
            this.f12782a.mo2024k();
        }
    }
}
