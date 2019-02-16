package com.tdo.showbox.data.p124a;

import com.tdo.showbox.models.CatCRTorrentItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JParserCRTTorrent */
/* renamed from: com.tdo.showbox.data.a.b */
public class C2979b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final java.util.List<com.tdo.showbox.models.CatCRTorrentItem> m16296a(java.lang.String r10) {
        /*
        r0 = 0;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00c4 }
        r3.<init>(r10);	 Catch:{ Exception -> 0x00c4 }
        r1 = "data";
        r1 = r3.getJSONObject(r1);	 Catch:{ Exception -> 0x00c4 }
        r4 = "movies";
        r1 = r1.getJSONArray(r4);	 Catch:{ Exception -> 0x00c4 }
        r4 = 0;
        r1 = r1.getJSONObject(r4);	 Catch:{ Exception -> 0x00c4 }
        r4 = "torrents";
        r4 = r1.getJSONArray(r4);	 Catch:{ Exception -> 0x00c4 }
        r1 = r0;
    L_0x0023:
        r0 = r4.length();	 Catch:{ Exception -> 0x00c4 }
        if (r1 >= r0) goto L_0x00c5;
    L_0x0029:
        r5 = new com.tdo.showbox.models.CatCRTorrentItem;	 Catch:{ Exception -> 0x00c4 }
        r5.<init>();	 Catch:{ Exception -> 0x00c4 }
        r6 = r4.getJSONObject(r1);	 Catch:{ Exception -> 0x00c4 }
        r0 = "url";
        r0 = r6.has(r0);	 Catch:{ Exception -> 0x00c4 }
        if (r0 == 0) goto L_0x0043;
    L_0x003a:
        r0 = "url";
        r0 = r6.getString(r0);	 Catch:{ Exception -> 0x00c4 }
        r5.setTorrentLink(r0);	 Catch:{ Exception -> 0x00c4 }
    L_0x0043:
        r0 = "peers";
        r0 = r6.has(r0);	 Catch:{ Exception -> 0x00c4 }
        if (r0 == 0) goto L_0x0054;
    L_0x004b:
        r0 = "peers";
        r8 = r6.getLong(r0);	 Catch:{ Exception -> 0x00c4 }
        r5.setPeers(r8);	 Catch:{ Exception -> 0x00c4 }
    L_0x0054:
        r0 = "seeds";
        r0 = r6.has(r0);	 Catch:{ Exception -> 0x00c4 }
        if (r0 == 0) goto L_0x0065;
    L_0x005c:
        r0 = "seeds";
        r8 = r6.getLong(r0);	 Catch:{ Exception -> 0x00c4 }
        r5.setSeeds(r8);	 Catch:{ Exception -> 0x00c4 }
    L_0x0065:
        r0 = "size_bytes";
        r0 = r6.has(r0);	 Catch:{ Exception -> 0x00c4 }
        if (r0 == 0) goto L_0x0076;
    L_0x006d:
        r0 = "size_bytes";
        r8 = r6.getLong(r0);	 Catch:{ Exception -> 0x00c4 }
        r5.setSize(r8);	 Catch:{ Exception -> 0x00c4 }
    L_0x0076:
        r0 = "";
        r7 = "quality";
        r7 = r6.has(r7);	 Catch:{ Exception -> 0x00c4 }
        if (r7 == 0) goto L_0x0086;
    L_0x0080:
        r0 = "quality";
        r0 = r6.getString(r0);	 Catch:{ Exception -> 0x00c4 }
    L_0x0086:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r6.<init>();	 Catch:{ Exception -> 0x00bf }
        r7 = "data";
        r7 = r3.getJSONObject(r7);	 Catch:{ Exception -> 0x00bf }
        r8 = "movies";
        r7 = r7.getJSONArray(r8);	 Catch:{ Exception -> 0x00bf }
        r8 = 0;
        r7 = r7.getJSONObject(r8);	 Catch:{ Exception -> 0x00bf }
        r8 = "title_english";
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x00bf }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x00bf }
        r7 = " - ";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x00bf }
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x00bf }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00bf }
        r5.setTitle(r6);	 Catch:{ Exception -> 0x00bf }
    L_0x00b7:
        r2.add(r5);	 Catch:{ Exception -> 0x00c4 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0023;
    L_0x00bf:
        r6 = move-exception;
        r5.setTitle(r0);	 Catch:{ Exception -> 0x00c4 }
        goto L_0x00b7;
    L_0x00c4:
        r0 = move-exception;
    L_0x00c5:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.data.a.b.a(java.lang.String):java.util.List<com.tdo.showbox.models.CatCRTorrentItem>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final java.util.List<com.tdo.showbox.models.CatCRTorrentItem> m16298a(java.lang.String r8, java.lang.String r9) {
        /*
        r0 = 0;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00a7 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x00a7 }
        r3 = "MovieList";
        r3 = r1.getJSONArray(r3);	 Catch:{ Exception -> 0x00a7 }
        r1 = r0;
    L_0x0012:
        r4 = r3.length();	 Catch:{ Exception -> 0x00a7 }
        if (r1 >= r4) goto L_0x00a8;
    L_0x0018:
        r4 = r3.getJSONObject(r1);	 Catch:{ Exception -> 0x00a7 }
        r5 = "imdb";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x00a7 }
        r5 = r5.equals(r9);	 Catch:{ Exception -> 0x00a7 }
        if (r5 == 0) goto L_0x00a9;
    L_0x0028:
        r1 = "items";
        r3 = r4.getJSONArray(r1);	 Catch:{ Exception -> 0x00a7 }
        r1 = r0;
    L_0x002f:
        r0 = r3.length();	 Catch:{ Exception -> 0x00a7 }
        if (r1 >= r0) goto L_0x00a8;
    L_0x0035:
        r4 = new com.tdo.showbox.models.CatCRTorrentItem;	 Catch:{ Exception -> 0x00a7 }
        r4.<init>();	 Catch:{ Exception -> 0x00a7 }
        r5 = r3.getJSONObject(r1);	 Catch:{ Exception -> 0x00a7 }
        r0 = "torrent_magnet";
        r0 = r5.has(r0);	 Catch:{ Exception -> 0x00a7 }
        if (r0 == 0) goto L_0x004f;
    L_0x0046:
        r0 = "torrent_magnet";
        r0 = r5.getString(r0);	 Catch:{ Exception -> 0x00a7 }
        r4.setTorrentLink(r0);	 Catch:{ Exception -> 0x00a7 }
    L_0x004f:
        r0 = "torrent_peers";
        r0 = r5.has(r0);	 Catch:{ Exception -> 0x00a7 }
        if (r0 == 0) goto L_0x0060;
    L_0x0057:
        r0 = "torrent_peers";
        r6 = r5.getLong(r0);	 Catch:{ Exception -> 0x00a7 }
        r4.setPeers(r6);	 Catch:{ Exception -> 0x00a7 }
    L_0x0060:
        r0 = "torrent_seeds";
        r0 = r5.has(r0);	 Catch:{ Exception -> 0x00a7 }
        if (r0 == 0) goto L_0x0071;
    L_0x0068:
        r0 = "torrent_seeds";
        r6 = r5.getLong(r0);	 Catch:{ Exception -> 0x00a7 }
        r4.setSeeds(r6);	 Catch:{ Exception -> 0x00a7 }
    L_0x0071:
        r0 = "size_bytes";
        r0 = r5.has(r0);	 Catch:{ Exception -> 0x00a7 }
        if (r0 == 0) goto L_0x0082;
    L_0x0079:
        r0 = "size_bytes";
        r6 = r5.getLong(r0);	 Catch:{ Exception -> 0x00a7 }
        r4.setSize(r6);	 Catch:{ Exception -> 0x00a7 }
    L_0x0082:
        r0 = "";
        r6 = "quality";
        r6 = r5.has(r6);	 Catch:{ Exception -> 0x00a7 }
        if (r6 == 0) goto L_0x0092;
    L_0x008c:
        r0 = "quality";
        r0 = r5.getString(r0);	 Catch:{ Exception -> 0x00a7 }
    L_0x0092:
        r6 = "file";
        r5 = r5.getString(r6);	 Catch:{ Exception -> 0x00a2 }
        r4.setTitle(r5);	 Catch:{ Exception -> 0x00a2 }
    L_0x009b:
        r2.add(r4);	 Catch:{ Exception -> 0x00a7 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x002f;
    L_0x00a2:
        r5 = move-exception;
        r4.setTitle(r0);	 Catch:{ Exception -> 0x00a7 }
        goto L_0x009b;
    L_0x00a7:
        r0 = move-exception;
    L_0x00a8:
        return r2;
    L_0x00a9:
        r1 = r1 + 1;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.data.a.b.a(java.lang.String, java.lang.String):java.util.List<com.tdo.showbox.models.CatCRTorrentItem>");
    }

    /* renamed from: a */
    public static final List<CatCRTorrentItem> m16297a(String str, int i, int i2) {
        List<CatCRTorrentItem> arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(str);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (Integer.valueOf(str2).intValue() == i) {
                JSONArray jSONArray = jSONObject.getJSONArray(str2);
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.getString("season").equals("" + i) && jSONObject2.getString("episode").equals("" + i2)) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("items");
                        int i4 = 0;
                        while (i4 < jSONArray2.length()) {
                            CatCRTorrentItem catCRTorrentItem = new CatCRTorrentItem();
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                            if (jSONObject3.has("torrent_magnet")) {
                                catCRTorrentItem.setTorrentLink(jSONObject3.getString("torrent_magnet"));
                            }
                            if (jSONObject3.has("torrent_peers")) {
                                catCRTorrentItem.setPeers(jSONObject3.getLong("torrent_peers"));
                            }
                            if (jSONObject3.has("torrent_seeds")) {
                                catCRTorrentItem.setSeeds(jSONObject3.getLong("torrent_seeds"));
                            }
                            if (jSONObject3.has("size_bytes")) {
                                catCRTorrentItem.setSize(jSONObject3.getLong("size_bytes"));
                            }
                            str2 = "";
                            if (jSONObject3.has("quality")) {
                                str2 = jSONObject3.getString("quality");
                            }
                            try {
                                catCRTorrentItem.setTitle(jSONObject3.getString("file"));
                            } catch (Exception e) {
                                catCRTorrentItem.setTitle(str2);
                            }
                            try {
                                arrayList.add(catCRTorrentItem);
                                i4++;
                            } catch (Exception e2) {
                            }
                        }
                        continue;
                    } else {
                        i3++;
                    }
                }
                continue;
            }
        }
        return arrayList;
    }
}
