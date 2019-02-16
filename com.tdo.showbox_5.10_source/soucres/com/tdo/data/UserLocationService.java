package com.tdo.showbox.data;

import android.app.Service;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.util.List;

public class UserLocationService extends Service implements LocationListener {
    /* renamed from: a */
    private LocationManager f11798a;
    /* renamed from: b */
    private Location f11799b;
    /* renamed from: c */
    private boolean f11800c;

    public void onCreate() {
        super.onCreate();
        this.f11800c = false;
    }

    /* renamed from: a */
    private void m16290a() {
        if (!this.f11800c) {
            try {
                this.f11798a = (LocationManager) getSystemService("location");
                String str = "network";
                if (!this.f11798a.isProviderEnabled(str)) {
                    str = "gps";
                    if (!this.f11798a.isProviderEnabled(str)) {
                        try {
                            getApplicationContext();
                            String networkCountryIso = ((TelephonyManager) getSystemService("phone")).getNetworkCountryIso();
                            Intent intent = new Intent("com.tdo.showbox.ACTION_LOCATION_OBTAINED");
                            intent.putExtra("ARG_ISO", networkCountryIso.toLowerCase());
                            sendBroadcast(intent);
                            C3094j.m16698a("UserLocationService", "Country: " + networkCountryIso.toLowerCase());
                            C3088f.m16679a("PREF_COUNTRY_ISO", networkCountryIso.toLowerCase());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                this.f11799b = this.f11798a.getLastKnownLocation(str);
                if (this.f11799b != null) {
                    m16291a(this.f11799b);
                    return;
                }
                try {
                    this.f11798a.requestLocationUpdates(str, 0, 0.0f, this);
                } catch (Exception e2) {
                }
                this.f11800c = true;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m16293b() {
        if (this.f11800c) {
            try {
                if (this.f11798a != null) {
                    this.f11798a.removeUpdates(this);
                    this.f11800c = false;
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r3, int r4, int r5) {
        /*
        r2 = this;
        if (r3 == 0) goto L_0x000c;
    L_0x0002:
        r0 = "CMD";
        r1 = -1;
        r0 = r3.getIntExtra(r0, r1);	 Catch:{ Exception -> 0x0015 }
        switch(r0) {
            case 123: goto L_0x0011;
            case 234: goto L_0x0017;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = super.onStartCommand(r3, r4, r5);
        return r0;
    L_0x0011:
        r2.m16290a();	 Catch:{ Exception -> 0x0015 }
        goto L_0x000c;
    L_0x0015:
        r0 = move-exception;
        goto L_0x000c;
    L_0x0017:
        r2.m16293b();	 Catch:{ Exception -> 0x0015 }
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.data.UserLocationService.onStartCommand(android.content.Intent, int, int):int");
    }

    /* renamed from: a */
    private void m16291a(final Location location) {
        m16293b();
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UserLocationService f11797b;

            public void run() {
                try {
                    this.f11797b.m16294b(location);
                    this.f11797b.stopSelf();
                } catch (Exception e) {
                }
            }
        }).start();
    }

    /* renamed from: b */
    private void m16294b(Location location) {
        try {
            List fromLocation;
            String str;
            try {
                fromLocation = new Geocoder(this).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e) {
                e.printStackTrace();
                fromLocation = null;
            }
            String str2 = "";
            if (fromLocation == null || fromLocation.size() <= 0) {
                str = "";
            } else {
                str = ((Address) fromLocation.get(0)).getCountryCode();
                if (str == null) {
                    str = "";
                }
            }
            Intent intent = new Intent("com.tdo.showbox.ACTION_LOCATION_OBTAINED");
            intent.putExtra("ARG_ISO", str.toLowerCase());
            sendBroadcast(intent);
            C3094j.m16698a("UserLocationService", "Country: " + str.toLowerCase());
            C3088f.m16679a("PREF_COUNTRY_ISO", str.toLowerCase());
        } catch (Exception e2) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            m16291a(location);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
