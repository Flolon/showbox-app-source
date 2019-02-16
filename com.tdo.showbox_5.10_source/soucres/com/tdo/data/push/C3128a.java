package com.tdo.showbox.data.push;

import android.text.TextUtils;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.TvItemMeta;
import com.tdo.showbox.models.topic.CurrentTopicScheme;
import com.tdo.showbox.models.topic.FbTopic;
import com.tdo.showbox.models.topic.TopicTimeItem;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* compiled from: PushTopicManager */
/* renamed from: com.tdo.showbox.data.push.a */
public class C3128a {
    /* renamed from: a */
    public static String f12190a = "t_show_IMDB";
    /* renamed from: b */
    public static String f12191b = "t_new_show";
    /* renamed from: c */
    private static String f12192c = "PushTopicManager";
    /* renamed from: d */
    private static int f12193d = 100;

    /* compiled from: PushTopicManager */
    /* renamed from: com.tdo.showbox.data.push.a$1 */
    static class C31271 implements Comparator<TopicTimeItem> {
        C31271() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16833a((TopicTimeItem) obj, (TopicTimeItem) obj2);
        }

        /* renamed from: a */
        public int m16833a(TopicTimeItem topicTimeItem, TopicTimeItem topicTimeItem2) {
            return Integer.valueOf(topicTimeItem.getTime()).compareTo(Integer.valueOf(topicTimeItem2.getTime()));
        }
    }

    /* renamed from: a */
    public void m16844a(C2999a c2999a, AppConfig appConfig) {
        C3094j.m16698a(f12192c, "onAppLaunched");
        if (c2999a != null) {
            try {
                Calendar instance = Calendar.getInstance(Locale.US);
                m16836a(instance.get(7), instance.get(11), appConfig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m16843a() {
    }

    /* renamed from: a */
    public void m16845a(TvItem tvItem) {
        TvItemMeta tvItemMeta = TvItem.getTvItemMeta(tvItem);
        if (tvItemMeta != null && tvItemMeta.getImdb_id() != null) {
            m16840c(f12190a.replace("IMDB", tvItemMeta.getImdb_id()));
        }
    }

    /* renamed from: b */
    public void m16846b(TvItem tvItem) {
        TvItemMeta tvItemMeta = TvItem.getTvItemMeta(tvItem);
        if (tvItemMeta != null && tvItemMeta.getImdb_id() != null) {
            m16839b(f12190a.replace("IMDB", tvItemMeta.getImdb_id()));
        }
    }

    /* renamed from: b */
    private void m16839b(String str) {
        C3094j.m16698a(f12192c, "unsubscribe from " + str);
        C3129b.m16848b(str);
        new Delete().from(FbTopic.class).where("name='" + str + "'").execute();
    }

    /* renamed from: c */
    private void m16840c(String str) {
        C3094j.m16698a(f12192c, "subscribe to " + str);
        C3129b.m16847a(str);
        if (((FbTopic) new Select().from(FbTopic.class).where("name='" + str + "'").executeSingle()) == null) {
            FbTopic fbTopic = new FbTopic();
            fbTopic.setName(str);
            fbTopic.save();
        }
    }

    /* renamed from: a */
    private void m16837a(AppConfig appConfig) {
        AppConfig appConfig2;
        C3094j.m16698a(f12192c, "cfg - checkTopicsFromAppConfig");
        if (appConfig == null) {
            appConfig2 = (AppConfig) new Select().from(AppConfig.class).executeSingle();
        } else {
            appConfig2 = appConfig;
        }
        if (appConfig2 != null && !TextUtils.isEmpty(appConfig2.getPush_topic())) {
            CharSequence a = C3088f.m16675a("PREFS_CURRENT_PUSH_MOVIE_TOPIC_BASE");
            C3094j.m16698a(f12192c, "cfg - current subscribed topic: " + a);
            if (TextUtils.isEmpty(a) || !a.equals(appConfig2.getPush_topic())) {
                String a2;
                if (!TextUtils.isEmpty(a)) {
                    a2 = C3088f.m16675a("PREFS_CURRENT_PUSH_MOVIE_TOPIC");
                    C3094j.m16698a(f12192c, "cfg - unsubscribe: " + a2);
                    m16839b(a2);
                }
                a2 = appConfig2.getPush_topic() + new Random().nextInt(10);
                C3088f.m16679a("PREFS_CURRENT_PUSH_MOVIE_TOPIC_BASE", appConfig2.getPush_topic());
                C3088f.m16679a("PREFS_CURRENT_PUSH_MOVIE_TOPIC", a2);
                C3094j.m16698a(f12192c, "cfg - subscribe: " + a2);
                m16840c(a2);
            }
        }
    }

    /* renamed from: b */
    private void m16838b() {
        m16840c(f12191b);
        for (TvItem tvItem : new Select().from(TvItem.class).where("in_lib=1").execute()) {
            String imdb_id = TvItem.getTvItemMeta(tvItem).getImdb_id();
            if (imdb_id == null) {
                CharSequence imdb_id2 = tvItem.getImdb_id();
            } else {
                Object obj = imdb_id;
            }
            if (!(imdb_id2 == null || imdb_id2.length() == 0)) {
                m16840c(f12190a.replace("IMDB", imdb_id2));
            }
        }
    }

    /* renamed from: c */
    private boolean m16841c() {
        if (new Select().from(TopicTimeItem.class).execute().size() != 0) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            TopicTimeItem topicTimeItem = new TopicTimeItem();
            topicTimeItem.setDay(i);
            topicTimeItem.setTime(20);
            topicTimeItem.setLogTime(System.currentTimeMillis());
            topicTimeItem.save();
        }
        m16842d();
        return true;
    }

    /* renamed from: d */
    private CurrentTopicScheme m16842d() {
        CurrentTopicScheme currentTopicScheme = new CurrentTopicScheme();
        currentTopicScheme.setDay1time(20);
        currentTopicScheme.setDay2time(20);
        currentTopicScheme.setDay3time(20);
        currentTopicScheme.setDay4time(20);
        currentTopicScheme.setDay5time(20);
        currentTopicScheme.setDay6time(20);
        currentTopicScheme.setDay7time(20);
        currentTopicScheme.setDayPreviousTime(0);
        currentTopicScheme.setDayPreviousNumber(0);
        currentTopicScheme.save();
        return currentTopicScheme;
    }

    /* renamed from: a */
    private void m16836a(int i, int i2, AppConfig appConfig) {
        C3094j.m16698a(f12192c, "addNewRecord: day: " + i + "; time: " + i2);
        boolean c = m16841c();
        C3094j.m16698a(f12192c, "addNewRecord: firstLaunch: " + c);
        CurrentTopicScheme currentTopicScheme = (CurrentTopicScheme) new Select().from(CurrentTopicScheme.class).executeSingle();
        if (currentTopicScheme == null) {
            C3094j.m16698a(f12192c, "addNewRecord: initDefScheme");
            m16842d();
        }
        if (!(currentTopicScheme.getDayPreviousTime() == 0 || currentTopicScheme.getDayPreviousNumber() == 0)) {
            currentTopicScheme.setDayPreviousNumber(0);
            currentTopicScheme.setDayPreviousTime(0);
            currentTopicScheme.save();
        }
        List execute = new Select().from(TopicTimeItem.class).where("dayNumber=" + i).orderBy("logTime DESC").execute();
        C3094j.m16698a(f12192c, "select timesForDay size: " + execute.size());
        TopicTimeItem topicTimeItem = null;
        if (execute.size() >= f12193d) {
            topicTimeItem = (TopicTimeItem) execute.get(execute.size() - 1);
        }
        if (topicTimeItem == null) {
            topicTimeItem = new TopicTimeItem();
            topicTimeItem.setDay(i);
        }
        topicTimeItem.setTime(i2);
        topicTimeItem.setLogTime(System.currentTimeMillis());
        topicTimeItem.save();
        if (c) {
            C3094j.m16698a(f12192c, "onNewDefaultTopics");
            m16838b();
            return;
        }
        m16837a(appConfig);
        topicTimeItem = C3128a.m16835a(execute);
        if (topicTimeItem != null) {
            C3094j.m16698a(f12192c, "findMostFrequentlyHour 1 - " + topicTimeItem.getDay() + " : " + topicTimeItem.getTime());
        }
        if (topicTimeItem == null) {
            if (i == 1 || i == 7) {
                topicTimeItem = C3128a.m16835a(new Select().from(TopicTimeItem.class).where("dayNumber = 1 OR dayNumber = 7").orderBy("logTime DESC").execute());
                if (topicTimeItem != null) {
                    topicTimeItem.setDay(i);
                    C3094j.m16698a(f12192c, "findMostFrequentlyHour 2 - " + topicTimeItem.getDay() + " : " + topicTimeItem.getTime());
                }
            } else {
                topicTimeItem = C3128a.m16835a(new Select().from(TopicTimeItem.class).where("dayNumber >= 2 AND dayNumber <= 6").orderBy("logTime DESC").execute());
                if (topicTimeItem != null) {
                    topicTimeItem.setDay(i);
                    C3094j.m16698a(f12192c, "findMostFrequentlyHour 3 - " + topicTimeItem.getDay() + " : " + topicTimeItem.getTime());
                }
            }
        }
        if (topicTimeItem == null) {
            topicTimeItem = new TopicTimeItem();
            topicTimeItem.setTime(20);
            topicTimeItem.setLogTime(System.currentTimeMillis());
            topicTimeItem.setDay(i);
            C3094j.m16698a(f12192c, "findMostFrequentlyHour 4 - " + topicTimeItem.getDay() + " : " + topicTimeItem.getTime());
        }
        C3094j.m16698a(f12192c, "setTimeForDay MostFrequentlyHour  : " + topicTimeItem.getDay() + " : " + topicTimeItem.getTime());
        boolean timeForDay = currentTopicScheme.setTimeForDay(topicTimeItem);
        currentTopicScheme.save();
        if (!timeForDay) {
        }
    }

    /* renamed from: a */
    public static TopicTimeItem m16835a(List<TopicTimeItem> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return (TopicTimeItem) list.get(0);
        }
        Collections.sort(list, new C31271());
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        TopicTimeItem topicTimeItem = null;
        TopicTimeItem topicTimeItem2 = null;
        while (i < list.size()) {
            TopicTimeItem topicTimeItem3 = (TopicTimeItem) list.get(i);
            if (topicTimeItem != null) {
                if (topicTimeItem3.getTime() == topicTimeItem.getTime()) {
                    i3++;
                    if (i == list.size() - 1) {
                        if (i3 == i4) {
                            i2 = 1;
                        } else if (i3 > i4) {
                            i2 = 0;
                            i4 = i3;
                            topicTimeItem2 = topicTimeItem;
                            i3 = 0;
                        }
                    }
                } else if (i3 == i4) {
                    i2 = 1;
                } else if (i3 > i4) {
                    i2 = 0;
                    i4 = i3;
                    topicTimeItem2 = topicTimeItem;
                    i3 = 0;
                }
            }
            i++;
            topicTimeItem = topicTimeItem3;
        }
        if (i2 != 0) {
            return null;
        }
        if (topicTimeItem2 == null) {
            return topicTimeItem;
        }
        return topicTimeItem2;
    }

    /* renamed from: a */
    public static int m16834a(String str) {
        int i = -1;
        try {
            i = Calendar.getInstance(Locale.US).get(11);
        } catch (Exception e) {
        }
        return i;
    }
}
