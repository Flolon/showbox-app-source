package com.tdo.showbox.data.torrent.stream;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.activeandroid.Cache;
import com.frostwire.jlibtorrent.DHT;
import com.frostwire.jlibtorrent.Downloader;
import com.frostwire.jlibtorrent.Priority;
import com.frostwire.jlibtorrent.Session;
import com.frostwire.jlibtorrent.SettingsPack;
import com.frostwire.jlibtorrent.TorrentInfo;
import com.frostwire.jlibtorrent.alerts.TorrentAddedAlert;
import com.frostwire.jlibtorrent.swig.settings_pack.int_types;
import com.frostwire.jlibtorrent.swig.settings_pack.string_types;
import com.tdo.showbox.data.torrent.stream.exceptions.DirectoryModifyException;
import com.tdo.showbox.data.torrent.stream.exceptions.NotInitializedException;
import com.tdo.showbox.data.torrent.stream.exceptions.TorrentInfoException;
import com.tdo.showbox.data.torrent.stream.listeners.DHTStatsAlertListener;
import com.tdo.showbox.data.torrent.stream.listeners.TorrentAddedAlertListener;
import com.tdo.showbox.data.torrent.stream.listeners.TorrentListener;
import com.tdo.showbox.data.torrent.stream.utils.FileUtils;
import com.tdo.showbox.data.torrent.stream.utils.ThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TorrentStream {
    private static final String LIBTORRENT_THREAD_NAME = "TORRENTSTREAM_LIBTORRENT";
    private static final String STREAMING_THREAD_NAME = "TORRENTSTREAMER_STREAMING";
    private static TorrentStream sThis;
    private Torrent currentTorrent;
    private String currentTorrentUrl;
    private DHT dht;
    private Integer dhtNodes = Integer.valueOf(0);
    private final DHTStatsAlertListener dhtStatsAlertListener = new C31441();
    private Boolean initialised = Boolean.valueOf(false);
    private Boolean initialising = Boolean.valueOf(false);
    private CountDownLatch initialisingLatch;
    private Boolean isCanceled = Boolean.valueOf(false);
    private Boolean isStreaming = Boolean.valueOf(false);
    private Handler libTorrentHandler;
    private HandlerThread libTorrentThread;
    private final List<TorrentListener> listeners = new ArrayList();
    private Handler streamingHandler;
    private HandlerThread streamingThread;
    private final TorrentAddedAlertListener torrentAddedAlertListener = new C31452();
    private TorrentOptions torrentOptions;
    private Session torrentSession;

    /* renamed from: com.tdo.showbox.data.torrent.stream.TorrentStream$1 */
    class C31441 extends DHTStatsAlertListener {
        C31441() {
        }

        public void stats(int i) {
            TorrentStream.this.dhtNodes = Integer.valueOf(i);
        }
    }

    /* renamed from: com.tdo.showbox.data.torrent.stream.TorrentStream$2 */
    class C31452 extends TorrentAddedAlertListener {
        C31452() {
        }

        public void torrentAdded(TorrentAddedAlert torrentAddedAlert) {
            TorrentListener internalTorrentListener = new InternalTorrentListener();
            TorrentStream.this.currentTorrent = new Torrent(TorrentStream.this.torrentSession.findTorrent(torrentAddedAlert.getHandle().getInfoHash()), internalTorrentListener, TorrentStream.this.torrentOptions.prepareSize);
            TorrentStream.this.torrentSession.addListener(TorrentStream.this.currentTorrent);
        }
    }

    /* renamed from: com.tdo.showbox.data.torrent.stream.TorrentStream$3 */
    class C31463 implements Runnable {
        C31463() {
        }

        public void run() {
            TorrentStream.this.torrentSession = new Session();
            TorrentStream.this.setOptions(TorrentStream.this.torrentOptions);
            TorrentStream.this.torrentSession.addListener(TorrentStream.this.dhtStatsAlertListener);
            TorrentStream.this.dht = new DHT(TorrentStream.this.torrentSession);
            TorrentStream.this.dht.start();
            TorrentStream.this.initialising = Boolean.valueOf(false);
            TorrentStream.this.initialised = Boolean.valueOf(true);
            TorrentStream.this.initialisingLatch.countDown();
        }
    }

    /* renamed from: com.tdo.showbox.data.torrent.stream.TorrentStream$4 */
    class C31474 implements Runnable {
        C31474() {
        }

        public void run() {
            TorrentStream.this.torrentSession.resume();
        }
    }

    /* renamed from: com.tdo.showbox.data.torrent.stream.TorrentStream$5 */
    class C31485 implements Runnable {
        C31485() {
        }

        public void run() {
            TorrentStream.this.dht.start();
        }
    }

    /* renamed from: com.tdo.showbox.data.torrent.stream.TorrentStream$6 */
    class C31496 implements Runnable {
        C31496() {
        }

        public void run() {
            TorrentStream.this.torrentSession.pause();
        }
    }

    protected class InternalTorrentListener implements TorrentListener {
        protected InternalTorrentListener() {
        }

        public void onStreamStarted(final Torrent torrent) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        torrentListener.onStreamStarted(torrent);
                    }
                });
            }
        }

        public void onStreamError(final Torrent torrent, final Exception exception) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        torrentListener.onStreamError(torrent, exception);
                    }
                });
            }
        }

        public void onStreamReady(final Torrent torrent) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        torrentListener.onStreamReady(torrent);
                    }
                });
            }
        }

        public void onStreamProgress(final Torrent torrent, final StreamStatus streamStatus) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        torrentListener.onStreamProgress(torrent, streamStatus);
                    }
                });
            }
        }

        public void onStreamStopped() {
        }

        public void onStreamPrepared(final Torrent torrent) {
            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        torrentListener.onStreamPrepared(torrent);
                    }
                });
            }
        }
    }

    private TorrentStream(TorrentOptions torrentOptions) {
        this.torrentOptions = torrentOptions;
        initialise();
    }

    public static TorrentStream init(TorrentOptions torrentOptions) {
        sThis = new TorrentStream(torrentOptions);
        return sThis;
    }

    public static TorrentStream getInstance() throws NotInitializedException {
        if (sThis != null) {
            return sThis;
        }
        throw new NotInitializedException();
    }

    private void initialise() {
        if (this.libTorrentThread == null || this.torrentSession == null) {
            if ((this.initialising.booleanValue() || this.initialised.booleanValue()) && this.libTorrentThread != null) {
                this.libTorrentThread.interrupt();
            }
            this.initialising = Boolean.valueOf(true);
            this.initialised = Boolean.valueOf(false);
            this.initialisingLatch = new CountDownLatch(1);
            this.libTorrentThread = new HandlerThread(LIBTORRENT_THREAD_NAME);
            this.libTorrentThread.start();
            this.libTorrentHandler = new Handler(this.libTorrentThread.getLooper());
            this.libTorrentHandler.post(new C31463());
            return;
        }
        resumeSession();
    }

    public void resumeSession() {
        if (this.libTorrentThread != null && this.torrentSession != null) {
            this.libTorrentHandler.removeCallbacksAndMessages(null);
            if (this.torrentSession.isPaused()) {
                this.libTorrentHandler.post(new C31474());
            }
            if (this.dht != null && !this.dht.isRunning()) {
                this.libTorrentHandler.post(new C31485());
            }
        }
    }

    public void pauseSession() {
        if (!this.isStreaming.booleanValue()) {
            this.libTorrentHandler.post(new C31496());
        }
    }

    private TorrentInfo getTorrentInfo(String str) throws TorrentInfoException {
        if (str.startsWith("magnet")) {
            byte[] fetchMagnet = new Downloader(this.torrentSession).fetchMagnet(str, 30000);
            if (fetchMagnet != null) {
                try {
                    return TorrentInfo.bdecode(fetchMagnet);
                } catch (IllegalArgumentException e) {
                    throw new TorrentInfoException();
                }
            }
        } else if (str.startsWith("http") || str.startsWith("https")) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                r1 = new byte[0];
                if (httpURLConnection.getResponseCode() == 200) {
                    r1 = getBytesFromInputStream(inputStream);
                }
                inputStream.close();
                httpURLConnection.disconnect();
                if (r1.length > 0) {
                    return TorrentInfo.bdecode(r1);
                }
            } catch (IOException e2) {
                throw new TorrentInfoException();
            } catch (IllegalArgumentException e3) {
                throw new TorrentInfoException();
            }
        } else if (str.startsWith("file")) {
            try {
                InputStream fileInputStream = new FileInputStream(new File(Uri.parse(str).getPath()));
                r1 = getBytesFromInputStream(fileInputStream);
                fileInputStream.close();
                if (r1.length > 0) {
                    return TorrentInfo.bdecode(r1);
                }
            } catch (IOException e4) {
                throw new TorrentInfoException();
            } catch (IllegalArgumentException e5) {
                throw new TorrentInfoException();
            }
        }
        return null;
    }

    private byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Cache.DEFAULT_CACHE_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public void startStream(final String str, final TorrentInfo torrentInfo) {
        if (!(this.initialising.booleanValue() || this.initialised.booleanValue())) {
            initialise();
        }
        if (this.libTorrentHandler != null && !this.isStreaming.booleanValue()) {
            this.isCanceled = Boolean.valueOf(false);
            this.streamingThread = new HandlerThread(STREAMING_THREAD_NAME);
            this.streamingThread.start();
            this.streamingHandler = new Handler(this.streamingThread.getLooper());
            this.streamingHandler.post(new Runnable() {
                public void run() {
                    int i = 0;
                    TorrentStream.this.isStreaming = Boolean.valueOf(true);
                    if (TorrentStream.this.initialisingLatch != null) {
                        try {
                            TorrentStream.this.initialisingLatch.await();
                            TorrentStream.this.initialisingLatch = null;
                        } catch (InterruptedException e) {
                            TorrentStream.this.isStreaming = Boolean.valueOf(false);
                            return;
                        }
                    }
                    TorrentStream.this.currentTorrentUrl = str;
                    File file = new File(TorrentStream.this.torrentOptions.saveLocation);
                    if (file.isDirectory() || file.mkdirs()) {
                        TorrentInfo torrentInfo;
                        TorrentStream.this.torrentSession.removeListener(TorrentStream.this.torrentAddedAlertListener);
                        try {
                            if (torrentInfo != null) {
                                torrentInfo = torrentInfo;
                            } else {
                                torrentInfo = TorrentStream.this.getTorrentInfo(str);
                            }
                        } catch (TorrentInfoException e2) {
                            final TorrentInfoException torrentInfoException = e2;
                            for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                                ThreadUtils.runOnUiThread(new Runnable() {
                                    public void run() {
                                        torrentListener.onStreamError(null, torrentInfoException);
                                    }
                                });
                            }
                            torrentInfo = null;
                        }
                        TorrentStream.this.torrentSession.addListener(TorrentStream.this.torrentAddedAlertListener);
                        if (torrentInfo == null) {
                            for (final TorrentListener torrentListener2 : TorrentStream.this.listeners) {
                                ThreadUtils.runOnUiThread(new Runnable() {
                                    public void run() {
                                        torrentListener2.onStreamError(null, new TorrentInfoException());
                                    }
                                });
                            }
                            TorrentStream.this.isStreaming = Boolean.valueOf(false);
                            return;
                        }
                        Priority[] priorityArr = new Priority[torrentInfo.getNumPieces()];
                        while (i < priorityArr.length) {
                            priorityArr[i] = Priority.IGNORE;
                            i++;
                        }
                        if (TorrentStream.this.currentTorrentUrl.equals(str) && !TorrentStream.this.isCanceled.booleanValue()) {
                            TorrentStream.this.torrentSession.asyncAddTorrent(torrentInfo, file, priorityArr, null);
                            return;
                        }
                        return;
                    }
                    for (final TorrentListener torrentListener22 : TorrentStream.this.listeners) {
                        ThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                torrentListener22.onStreamError(null, new DirectoryModifyException());
                            }
                        });
                    }
                    TorrentStream.this.isStreaming = Boolean.valueOf(false);
                }
            });
        }
    }

    public void stopStream() {
        if (this.libTorrentHandler != null) {
            this.libTorrentHandler.removeCallbacksAndMessages(null);
        }
        if (this.streamingHandler != null) {
            this.streamingHandler.removeCallbacksAndMessages(null);
        }
        this.isCanceled = Boolean.valueOf(true);
        this.isStreaming = Boolean.valueOf(false);
        if (this.currentTorrent != null) {
            final File saveLocation = this.currentTorrent.getSaveLocation();
            this.currentTorrent.pause();
            this.torrentSession.removeListener(this.currentTorrent);
            this.torrentSession.removeTorrent(this.currentTorrent.getTorrentHandle());
            this.currentTorrent = null;
            if (this.torrentOptions.removeFiles.booleanValue()) {
                new Thread(new Runnable() {
                    public void run() {
                        int i = 0;
                        while (!FileUtils.recursiveDelete(saveLocation) && i < 5) {
                            int i2 = i + 1;
                            try {
                                Thread.sleep(1000);
                                i = i2;
                            } catch (InterruptedException e) {
                                for (final TorrentListener torrentListener : TorrentStream.this.listeners) {
                                    ThreadUtils.runOnUiThread(new Runnable() {
                                        public void run() {
                                            torrentListener.onStreamError(TorrentStream.this.currentTorrent, new DirectoryModifyException());
                                        }
                                    });
                                }
                                i = i2;
                            }
                        }
                    }
                }).start();
            }
        }
        if (this.streamingThread != null) {
            this.streamingThread.interrupt();
        }
        for (final TorrentListener torrentListener : this.listeners) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    torrentListener.onStreamStopped();
                }
            });
        }
    }

    public TorrentOptions getOptions() {
        return this.torrentOptions;
    }

    public void setOptions(TorrentOptions torrentOptions) {
        this.torrentOptions = torrentOptions;
        SettingsPack settingsPack = new SettingsPack();
        settingsPack.setAnonymousMode(this.torrentOptions.anonymousMode.booleanValue());
        settingsPack.setConnectionsLimit(this.torrentOptions.maxConnections.intValue());
        settingsPack.setDownloadRateLimit(this.torrentOptions.maxDownloadSpeed.intValue());
        settingsPack.setUploadRateLimit(this.torrentOptions.maxUploadSpeed.intValue());
        settingsPack.setInteger(int_types.active_dht_limit.swigValue(), this.torrentOptions.maxDht.intValue());
        if (this.torrentOptions.listeningPort.intValue() != -1) {
            settingsPack.setString(string_types.listen_interfaces.swigValue(), String.format("%s:%d", new Object[]{"0.0.0.0", this.torrentOptions.listeningPort}));
        }
        if (this.torrentOptions.proxyHost != null) {
            settingsPack.setString(string_types.proxy_hostname.swigValue(), this.torrentOptions.proxyHost);
            if (this.torrentOptions.proxyUsername != null) {
                settingsPack.setString(string_types.proxy_username.swigValue(), this.torrentOptions.proxyUsername);
                if (this.torrentOptions.proxyPassword != null) {
                    settingsPack.setString(string_types.proxy_password.swigValue(), this.torrentOptions.proxyPassword);
                }
            }
        }
        if (this.torrentOptions.peerFingerprint != null) {
            settingsPack.setString(string_types.peer_fingerprint.swigValue(), this.torrentOptions.peerFingerprint);
        }
        this.torrentSession.applySettings(settingsPack);
    }

    public boolean isStreaming() {
        return this.isStreaming.booleanValue();
    }

    public String getCurrentTorrentUrl() {
        return this.currentTorrentUrl;
    }

    public Integer getTotalDhtNodes() {
        return this.dhtNodes;
    }

    public void addListener(TorrentListener torrentListener) {
        if (torrentListener != null) {
            this.listeners.add(torrentListener);
        }
    }

    public void removeListener(TorrentListener torrentListener) {
        if (torrentListener != null) {
            this.listeners.remove(torrentListener);
        }
    }
}
