package com.tdo.showbox.p131f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;

/* compiled from: UiUtils */
/* renamed from: com.tdo.showbox.f.j */
public class C3184j {
    /* renamed from: a */
    public static void m16985a(View view, boolean z) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                C3184j.m16985a(((ViewGroup) view).getChildAt(i), z);
            }
            if (!AdapterView.class.isInstance(view)) {
                ((ViewGroup) view).removeAllViews();
                return;
            }
            return;
        }
        try {
            Drawable background = view.getBackground();
            if (background == null && ImageView.class.isInstance(view)) {
                background = ((ImageView) view).getDrawable();
            }
            if (background != null) {
                background.setCallback(null);
                if (z && Drawable.class.isInstance(background)) {
                    try {
                        Bitmap bitmap = ((BitmapDrawable) background).getBitmap();
                        if (bitmap != null) {
                            bitmap.recycle();
                            view.destroyDrawingCache();
                        }
                    } catch (Exception e) {
                        view.destroyDrawingCache();
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static void m16984a(View view) {
        if (view != null) {
            try {
                view.removeCallbacks(null);
                view.destroyDrawingCache();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static int m16980a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static void m16982a(Context context, EditText editText) {
        if (context != null && editText != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* renamed from: b */
    public static void m16986b(final Context context, final EditText editText) {
        editText.postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInputFromWindow(editText.getApplicationWindowToken(), 2, 0);
                editText.requestFocus();
            }
        }, 300);
    }

    /* renamed from: a */
    public static void m16981a(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str);
            intent.putExtra("android.intent.extra.TEXT", str2);
            activity.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m16983a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }
}
