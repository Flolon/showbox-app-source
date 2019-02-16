package com.tdo.showbox.activities;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;

public class ScrollHintActivity extends Activity {

    /* renamed from: com.tdo.showbox.activities.ScrollHintActivity$1 */
    class C26341 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ScrollHintActivity f10786a;

        C26341(ScrollHintActivity scrollHintActivity) {
            this.f10786a = scrollHintActivity;
        }

        public void onClick(View view) {
            C3088f.m16680a("PREF_SCROLL_SHOWED", true);
            this.f10786a.finish();
            this.f10786a.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_scroll_down);
        findViewById(R.id.ok).setOnClickListener(new C26341(this));
        final View findViewById = findViewById(R.id.main_container);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(1300);
        ofFloat.addListener(new AnimatorListener(this) {
            /* renamed from: b */
            final /* synthetic */ ScrollHintActivity f10788b;

            public void onAnimationStart(Animator animator) {
                findViewById.setVisibility(0);
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationCancel(Animator animator) {
            }
        });
        ofFloat.start();
    }

    public void onBackPressed() {
        C3088f.m16680a("PREF_SCROLL_SHOWED", true);
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation != 2) {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}
