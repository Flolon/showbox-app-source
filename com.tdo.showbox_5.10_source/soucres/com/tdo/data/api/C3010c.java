package com.tdo.showbox.data.api;

import android.app.Activity;
import android.text.TextUtils;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.vproviders.RtMediaInfo;
import com.tdo.showbox.data.vproviders.RtProvider.RtProviderExtractor;
import com.tdo.showbox.models.BaseResponse;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.io.File;

/* compiled from: LinkObtainer */
/* renamed from: com.tdo.showbox.data.api.c */
public class C3010c {
    /* renamed from: a */
    private BaseVideoSource f11874a;

    /* compiled from: LinkObtainer */
    /* renamed from: com.tdo.showbox.data.api.c$a */
    public interface C2753a {
        /* renamed from: a */
        void mo2034a(BaseResponse baseResponse);
    }

    public C3010c(BaseVideoSource baseVideoSource) {
        this.f11874a = baseVideoSource;
    }

    /* renamed from: a */
    public void m16380a(final MainActivity mainActivity, final C2753a c2753a) {
        if (this.f11874a.getSource_mode_id() == 10) {
            String str = "com.rtprovider.OloadStream";
            File file = new File(mainActivity.getExternalFilesDir(null), "vp_cache");
            if (!file.exists()) {
                file.mkdirs();
            }
            mainActivity.m15142F().m16328a(mainActivity.m15166m(), str, new File(file, "d.dex").getAbsolutePath(), "prov.dex", this.f11874a.getStatic_link(), new RtProviderExtractor(this) {
                /* renamed from: b */
                final /* synthetic */ C3010c f11870b;

                /* renamed from: a */
                public void mo2089a(RtMediaInfo rtMediaInfo) {
                    BaseResponse baseResponse = new BaseResponse();
                    this.f11870b.f11874a.setCookies(rtMediaInfo.getCookies());
                    if (!TextUtils.isEmpty(rtMediaInfo.getUrl())) {
                        baseResponse.setResponse("");
                        this.f11870b.f11874a.setHd_link(rtMediaInfo.getUrl());
                        this.f11870b.f11874a.setMid_link(rtMediaInfo.getUrl());
                        this.f11870b.f11874a.setLow_link(rtMediaInfo.getUrl());
                    }
                    if (c2753a != null) {
                        c2753a.mo2034a(baseResponse);
                    }
                }
            });
            return;
        }
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C3010c f11873c;

            public void run() {
                BaseResponse baseResponse = null;
                try {
                    baseResponse = this.f11873c.m16377a(mainActivity);
                } catch (Exception e) {
                }
                if (c2753a != null) {
                    c2753a.mo2034a(baseResponse);
                }
            }
        }).start();
    }

    /* renamed from: a */
    private BaseResponse m16377a(MainActivity mainActivity) throws Exception {
        if (this.f11874a.getSource_mode_id() == 7) {
            return new BaseResponse();
        }
        C3094j.m16698a("MovieDetailsFragment", "static vk link " + this.f11874a.getStatic_link());
        BaseResponse a = mainActivity.m15142F().m16325a((Activity) mainActivity, this.f11874a.getStatic_link(), this.f11874a.getSource_mode_id());
        this.f11874a.setCookies(a.getCokies());
        switch (this.f11874a.getSource_mode_id()) {
            case 2:
                if (TextUtils.isEmpty(a.getResponse())) {
                    C3065b.m16569a("moon_request", "result", "fail");
                    C3094j.m16698a("MovieDetailsFragment", "moon logs: " + a.getLogs());
                } else {
                    C3065b.m16569a("moon_request", "result", "success");
                }
                ObjParser.m16280b(this.f11874a, a.getResponse());
                return a;
            case 4:
                ObjParser.m16276a(this.f11874a, a.getResponse());
                return a;
            default:
                return a;
        }
    }
}
