package com.tdo.showbox.data.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat.Builder;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.App;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.p124a.C2982e;
import com.tdo.showbox.data.p124a.C2984g;
import com.tdo.showbox.data.torrent.TorrentAutoDownloader;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.Season;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.topic.DelayedPush;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class FMessagingService extends FirebaseMessagingService {
    /* renamed from: a */
    public void mo2138a(RemoteMessage remoteMessage) {
        C3094j.m16698a("FirebasePush", "From: " + remoteMessage.m11811a());
        m16829a(m16831b(remoteMessage));
    }

    /* renamed from: a */
    private void m16829a(DelayedPush delayedPush) {
        try {
            C3088f.m16676a(getApplicationContext());
            if (C3088f.m16682b("PREFS_SETTINGS_AUTO_DOWNLOADING")) {
                JSONObject jSONObject = new JSONObject(delayedPush.getData());
                String string = jSONObject.getString(IjkMediaMeta.IJKM_KEY_TYPE);
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("movie"));
                if (string.equals("new_episode")) {
                    TvItem a = C2984g.m16305a(jSONObject2);
                    String string2 = jSONObject2.getString("episode");
                    String string3 = jSONObject2.getString("season");
                    String string4 = jSONObject2.getString("episode_title");
                    TorrentAutoDownloader.m16855a((Context) this, a.getPoster(), a.getTitle(), a.getImdb_id(), string3, string2, string4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private DelayedPush m16831b(RemoteMessage remoteMessage) {
        JSONObject jSONObject = new JSONObject(remoteMessage.m11812b());
        String a = remoteMessage.m11811a();
        new Delete().from(DelayedPush.class).execute();
        Calendar instance = Calendar.getInstance(Locale.US);
        int i = instance.get(7);
        int i2 = instance.get(11);
        DelayedPush delayedPush = new DelayedPush();
        delayedPush.setDay_push_delivered(i);
        delayedPush.setHour_push_delivered(i2);
        delayedPush.setData(jSONObject.toString());
        delayedPush.setFrom(a);
        delayedPush.save();
        return delayedPush;
    }

    /* renamed from: a */
    public static boolean m16830a(Context context, JSONObject jSONObject, String str) {
        try {
            if (App.m15019b() != null) {
                return false;
            }
            String string = jSONObject.getString(IjkMediaMeta.IJKM_KEY_TYPE);
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("movie"));
            String string2 = jSONObject.getString("message");
            String string3 = jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_TITLE);
            if (string.equals("new_movie")) {
                MovieItem a = C2982e.m16302a(jSONObject2);
                MovieItem movieItem = (MovieItem) new Select().from(MovieItem.class).where("movie_id=" + a.getMovieId()).executeSingle();
                if (movieItem == null) {
                    a.setFrom_push(1);
                    a.save();
                } else {
                    movieItem.setFrom_push(1);
                    movieItem.save();
                }
                m16828a(context, string2, string3, false, a.getMovieId(), false, str);
            } else if (string.equals("new_episode")) {
                r4 = C2984g.m16305a(jSONObject2);
                r0 = (TvItem) new Select().from(TvItem.class).where("item_id=" + r4.getItemId()).executeSingle();
                if (r0 == null) {
                    r4.setFrom_push(1);
                    r4.save();
                } else {
                    r0.setFrom_push(1);
                    r0.setRating(r4.getRating());
                    r0.setSeasons(r4.getSeasons());
                    r0.setImdb_id(r4.getImdb_id());
                    r0.setBanner(r4.getBanner());
                    r0.setPoster(r4.getPoster());
                    r0.setCats(r4.getCats());
                    r0.save();
                    new Delete().from(Season.class).where("movie_id=" + r0.getItemId()).execute();
                    new Delete().from(Episod.class).where("mov_id=" + r0.getItemId()).execute();
                }
                m16828a(context, string2, string3, true, r4.getItemId(), true, str);
            } else if (string.equals("new_show")) {
                r4 = C2984g.m16305a(jSONObject2);
                r0 = (TvItem) new Select().from(TvItem.class).where("item_id=" + r4.getItemId()).executeSingle();
                if (r0 == null) {
                    r4.setFrom_push(1);
                    r4.save();
                } else {
                    r0.setFrom_push(1);
                    r0.setRating(r4.getRating());
                    r0.setSeasons(r4.getSeasons());
                    r0.setImdb_id(r4.getImdb_id());
                    r0.setBanner(r4.getBanner());
                    r0.setPoster(r4.getPoster());
                    r0.setCats(r4.getCats());
                    r0.save();
                    new Delete().from(Season.class).where("movie_id=" + r0.getItemId()).execute();
                    new Delete().from(Episod.class).where("mov_id=" + r0.getItemId()).execute();
                }
                m16828a(context, string2, string3, true, r4.getItemId(), false, str);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m16828a(Context context, String str, String str2, boolean z, String str3, boolean z2, String str4) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("fromNewPush", true);
        intent.putExtra("isMovie", z);
        intent.putExtra("itemId", str3);
        intent.putExtra("openLastSeason", z2);
        intent.putExtra("from", str4);
        ((NotificationManager) context.getSystemService("notification")).notify((int) System.currentTimeMillis(), new Builder(context).m513a((int) R.drawable.ic_app_show_not2).m516a(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_app)).m518a((CharSequence) str2).m522b((CharSequence) str).m519a(true).m520b(context.getResources().getColor(R.color.main_back)).m517a(RingtoneManager.getDefaultUri(2)).m515a(PendingIntent.getActivity(context, (int) (System.currentTimeMillis() & 268435455), intent, 268435456)).m512a());
    }
}
