package com.tdo.showbox.data.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.activeandroid.query.Select;
import com.iawl.api.ads.sdk.IAWLMediationDefs;
import com.startapp.android.publish.common.metaData.MetaData;
import com.tdo.showbox.ParsersFuck;
import com.tdo.showbox.data.C3087e;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3091g;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.httpclient.AsyncHttpClient;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.api.httpclient.RequestParams;
import com.tdo.showbox.data.api.httpclient.SyncHttpClient;
import com.tdo.showbox.data.api.p125a.C2998b;
import com.tdo.showbox.data.vproviders.RtProvider;
import com.tdo.showbox.data.vproviders.RtProvider.RtProviderExtractor;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.BaseResponse;
import com.tdo.showbox.p111a.C2606a;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.p132a.C3168a;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: ApiClient */
/* renamed from: com.tdo.showbox.data.api.a */
public class C2999a {
    /* renamed from: C */
    private static AsyncHttpClient f11823C;
    /* renamed from: b */
    public static String f11824b = "";
    /* renamed from: l */
    public static String f11825l = (f11824b + "/api/serials/mw_sign_s/?token=");
    /* renamed from: A */
    private String f11826A = (f11824b + "/api/serials/movie_details_s/?id=");
    /* renamed from: B */
    private boolean f11827B = true;
    /* renamed from: D */
    private Context f11828D;
    /* renamed from: E */
    private RtProvider f11829E;
    /* renamed from: a */
    public String f11830a = "";
    /* renamed from: c */
    public String f11831c = "";
    /* renamed from: d */
    public String f11832d = (f11824b + "/api/serials/version");
    /* renamed from: e */
    public String f11833e = (f11824b + "/api/serials/get_tv_data_en");
    /* renamed from: f */
    public String f11834f = (f11824b + "/api/serials/episode_details_s/");
    /* renamed from: g */
    public String f11835g = (f11824b + "/api/serials/invalid_video/?");
    /* renamed from: h */
    public String f11836h = (f11824b + "/api/serials/invalid_doc_video/?");
    /* renamed from: i */
    public String f11837i = (f11824b + "/api/moviebox/invalid_torrent/?");
    /* renamed from: j */
    public String f11838j = (f11824b + "/api/serials/notfound_video/?");
    /* renamed from: k */
    public String f11839k = (f11824b + "/api/serials/get_imdb_by_id");
    /* renamed from: m */
    public String f11840m = (f11824b + "/api/serials/set_rating/?");
    /* renamed from: n */
    public String f11841n = (f11824b + "/api/serials/news_list/?");
    /* renamed from: o */
    public String f11842o = (f11824b + "/api/serials/news_one/?id=");
    /* renamed from: p */
    public String f11843p = (f11824b + "/api/serials/trailers_movies/?feed=");
    /* renamed from: q */
    public String f11844q = (f11824b + "/api/serials/trailers/?id=");
    /* renamed from: r */
    public String f11845r = (f11824b + "/api/musicbox/get_hash/");
    /* renamed from: s */
    public String f11846s = (f11824b + "/api/serials/curdate/");
    /* renamed from: t */
    public String f11847t = "https://kat.cr/json.php?q=%s+category:music&field=seeders&order=desc";
    /* renamed from: u */
    public String f11848u = (f11824b + "/api/serials/tv_list/");
    /* renamed from: v */
    public String f11849v = (f11824b + "/api/serials/movies_list/");
    /* renamed from: w */
    public String f11850w = (f11824b + "/api/serials/updates/");
    /* renamed from: x */
    public String f11851x = (f11824b + "/api/serials/trends/");
    /* renamed from: y */
    public String f11852y = (f11824b + "/api/serials/config/");
    /* renamed from: z */
    public String f11853z = (f11824b + "/api/serials/get_ads/");

    /* compiled from: ApiClient */
    /* renamed from: com.tdo.showbox.data.api.a$1 */
    class C29881 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2999a f11805a;

        C29881(C2999a c2999a) {
            this.f11805a = c2999a;
        }

