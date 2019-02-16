package com.tdo.showbox.data.p124a;

import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.models.AlertInfoMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JParserAlerts */
/* renamed from: com.tdo.showbox.data.a.a */
public class C2978a {
    /* renamed from: a */
    public static final List<AlertInfoMessage> m16295a(String str) {
        List<AlertInfoMessage> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                AlertInfoMessage alertInfoMessage = new AlertInfoMessage();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("id")) {
                    alertInfoMessage.setMessageId(jSONObject.getString("id"));
                }
                if (jSONObject.has("text")) {
                    alertInfoMessage.setText(jSONObject.getString("text"));
                }
                if (jSONObject.has(IAWLNativeAdRequest.ASSET_TYPE_LINK)) {
                    alertInfoMessage.setLink(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_LINK));
                }
                arrayList.add(alertInfoMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
