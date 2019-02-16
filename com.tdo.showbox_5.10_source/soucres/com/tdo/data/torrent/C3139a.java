package com.tdo.showbox.data.torrent;

import android.content.Context;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.models.CatCRTorrentItem;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p131f.C3173b;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: TorrentSearchManager */
/* renamed from: com.tdo.showbox.data.torrent.a */
public class C3139a {
    /* renamed from: a */
    private C2999a f12219a;
    /* renamed from: b */
    private String f12220b = "https://yts.ag/api/v2/list_movies.json?query_term=";
    /* renamed from: c */
    private String f12221c = "http://api.ukfrnlge.com/show?imdb=";
    /* renamed from: d */
    private String f12222d = "http://api.ukfrnlge.com/list?cb=%s&sort=seeds&quality=720p,1080p&keywords=%s&page=1";
    /* renamed from: e */
    private long f12223e = 1500000000;
    /* renamed from: f */
    private long f12224f = 2000000000;
    /* renamed from: g */
    private long f12225g = 800000000;
    /* renamed from: h */
    private long f12226h = 1500000000;

    /* compiled from: TorrentSearchManager */
    /* renamed from: com.tdo.showbox.data.torrent.a$a */
    public interface C2750a {
        /* renamed from: a */
        void mo2033a(List<CatCRTorrentItem> list);
    }

    /* compiled from: TorrentSearchManager */
    /* renamed from: com.tdo.showbox.data.torrent.a$3 */
    class C31373 implements Comparator<CatCRTorrentItem> {
        /* renamed from: a */
        final /* synthetic */ C3139a f12217a;

        C31373(C3139a c3139a) {
            this.f12217a = c3139a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16864a((CatCRTorrentItem) obj, (CatCRTorrentItem) obj2);
        }

        /* renamed from: a */
        public int m16864a(CatCRTorrentItem catCRTorrentItem, CatCRTorrentItem catCRTorrentItem2) {
            if (catCRTorrentItem.getSeeds() == catCRTorrentItem2.getSeeds()) {
                return 0;
            }
            if (catCRTorrentItem.getSeeds() > catCRTorrentItem2.getSeeds()) {
                return -1;
            }
            return 1;
        }
    }

    /* compiled from: TorrentSearchManager */
    /* renamed from: com.tdo.showbox.data.torrent.a$4 */
    class C31384 implements Comparator<CatCRTorrentItem> {
        /* renamed from: a */
        final /* synthetic */ C3139a f12218a;

        C31384(C3139a c3139a) {
            this.f12218a = c3139a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16865a((CatCRTorrentItem) obj, (CatCRTorrentItem) obj2);
        }

        /* renamed from: a */
        public int m16865a(CatCRTorrentItem catCRTorrentItem, CatCRTorrentItem catCRTorrentItem2) {
            if (catCRTorrentItem.getSeeds() == catCRTorrentItem2.getSeeds()) {
                return 0;
            }
            if (catCRTorrentItem.getSeeds() > catCRTorrentItem2.getSeeds()) {
                return -1;
            }
            return 1;
        }
    }

    public C3139a(C2999a c2999a) {
        this.f12219a = c2999a;
    }