        public void onSuccess(String str) {
            super.onSuccess(str);
            C3094j.m16698a("ApiClient", "sendVersion success response: " + str);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            C3094j.m16698a("ApiClient", "sendVersion fail: " + str);
        }
    }

    /* compiled from: ApiClient */
    /* renamed from: com.tdo.showbox.data.api.a$2 */
    class C29892 extends SyncHttpClient {
        /* renamed from: a */
        final /* synthetic */ C2999a f11806a;

        C29892(C2999a c2999a) {
            this.f11806a = c2999a;
        }

        public String onRequestFailed(Throwable th, String str) {
            return null;
        }
    }

    /* compiled from: ApiClient */
    /* renamed from: com.tdo.showbox.data.api.a$a */
    public interface C2992a {
        /* renamed from: a */
        void m16314a(int i, String str, String str2);

        /* renamed from: a */
        void m16315a(String str);
    }

    /* compiled from: ApiClient */
    /* renamed from: com.tdo.showbox.data.api.a$b */
    private class C2995b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2999a f11815a;
        /* renamed from: b */
        private String f11816b;
        /* renamed from: c */
        private C2992a f11817c;
        /* renamed from: d */
        private Activity f11818d;
        /* renamed from: e */
        private String f11819e = (" moon url: " + this.f11816b);

        /* compiled from: ApiClient */
        /* renamed from: com.tdo.showbox.data.api.a$b$2 */
        class C29942 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C2995b f11814a;

            C29942(C2995b c2995b) {
                this.f11814a = c2995b;
            }

            public void run() {
                if (this.f11814a.f11817c != null) {
                    this.f11814a.f11817c.m16315a("Server not responded");
                }
            }
        }

        public C2995b(C2999a c2999a, Activity activity, String str, C2992a c2992a) {
            this.f11815a = c2999a;
            this.f11817c = c2992a;
            this.f11816b = str;
            this.f11818d = activity;
        }

        /* renamed from: a */
        public BaseResponse m16317a() {
            BaseResponse baseResponse = new BaseResponse();
            try {
                JSONObject jSONObject = new JSONObject(this.f11815a.m16324g(this.f11816b));
                String str = "";
                str = jSONObject.getString("hash_alpha");
                String string = jSONObject.getString("hash_beta");
                byte[] bytes = "sdnsmcdskmsfls9kKHKJHJKNH==".getBytes();
                String a = C3088f.m16675a("t_seed_device");
                if (!TextUtils.isEmpty(a)) {
                    bytes = a.getBytes();
                }
                byte[] bytes2 = ("" + System.currentTimeMillis()).getBytes();
                byte[] a2 = C3091g.m16689a(null, a);
                ParsersFuck.settok(a2);
                C3168a.m16947a();
                str = C3091g.m16687a(Base64.decode(str, 0), Base64.decode(string, 0), C2999a.m16323b(this.f11816b), this.f11818d, bytes, bytes2, a2);
                C3168a.m16949b();
                String[] split = str.split("\\:");
                CharSequence charSequence = split[2];
                str = this.f11815a.m16324g("http://%IPADD%/video/%TOKEN%/manifest_mp4.json?sign=%SIGN%&expires_at=%EXPIRE%".replace("%TOKEN%", C2999a.m16323b(this.f11816b)).replace("%IPADD%", split[0]).replace("%SIGN%", charSequence).replace("%EXPIRE%", split[1]));
                baseResponse.setCode(0);
                baseResponse.setCokies("");
                baseResponse.setResponse(str);
                baseResponse.setLogs(this.f11819e);
                return baseResponse;
            } catch (Exception e) {
                Writer charArrayWriter = new CharArrayWriter();
                PrintWriter printWriter = new PrintWriter(charArrayWriter);
                e.printStackTrace(printWriter);
                printWriter.close();
                charArrayWriter.toString();
                baseResponse.setLogs(this.f11819e);
                e.printStackTrace();
                baseResponse.setCode(1);
                baseResponse.setCokies("");
                baseResponse.setResponse("");
                return baseResponse;
            }
        }

        public void run() {
            final BaseResponse a = m16317a();
            if (a.getCode() == 0) {
                this.f11818d.runOnUiThread(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2995b f11813b;

                    public void run() {
                        if (this.f11813b.f11817c != null) {
                            this.f11813b.f11817c.m16314a(0, a.getResponse(), a.getCokies());
                        }
                    }
                });
            } else {
                this.f11818d.runOnUiThread(new C29942(this));
            }
        }
    }

    /* compiled from: ApiClient */
    /* renamed from: com.tdo.showbox.data.api.a$c */
    public static class C2996c {
        /* renamed from: a */
        private String f11820a;

        public C2996c(String str) {
            this.f11820a = str;
        }

        /* renamed from: a */
        public BaseResponse m16318a() {
            BaseResponse baseResponse = new BaseResponse();
            try {
                URLConnection uRLConnection;
                URLConnection uRLConnection2;
                InputStream inputStream;
                URL url = new URL(this.f11820a);
                if (this.f11820a.startsWith("https") || this.f11820a.startsWith("HTTPS")) {
                    uRLConnection = (HttpsURLConnection) url.openConnection();
                    ((HttpsURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                    uRLConnection2 = uRLConnection;
                } else {
                    uRLConnection = (HttpURLConnection) url.openConnection();
                    ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                    uRLConnection2 = uRLConnection;
                }
                uRLConnection2.setConnectTimeout(6000);
                uRLConnection2.setReadTimeout(6000);
                uRLConnection2.setRequestProperty("Accept-Language", "en-US;q=0.5,en;q=0.3");
                uRLConnection2.setRequestProperty("User-Agent", "Mozilla/5.0 (Android; Mobile; rv:14.0) Gecko/14.0 Firefox/14.0");
                String headerField = uRLConnection2.getHeaderField("Content-Encoding");
                if (headerField == null || !headerField.contains("gzip")) {
                    inputStream = uRLConnection2.getInputStream();
                } else {
                    inputStream = (GZIPInputStream) uRLConnection2.getInputStream();
                }
                String a = C3176e.m16967a(inputStream);
                boolean e = ObjParser.m16287e(a);
                Map headerFields = uRLConnection2.getHeaderFields();
                String str = "";
                if (headerFields.containsKey("Set-Cookie")) {
                    for (String headerField2 : (Collection) headerFields.get("Set-Cookie")) {
                        str = str + headerField2 + ",";
                    }
                }
                String str2 = str;
                headerField2 = uRLConnection2.getHeaderField("Location");
                if (headerField2 == null) {
                    baseResponse.setCode(0);
                    baseResponse.setCokies(str2);
                    baseResponse.setResponse(a);
                    return baseResponse;
                }
                URL url2 = new URL(headerField2);
                if (headerField2.startsWith("https") || headerField2.startsWith("HTTPS")) {
                    uRLConnection = (HttpsURLConnection) url2.openConnection();
                    ((HttpsURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                    uRLConnection2 = uRLConnection;
                } else {
                    uRLConnection = (HttpURLConnection) url2.openConnection();
                    ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                    uRLConnection2 = uRLConnection;
                }
                uRLConnection2.setConnectTimeout(6000);
                uRLConnection2.setReadTimeout(6000);
                headerField2 = ObjParser.m16281b(str2, "remixmdv=.*?;");
                uRLConnection2.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
                uRLConnection2.setRequestProperty("Cookie", "remixlang=3;" + headerField2 + "remixmdevice=1920/1080/1/!!-!!!!");
                uRLConnection2.setRequestProperty("User-Agent", "Mozilla/5.0 (Android; Mobile; rv:14.0) Gecko/14.0 Firefox/14.0");
                headerField2 = uRLConnection2.getHeaderField("Content-Encoding");
                if (headerField2 == null || !headerField2.contains("gzip")) {
                    inputStream = uRLConnection2.getInputStream();
                } else {
                    try {
                        inputStream = (GZIPInputStream) uRLConnection2.getInputStream();
                    } catch (ClassCastException e2) {
                        inputStream = uRLConnection2.getInputStream();
                    }
                }
                str = C3176e.m16967a(inputStream);
                if (e) {
                    C3094j.m16698a(MetaData.DEFAULT_LOCATION_SOURCE, "video found");
                    headerField2 = str;
                } else {
                    AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
                    if (appConfig != null) {
                        C3094j.m16698a(MetaData.DEFAULT_LOCATION_SOURCE, "video not found");
                        headerField2 = appConfig.getNotfound_video();
                    }
                    headerField2 = str;
                }
                str = C2999a.m16322a(uRLConnection2);
                baseResponse.setCode(0);
                baseResponse.setCokies(str);
                baseResponse.setResponse(headerField2);
                return baseResponse;
            } catch (Exception e3) {
                baseResponse.setCode(1);
                baseResponse.setCokies("");
                baseResponse.setResponse("");
                return baseResponse;
            }
        }
    }

    public C2999a(Context context) {
        if (f11823C == null) {
            f11823C = new AsyncHttpClient();
        }
        f11823C.setTimeout(10000);
        f11823C.getHttpClient().getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        f11823C.setUserAgent("Show Box");
        try {
            f11823C.setSSLSocketFactory(new C2998b(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f11828D = context;
    }

    /* renamed from: a */
    public void m16331a(AppConfig appConfig) {
        int i = 0;
        f11824b = appConfig.getSrv();
        this.f11830a = appConfig.getUpd_vk();
        this.f11831c = appConfig.getShare_link();
        this.f11845r = f11824b + "/api/musicbox/get_hash/";
        this.f11844q = f11824b + "/api/serials/trailers/?id=";
        this.f11843p = f11824b + "/api/serials/trailers_movies/?feed=";
        this.f11842o = f11824b + "/api/serials/news_one/?id=";
        this.f11841n = f11824b + "/api/serials/news_list/?";
        this.f11833e = f11824b + "/api/serials/es";
        this.f11826A = f11824b + "/api/serials/movie_details_s/?id=";
        this.f11834f = f11824b + "/api/serials/episode_details_s/";
        this.f11835g = f11824b + "/api/serials/invalid_video/?";
        this.f11836h = f11824b + "/api/serials/invalid_doc_video/?";
        this.f11839k = f11824b + "/api/serials/get_imdb_by_id";
        f11825l = f11824b + "/api/serials/mw_sign_s/?token=";
        this.f11838j = f11824b + "/api/serials/notfound_video/?";
        this.f11837i = f11824b + "/api/moviebox/invalid_torrent/?";
        this.f11840m = f11824b + "/api/serials/set_rating/?";
        this.f11846s = f11824b + "/api/serials/curdate/";
        this.f11848u = f11824b + "/api/serials/tv_list/";
        this.f11849v = f11824b + "/api/serials/movies_list/";
        this.f11850w = f11824b + "/api/serials/updates/";
        this.f11851x = f11824b + "/api/serials/trends/";
        this.f11832d = f11824b + "/api/serials/version";
        this.f11852y = f11824b + "/api/serials/config/";
        this.f11853z = f11824b + "/api/serials/get_ads/";
        this.f11853z = "http://188.166.52.63/api/serials/get_ads/";
        if (this.f11828D != null && !C3088f.m16682b("PREF_VERSION_SENT")) {
            try {
                C3088f.m16680a("PREF_VERSION_SENT", true);
                String str = this.f11828D.getPackageManager().getPackageInfo(this.f11828D.getPackageName(), 128).versionName;
                String str2 = "0";
                int[] iArr = new int[]{102, 253, 88, 170, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE};
                iArr[0] = iArr[0] ^ 0;
                iArr[1] = iArr[1] ^ 143;
                iArr[2] = iArr[2] ^ 49;
                iArr[3] = iArr[3] ^ 206;
                iArr[4] = iArr[4] ^ 149;
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 : iArr) {
                    stringBuilder.append((char) i2);
                }
                CharSequence stringBuilder2 = stringBuilder.toString();
                File file = new File(this.f11828D.getApplicationInfo().nativeLibraryDir);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    while (i < length) {
                        if (listFiles[i].getName().toLowerCase().contains(stringBuilder2)) {
                            str2 = "1";
                        }
                        i++;
                    }
                }
                m16350e(str, str2, new C29881(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m16328a(WebView webView, String str, String str2, String str3, String str4, RtProviderExtractor rtProviderExtractor) {
        if (webView != null) {
            webView.stopLoading();
        }
        this.f11829E = new RtProvider(this.f11828D, str2, str3);
        this.f11829E.m16891a(webView, str4, str, rtProviderExtractor);
    }

    /* renamed from: a */
    public void m16326a() {
        if (this.f11829E != null) {
            this.f11829E.m16890a();
        }
    }

    /* renamed from: b */
    public boolean m16342b() {
        return this.f11827B;
    }

    /* renamed from: a */
    public static String m16320a(String str) {
        return f11825l + str;
    }

    /* renamed from: b */
    public static String m16323b(String str) {
        return str.replace(f11825l, "");
    }

    /* renamed from: a */
    public void m16336a(String str, String str2, String str3, String str4, String str5, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str6 = this.f11837i + "type=" + str2 + "&id=" + str + "&hd=" + str3 + "&season=" + str4 + "&episode=" + str5;
        C3094j.m16698a("sendBrokenTorrent", str6);
        f11823C.get(str6, asyncHttpResponseHandler);
    }

    /* renamed from: a */
    public void m16334a(String str, String str2, String str3, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str4 = this.f11834f + "?h=" + str + "&u=" + str2 + "&y=" + str3;
        C3094j.m16698a("getEpisodeDetails", "url: " + str4);
        f11823C.get(str4, asyncHttpResponseHandler);
    }

    /* renamed from: a */
    public void m16333a(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("id", str);
        if (!(str2 == null || str2.equals("-1"))) {
            requestParams.put("season", str2);
        }
        C3094j.m16698a("getEpisodes", this.f11833e + " ; id=" + str + "; season = " + str2);
        f11823C.get(this.f11833e, requestParams, asyncHttpResponseHandler);
    }

    /* renamed from: b */
    public void m16340b(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("id", str);
        requestParams.put(IjkMediaMeta.IJKM_KEY_TYPE, str2);
        f11823C.get(this.f11839k, requestParams, asyncHttpResponseHandler);
    }

    /* renamed from: a */
    public void m16330a(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        f11823C.get("http://sbfunservice.cc/init/alerts_android.json?q=" + new Random().nextInt(), asyncHttpResponseHandler);
    }

    /* renamed from: a */
    public void m16332a(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        C3094j.m16698a("getMovieDetails", this.f11826A + str);
        C3087e.m16674a("MovieDetailsFragment", "getMovieDetails request", this.f11826A + str);
        f11823C.get(this.f11826A + str, asyncHttpResponseHandler);
    }

    /* renamed from: a */
    public BaseResponse m16325a(Activity activity, String str, int i) {
        if (i == 2) {
            return new C2995b(this, activity, str, null).m16317a();
        }
        if (i == 4) {
            return new C2996c(str).m16318a();
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponse("");
        return baseResponse;
    }

    /* renamed from: c */
    public String m16343c(String str) {
        try {
            return m16324g(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: g */
    private String m16324g(String str) throws Exception {
        URLConnection uRLConnection;
        InputStream inputStream;
        URL url = new URL(str);
        if (str.startsWith("https") || str.startsWith("HTTPS")) {
            uRLConnection = (HttpsURLConnection) url.openConnection();
        } else {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        uRLConnection.setRequestProperty("User-Agent", "Show Box");
        uRLConnection.setConnectTimeout(15000);
        uRLConnection.setReadTimeout(15000);
        String headerField = uRLConnection.getHeaderField("Content-Encoding");
        if (headerField == null || !headerField.contains("gzip")) {
            inputStream = uRLConnection.getInputStream();
        } else {
            inputStream = (GZIPInputStream) uRLConnection.getInputStream();
        }
        return C3176e.m16967a(inputStream);
    }

    /* renamed from: a */
    public static String m16322a(URLConnection uRLConnection) {
        int i = 1;
        while (true) {
            String headerFieldKey = uRLConnection.getHeaderFieldKey(i);
            if (headerFieldKey == null) {
                return "";
            }
            if (headerFieldKey.equals("Set-Cookie")) {
                break;
            }
            i++;
        }
        String headerField = uRLConnection.getHeaderField(i);
        if (headerField == null) {
            return "";
        }
        return headerField;
    }

    /* renamed from: d */
    public String m16346d(String str) {
        String str2 = null;
        try {
            SyncHttpClient c29892 = new C29892(this);
            c29892.setUserAgent(null);
            str2 = c29892.get(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    /* renamed from: e */
    public String m16349e(String str) {
        try {
            URLConnection uRLConnection;
            URL url = new URL(str);
            if (str.startsWith("https") || str.startsWith("HTTPS")) {
                uRLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) uRLConnection).setInstanceFollowRedirects(true);
            } else {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setInstanceFollowRedirects(true);
            }
            uRLConnection.setConnectTimeout(5000);
            uRLConnection.setReadTimeout(5000);
            InputStream inputStream = (InputStream) uRLConnection.getContent();
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[4096];
            for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
                stringBuffer.append(new String(bArr, 0, read));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m16321a(String str, String str2, String str3) {
        try {
            URLConnection uRLConnection;
            URLConnection uRLConnection2;
            InputStream inputStream;
            C3094j.m16698a("showbox", "torrent: " + str);
            URL url = new URL(str);
            if (str.startsWith("https") || str.startsWith("HTTPS")) {
                uRLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                uRLConnection2 = uRLConnection;
            } else {
                uRLConnection = (HttpURLConnection) url.openConnection();
                ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                uRLConnection2 = uRLConnection;
            }
            uRLConnection2.setRequestProperty("Referer", str);
            uRLConnection2.connect();
            InputStream inputStream2 = uRLConnection2.getInputStream();
            String headerField = uRLConnection2.getHeaderField("Location");
            if (headerField != null) {
                url = new URL(headerField);
                if (headerField.startsWith("https") || headerField.startsWith("HTTPS")) {
                    uRLConnection = (HttpsURLConnection) url.openConnection();
                    ((HttpsURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                } else {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setInstanceFollowRedirects(true);
                }
                uRLConnection.setRequestProperty("Referer", str);
                uRLConnection.connect();
                inputStream = uRLConnection.getInputStream();
            } else {
                inputStream = inputStream2;
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
                file.mkdirs();
            }
            String str4 = str2 + "/" + str3;
            FileOutputStream fileOutputStream = new FileOutputStream(str4);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    fileOutputStream.close();
                    return str4;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public void m16345c(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        f11823C.get(this.f11840m + "id=" + str + "&type=" + str2, asyncHttpResponseHandler);
    }

    /* renamed from: d */
    public void m16348d(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str3 = this.f11841n + "type=" + str + "&last=" + str2;
        C3094j.m16698a("api", "getNews: url: " + str3);
        f11823C.get(str3, asyncHttpResponseHandler);
    }

    /* renamed from: f */
    public String m16351f(String str) {
        return this.f11842o + str;
    }

    /* renamed from: b */
    public void m16339b(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str2 = this.f11843p + str;
        C3094j.m16698a("api", "getTrailers url: " + str2);
        f11823C.get(str2, asyncHttpResponseHandler);
    }

    /* renamed from: c */
    public void m16344c(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str2 = this.f11844q + str;
        C3094j.m16698a("api", "getTrailer detail: url: " + str2);
        f11823C.get(str2, asyncHttpResponseHandler);
    }

    /* renamed from: a */
    public void m16329a(C2606a c2606a, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        int intValue;
        C3016f.m16400c();
        String b = c2606a.m15027b();
        if (c2606a.m15030c() != null) {
            intValue = Integer.valueOf(c2606a.m15030c().getCatId()).intValue();
        } else {
            intValue = -1;
        }
        String str = this.f11849v;
        RequestParams requestParams = new RequestParams();
        if (c2606a.m15027b() != null) {
            requestParams.put("query", b);
        }
        if (c2606a.m15023a() != null) {
            requestParams.put("sort", c2606a.m15023a());
        }
        if (intValue != -1) {
            requestParams.put("cat", "" + intValue);
        }
        if (c2606a.m15031d() != -1) {
            requestParams.put("year", "" + c2606a.m15031d());
        }
        C3094j.m16698a("api", "getMovieList url: " + str);
        f11823C.getCachedRequest(str, requestParams, asyncHttpResponseHandler, 86400000);
    }

    /* renamed from: b */
    public void m16337b(C2606a c2606a, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        int intValue;
        C3016f.m16400c();
        String b = c2606a.m15027b();
        if (c2606a.m15030c() != null) {
            intValue = Integer.valueOf(c2606a.m15030c().getCatId()).intValue();
        } else {
            intValue = -1;
        }
        String str = this.f11848u;
        RequestParams requestParams = new RequestParams();
        if (c2606a.m15027b() != null) {
            requestParams.put("query", b);
        }
        if (c2606a.m15023a() != null) {
            requestParams.put("sort", c2606a.m15023a());
        }
        if (intValue != -1) {
            requestParams.put("cat", "" + intValue);
        }
        C3094j.m16698a("api", "getShowsList url: " + str);
        f11823C.getCachedRequest(str, requestParams, asyncHttpResponseHandler, 86400000);
    }

    /* renamed from: d */
    public void m16347d(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        C3016f.m16397a();
        RequestParams requestParams = new RequestParams();
        String str2 = this.f11850w;
        if (str != null || str.length() > 0) {
            try {
                str = URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
            }
            requestParams.put("time", str);
        }
        C3094j.m16698a("api", "getUpdates url: " + str2);
        f11823C.getCachedRequest(str2, requestParams, asyncHttpResponseHandler, 1800000);
    }

    /* renamed from: a */
    public void m16327a(final int i, final AsyncHttpResponseHandler asyncHttpResponseHandler) {
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2999a f11811c;

            public void run() {
                String str = "http://sbfunservice.cc/init/init_android.json";
                if (i == 1) {
                    str = "http://sbfunservice-mirror.cc/init/init_android.json";
                }
                C3094j.m16698a("getAppConf URL: ", str);
                str = this.f11811c.m16343c(str);
                Handler handler = new Handler(Looper.getMainLooper());
                if (handler != null) {
                    handler.post(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C29913 f11808b;

                        public void run() {
                            if (asyncHttpResponseHandler != null) {
                                asyncHttpResponseHandler.onSuccess(0, str);
                            }
                        }
                    });
                }
            }
        }).start();
    }

    /* renamed from: a */
    public void m16335a(String str, String str2, String str3, String str4, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("t", str2);
        requestParams.put("v", str);
        requestParams.put("d", str3);
        requestParams.put("sign", str4);
        f11823C.post(this.f11852y, requestParams, asyncHttpResponseHandler);
    }

    /* renamed from: e */
    public void m16350e(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(IjkMediaMeta.IJKM_KEY_TYPE, str2);
        requestParams.put("v", str);
        C3094j.m16698a("version", this.f11832d + " ; type=" + str2 + "; v = " + str);
        f11823C.get(this.f11832d, requestParams, asyncHttpResponseHandler);
    }

    /* renamed from: b */
    public void m16338b(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        C3016f.m16399b();
        RequestParams requestParams = new RequestParams();
        String str = this.f11851x;
        C3094j.m16698a("api", "getTrending url: " + str);
        f11823C.getCachedRequest(str, requestParams, asyncHttpResponseHandler, 3600000);
    }

    /* renamed from: b */
    public void m16341b(String str, String str2, String str3, String str4, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("deviceid", str);
        requestParams.put("geo", str2);
        requestParams.put(IAWLMediationDefs.KEY_GENDER, str3);
        requestParams.put(IjkMediaMeta.IJKM_KEY_TYPE, str4);
        C3094j.m16698a("getAd", str + " ; geo=" + str2 + "; g = " + str3 + "; type = " + str4);
        f11823C.get(this.f11853z, requestParams, asyncHttpResponseHandler);
    }
}
