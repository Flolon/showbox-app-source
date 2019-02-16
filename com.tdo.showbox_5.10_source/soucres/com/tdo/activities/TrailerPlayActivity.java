package com.tdo.showbox.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.youtube.player.C1911d;
import com.google.android.youtube.player.C1911d.C1862b;
import com.google.android.youtube.player.C1911d.C1924a;
import com.google.android.youtube.player.C1922b;
import com.google.android.youtube.player.C1923c;
import com.google.android.youtube.player.YouTubePlayerView;
import com.tdo.showbox.R;

public class TrailerPlayActivity extends C1922b {
    /* renamed from: a */
    private YouTubePlayerView f10805a;
    /* renamed from: b */
    private String f10806b = "";

    /* renamed from: com.tdo.showbox.activities.TrailerPlayActivity$1 */
    class C26441 implements C1924a {
        /* renamed from: a */
        final /* synthetic */ TrailerPlayActivity f10804a;

        C26441(TrailerPlayActivity trailerPlayActivity) {
            this.f10804a = trailerPlayActivity;
        }

        /* renamed from: a */
        public void mo2019a(C1862b c1862b, C1911d c1911d, boolean z) {
            if (c1911d != null) {
                try {
                    c1911d.mo1591a(false);
                    c1911d.mo1592b(false);
                    c1911d.mo1590a(this.f10804a.f10806b);
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: a */
        public void mo2018a(C1862b c1862b, C1923c c1923c) {
            try {
                this.f10804a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.f10804a.f10806b)));
                this.f10804a.finish();
            } catch (Exception e) {
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_trailer);
        this.f10806b = getIntent().getStringExtra("ARG_ID");
        this.f10805a = (YouTubePlayerView) findViewById(R.id.player);
        this.f10805a.m11415a("AIzaSyC-E_rG3bJbJrIIoz3IxlgftxHE5u9hTGc", new C26441(this));
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