    /* renamed from: a */
    public void m16877a(String str, int i, int i2, String str2, C2750a c2750a) {
        if (this.f12219a != null) {
            final String str3 = str2;
            final int i3 = i;
            final int i4 = i2;
            final C2750a c2750a2 = c2750a;
            new Thread(new Runnable(this) {
                /* renamed from: e */
                final /* synthetic */ C3139a f12211e;

                public void run() {
                    try {
                        String str = "";
                        if (this.f12211e.f12219a.m16342b()) {
                            C3094j.m16698a("TorrentSearchManager", "getSyncHttpsWithoutHeader start : " + str3);
                            str = this.f12211e.f12219a.m16346d(this.f12211e.f12221c + str3);
                            C3094j.m16698a("TorrentSearchManager", "getSyncHttpsWithoutHeader end");
                        }
                        if (str == null || str.length() == 0) {
                            C3065b.m16569a("popcorn_api_request", "status", "fail");
                        } else {
                            C3065b.m16569a("popcorn_api_request", "status", "success");
                        }
                        List arrayList = new ArrayList();
                        arrayList.addAll(ObjParser.m16277a(str, i3, i4));
                        List a = this.f12211e.m16870a(arrayList, this.f12211e.f12225g, this.f12211e.f12226h);
                        if (c2750a2 != null) {
                            c2750a2.mo2033a(a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (c2750a2 != null) {
                            c2750a2.mo2033a(new ArrayList());
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    public void m16878a(String str, String str2, C2750a c2750a) {
        final String a = m16868a(str2);
        if (this.f12219a != null) {
            final String str3 = str;
            final String str4 = str2;
            final C2750a c2750a2 = c2750a;
            new Thread(new Runnable(this) {
                /* renamed from: e */
                final /* synthetic */ C3139a f12216e;

                public void run() {
                    try {
                        String e = this.f12216e.f12219a.m16349e(a);
                        String str = "";
                        if (this.f12216e.f12219a.m16342b()) {
                            str = "" + new Random().nextDouble();
                            String encode = URLEncoder.encode(str3.toLowerCase(), "UTF-8");
                            str = this.f12216e.f12219a.m16346d(String.format(this.f12216e.f12222d, new Object[]{str, encode}));
                            if (str == null || str.length() == 0) {
                                C3065b.m16569a("popcorn_api_request", "status", "fail");
                            } else {
                                C3065b.m16569a("popcorn_api_request", "status", "success");
                            }
                        }
                        List arrayList = new ArrayList();
                        Collection f = ObjParser.m16289f(e);
                        Collection c = ObjParser.m16283c(str, str4);
                        arrayList.addAll(f);
                        arrayList.addAll(c);
                        List a = this.f12216e.m16870a(arrayList, this.f12216e.f12223e, this.f12216e.f12224f);
                        if (c2750a2 != null) {
                            c2750a2.mo2033a(a);
                        }
                    } catch (Exception e2) {
                        if (c2750a2 != null) {
                            c2750a2.mo2033a(new ArrayList());
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    private List<CatCRTorrentItem> m16870a(List<CatCRTorrentItem> list, long j, long j2) {
        CatCRTorrentItem catCRTorrentItem;
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CatCRTorrentItem catCRTorrentItem2 : list) {
            if (catCRTorrentItem2.getTitle().contains("1080p") && catCRTorrentItem2.getSeeds() > 0) {
                arrayList2.add(catCRTorrentItem2);
            } else if (catCRTorrentItem2.getSeeds() > 0) {
                arrayList.add(catCRTorrentItem2);
            }
        }
        Collections.sort(arrayList, new C31373(this));
        Collections.sort(arrayList2, new C31384(this));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            catCRTorrentItem2 = (CatCRTorrentItem) it.next();
            if (catCRTorrentItem2.getSeeds() > 50 && catCRTorrentItem2.getSize() < j) {
                arrayList.remove(catCRTorrentItem2);
                arrayList.add(0, catCRTorrentItem2);
                break;
            }
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            catCRTorrentItem2 = (CatCRTorrentItem) it.next();
            if (catCRTorrentItem2.getSeeds() > 50 && catCRTorrentItem2.getSize() < j2) {
                arrayList2.remove(catCRTorrentItem2);
                arrayList2.add(0, catCRTorrentItem2);
                break;
            }
        }
        if (arrayList.size() > 0 && ((CatCRTorrentItem) arrayList.get(0)).getSeeds() > 50) {
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
        } else if (arrayList2.size() <= 0 || ((CatCRTorrentItem) arrayList2.get(0)).getSeeds() <= 50) {
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
        } else {
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(arrayList);
        }
        if (list.size() > 0 && arrayList3.size() == 0) {
            catCRTorrentItem2 = (CatCRTorrentItem) list.get(0);
            catCRTorrentItem2.setTitle(catCRTorrentItem2.getTitle() + "720p");
            if (catCRTorrentItem2.getSeeds() > 0) {
                arrayList3.add(catCRTorrentItem2);
            }
        }
        return arrayList3;
    }

    /* renamed from: a */
    private String m16868a(String str) {
        try {
            return this.f12220b + str;
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m16867a(Context context, CatCRTorrentItem catCRTorrentItem) {
        String str = "";
        String string = context.getString(R.string.torrent_seeds);
        if (catCRTorrentItem.getTitle().contains("1080p")) {
            str = "1080p - ";
        } else {
            str = "720p - ";
        }
        String str2 = "" + catCRTorrentItem.getSize();
        try {
            str2 = C3173b.m16956a(catCRTorrentItem.getSize()).replace(',', Utils.EXTENSION_SEPARATOR);
        } catch (Exception e) {
        }
        return str + str2 + " - " + catCRTorrentItem.getSeeds() + " " + string;
    }

    /* renamed from: b */
    public BaseVideoSource m16879b(Context context, CatCRTorrentItem catCRTorrentItem) {
        String str;
        String str2;
        BaseVideoSource baseVideoSource = null;
        String title = catCRTorrentItem.getTitle();
        if (title == null) {
            title = null;
            str = null;
            str2 = null;
        } else if (title.contains("1080p")) {
            str = catCRTorrentItem.getTorrentLink();
            str2 = null;
            title = null;
        } else if (title.contains("720p")) {
            str = null;
            str2 = catCRTorrentItem.getTorrentLink();
            title = null;
        } else {
            title = catCRTorrentItem.getTorrentLink();
            str = null;
            str2 = null;
        }
        if (!(str2 == null && title == null && str == null)) {
            baseVideoSource = new BaseVideoSource();
            baseVideoSource.setSource_mode_id(7);
            if (context != null) {
                baseVideoSource.setSource_name(context.getString(R.string.source_name_torrent));
            }
            baseVideoSource.setPriority(5);
            if (str != null) {
                baseVideoSource.setStatic_link(str);
                baseVideoSource.setFull_hd_link(str);
            }
            if (str2 != null) {
                baseVideoSource.setStatic_link(str2);
                baseVideoSource.setHd_link(str2);
            }
            if (title != null) {
                baseVideoSource.setStatic_link(title);
                baseVideoSource.setMid_link(title);
            }
        }
        return baseVideoSource;
    }
}
