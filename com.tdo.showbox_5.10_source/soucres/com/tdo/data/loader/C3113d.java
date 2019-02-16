package com.tdo.showbox.data.loader;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.activeandroid.query.Select;
import com.frostwire.jlibtorrent.Downloader;
import com.frostwire.jlibtorrent.Session;
import com.frostwire.jlibtorrent.TorrentAlertAdapter;
import com.frostwire.jlibtorrent.TorrentHandle;
import com.frostwire.jlibtorrent.TorrentInfo;
import com.frostwire.jlibtorrent.alerts.ReadPieceAlert;
import com.frostwire.jlibtorrent.alerts.StatsAlert;
import com.frostwire.jlibtorrent.alerts.TorrentFinishedAlert;
import com.tdo.showbox.App;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.loader.DownloaderService.C3108a;
import com.tdo.showbox.data.loader.p128a.C3109a;
import com.tdo.showbox.data.loader.p128a.C3110b;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.p131f.C3178f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

/* compiled from: LoadMovieThread */
/* renamed from: com.tdo.showbox.data.loader.d */
public class C3113d extends Thread {
    /* renamed from: a */
    private volatile boolean f12155a = true;
    /* renamed from: b */
    private C3106b f12156b;
    /* renamed from: c */
    private C3108a f12157c;
    /* renamed from: d */
    private volatile boolean f12158d = false;
    /* renamed from: e */
    private Context f12159e;
    /* renamed from: f */
    private C2755a f12160f;
    /* renamed from: g */
    private boolean f12161g = false;
    /* renamed from: h */
    private boolean f12162h = false;
    /* renamed from: i */
    private String f12163i;

    public C3113d(Context context, C2755a c2755a) {
        this.f12159e = context;
        this.f12160f = c2755a;
        start();
        this.f12163i = context.getString(R.string.part_pattern);
    }

    /* renamed from: a */
    public void m16780a(C3108a c3108a) {
        this.f12155a = false;
        this.f12158d = false;
        this.f12161g = false;
        this.f12157c = c3108a;
    }

    /* renamed from: a */
    public void m16781a(C3106b c3106b) {
        this.f12156b = c3106b;
    }

    /* renamed from: a */
    public C3108a m16778a() {
        return this.f12157c;
    }

    /* renamed from: b */
    public void m16783b() {
        this.f12158d = true;
    }

    /* renamed from: c */
    public void m16784c() {
        this.f12158d = true;
        this.f12161g = true;
    }

    public void run() {
        super.run();
        while (true) {
            if (this.f12155a) {
                try {
                    C3113d.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.f12162h = false;
                m16767d();
                this.f12155a = true;
                this.f12156b.mo2132a();
            }
        }
    }

    /* renamed from: d */
    private void m16767d() {
        if (this.f12157c.f12136b.getVideo_source() != 7) {
            m16770d(this.f12157c.f12136b);
            return;
        }
        try {
            if (this.f12157c.f12136b.getLink().startsWith("http") || this.f12157c.f12136b.getLink() == null || this.f12157c.f12136b.getLink().length() <= 1) {
                m16762b(this.f12157c.f12136b);
            } else {
                m16765c(this.f12157c.f12136b);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            this.f12157c.f12136b.save();
            m16776i(this.f12157c.f12136b);
            e.printStackTrace();
            C3109a.m16753a("some very big error in file load", e, C3110b.dowloader_sevice);
        }
    }

    /* renamed from: b */
    private void m16762b(DownloadEpisode downloadEpisode) throws IOException, InterruptedException {
        downloadEpisode.setLink(C2999a.m16321a(downloadEpisode.getStatic_link(), this.f12159e.getApplicationInfo().dataDir + "/torrent_file", downloadEpisode.getTitle().replace(" ", "-").replace("/", "-") + ".torrent"));
        downloadEpisode.save();
        m16765c(downloadEpisode);
    }

    /* renamed from: c */
    private void m16765c(DownloadEpisode downloadEpisode) throws IOException, InterruptedException {
        File file;
        TorrentHandle addTorrent;
        int i = 0;
        final Session a = App.m15016a();
        String link = this.f12157c.f12136b.getLink();
        if (link.startsWith("magnet")) {
            Object fetchMagnet;
            Downloader downloader = new Downloader(a);
            downloadEpisode.setStatus(4);
            downloadEpisode.save();
            m16775h(downloadEpisode);
            C3094j.m16698a("LoadMovieThread", "fetchMagnet start");
            try {
                fetchMagnet = downloader.fetchMagnet(link, 30000);
            } catch (UnknownError e) {
                fetchMagnet = null;
            }
            if (fetchMagnet == null) {
                C3094j.m16698a("LoadMovieThread", "fetchMagnet start 2");
                try {
                    fetchMagnet = downloader.fetchMagnet(link, 30000);
                    C3094j.m16698a("LoadMovieThread", "fetchMagnet end 2 : " + fetchMagnet);
                } catch (UnknownError e2) {
                    downloadEpisode.setStatus(5);
                    downloadEpisode.save();
                    return;
                }
            }
            C3094j.m16698a("LoadMovieThread", "fetchMagnet end: " + fetchMagnet);
            if (fetchMagnet != null) {
                try {
                    int i2 = 1;
                    TorrentInfo bdecode = TorrentInfo.bdecode(fetchMagnet);
                } catch (Exception e3) {
                    downloadEpisode.setStatus(5);
                    downloadEpisode.save();
                    return;
                }
            }
            downloadEpisode.setStatus(5);
            downloadEpisode.save();
            return;
        }
        i2 = 0;
        bdecode = null;
        if (bdecode == null) {
            file = new File(this.f12157c.f12136b.getLink());
            try {
                if (new TorrentInfo(file).isValid()) {
                    File file2 = file;
                } else {
                    throw new Exception();
                }
            } catch (Exception e4) {
                downloadEpisode.setStatus(5);
                downloadEpisode.save();
                return;
            } catch (Throwable th) {
                downloadEpisode.setStatus(5);
                downloadEpisode.save();
                th.printStackTrace();
                return;
            }
        }
        file2 = null;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "show_box");
        } catch (Exception e5) {
            file = this.f12159e.getExternalFilesDir(null);
        }
        if (!file.exists()) {
            file.mkdirs();
            file.mkdir();
        }
        if (bdecode == null) {
            addTorrent = a.addTorrent(file2, file.getAbsoluteFile());
        } else {
            addTorrent = a.addTorrent(bdecode, file.getAbsoluteFile(), null, null);
        }
        String filePath = addTorrent.getTorrentInfo().getFiles().getFilePath(0);
        long j = 0;
        while (i < addTorrent.getTorrentInfo().getNumFiles()) {
            long fileSize = addTorrent.getTorrentInfo().getFiles().getFileSize(i);
            if (fileSize >= j) {
                filePath = addTorrent.getTorrentInfo().getFiles().getFilePath(i);
                j = fileSize;
            }
            i++;
        }
        downloadEpisode.setFull_path(file.getAbsolutePath() + "/" + filePath);
        downloadEpisode.save();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final DownloadEpisode downloadEpisode2 = downloadEpisode;
        a.addListener(new TorrentAlertAdapter(this, addTorrent) {
            /* renamed from: d */
            final /* synthetic */ C3113d f12154d;

            public void readPiece(ReadPieceAlert readPieceAlert) {
                super.readPiece(readPieceAlert);
            }

            public void stats(StatsAlert statsAlert) {
                int i = 0;
                long j = 0;
                super.stats(statsAlert);
                if (this.f12154d.f12161g) {
                    downloadEpisode2.setProgress(0);
                    downloadEpisode2.setPercent(0);
                    downloadEpisode2.setDeleted(1);
                    downloadEpisode2.save();
                    DownloaderService.m16736g(downloadEpisode2);
                    this.th.pause();
                    a.removeTorrent(this.th);
                    countDownLatch.countDown();
                    return;
                }
                float f;
                long j2 = 0;
                for (long j3 : this.th.getFileProgress()) {
                    j2 += j3;
                }
                downloadEpisode2.setProgress(j2);
                if (j2 == 0) {
                    f = 0.0f;
                } else {
                    f = (((float) j2) / ((float) downloadEpisode2.getFile_size())) * 100.0f;
                }
                downloadEpisode2.setPercent((int) f);
                if (this.f12154d.f12158d) {
                    downloadEpisode2.save();
                    if (this.f12154d.f12161g) {
                        downloadEpisode2.setDeleted(1);
                        downloadEpisode2.save();
                    } else {
                        this.f12154d.m16776i(downloadEpisode2);
                    }
                    this.th.pause();
                    a.removeTorrent(this.th);
                    countDownLatch.countDown();
                    return;
                }
                if (downloadEpisode2.getFile_size() <= 0) {
                    while (i < this.th.getTorrentInfo().getOrigFiles().getNumFiles()) {
                        j += this.th.getTorrentInfo().getOrigFiles().getFileSize(i);
                        i++;
                    }
                    downloadEpisode2.setFile_size(j);
                }
                if (j2 > 100) {
                    if (!this.f12154d.f12162h) {
                        downloadEpisode2.setStatus(2);
                        downloadEpisode2.save();
                        this.f12154d.m16777j(downloadEpisode2);
                    }
                    this.f12154d.m16774g(downloadEpisode2);
                    downloadEpisode2.save();
                }
            }

            public void torrentFinished(TorrentFinishedAlert torrentFinishedAlert) {
                super.torrentFinished(torrentFinishedAlert);
                downloadEpisode2.setIs_downloading(0);
                downloadEpisode2.setStatus(3);
                downloadEpisode2.setPercent(100);
                downloadEpisode2.setProgress(downloadEpisode2.getFile_size());
                downloadEpisode2.save();
                this.f12154d.m16773f(downloadEpisode2);
                this.f12154d.m16771e();
                this.th.pause();
                a.removeTorrent(this.th);
                countDownLatch.countDown();
            }
        });
        addTorrent.resume();
        if (i2 == 0) {
            downloadEpisode.setStatus(4);
            downloadEpisode.save();
            m16775h(downloadEpisode);
        }
        countDownLatch.await();
    }

    /* renamed from: e */
    private void m16771e() {
        if (DownloaderService.f12138a) {
            for (DownloadEpisode downloadEpisode : new Select().from(DownloadEpisode.class).where("percent!=100").execute()) {
                if (downloadEpisode.getStatus() != 1) {
                    if (downloadEpisode.getStatus() == 0) {
                    }
                }
                C3109a.m16754a("send task to service", C3110b.dowloader_sevice);
                Intent intent = new Intent(this.f12159e, DownloaderService.class);
                intent.putExtra("ACTION_ID", 23);
                intent.putExtra("ARG_DOWNLOAD_ITEM", downloadEpisode);
                this.f12159e.startService(intent);
                return;
            }
        }
    }

    /* renamed from: d */
    private void m16770d(DownloadEpisode downloadEpisode) {
        C3109a.m16754a("start download epizode", C3110b.dowloader_sevice);
        try {
            m16772e(downloadEpisode);
            File a = m16779a(downloadEpisode);
            long length = a.length();
            InputStream a2 = m16758a(downloadEpisode, length);
            long file_size = downloadEpisode.getFile_size() - length;
            if (length > 0) {
                m16777j(downloadEpisode);
            } else {
                m16775h(downloadEpisode);
            }
            downloadEpisode.setStatus(2);
            downloadEpisode.save();
            boolean a3 = m16782a(downloadEpisode, a2, a, length);
            downloadEpisode.setIs_downloading(0);
            downloadEpisode.setStatus(3);
            downloadEpisode.save();
            if (this.f12161g) {
                downloadEpisode.setProgress(0);
                downloadEpisode.setPercent(0);
                downloadEpisode.setDeleted(1);
                downloadEpisode.save();
                DownloaderService.m16736g(downloadEpisode);
            } else if (!a3) {
                m16774g(downloadEpisode);
                if (downloadEpisode.getFile_size() == downloadEpisode.getProgress()) {
                    DownloaderService.m16718a(this.f12159e, downloadEpisode).save();
                }
                m16773f(downloadEpisode);
                m16771e();
            }
        } catch (Throwable e) {
            downloadEpisode.save();
            m16776i(downloadEpisode);
            e.printStackTrace();
            C3109a.m16753a("some very big error in file load", e, C3110b.dowloader_sevice);
            if (!C3178f.m16973b(this.f12159e)) {
                downloadEpisode.save();
                m16776i(downloadEpisode);
            }
        }
    }

    /* renamed from: a */
    private InputStream m16758a(DownloadEpisode downloadEpisode, long j) throws IOException {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(downloadEpisode.getLink()).openConnection();
            InputStream bufferedInputStream;
            try {
                long contentLength;
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
                String cookies = downloadEpisode.getCookies();
                if (cookies != null && cookies.length() > 0) {
                    httpURLConnection.setRequestProperty("Cookie", downloadEpisode.getCookies());
                }
                httpURLConnection.setDoInput(true);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                if (httpURLConnection != null) {
                    contentLength = (long) httpURLConnection.getContentLength();
                } else {
                    contentLength = 0;
                }
                if (contentLength <= 0) {
                    downloadEpisode.setFile_size(1);
                } else {
                    downloadEpisode.setFile_size(contentLength + j);
                }
                downloadEpisode.save();
                return bufferedInputStream;
            } catch (Exception e) {
                try {
                    throw new Exception();
                } catch (Exception e2) {
                    if (App.m15019b() != null) {
                        MainActivity.m15127b(true);
                    }
                    bufferedInputStream = null;
                }
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            throw new Exception();
        }
    }

    /* renamed from: e */
    private void m16772e(DownloadEpisode downloadEpisode) {
        downloadEpisode.setIs_downloading(1);
        downloadEpisode.save();
    }

    /* renamed from: a */
    public File m16779a(DownloadEpisode downloadEpisode) throws IOException {
        if (downloadEpisode.getFull_path().equals("")) {
            downloadEpisode.setFull_path(DownloaderService.m16720a(this.f12159e, downloadEpisode, true));
            downloadEpisode.save();
        }
        File file = new File(downloadEpisode.getFull_path());
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /* renamed from: a */
    public boolean m16782a(DownloadEpisode downloadEpisode, InputStream inputStream, File file, long j) throws IOException {
        int percent = downloadEpisode.getPercent();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true), 8192);
        byte[] bArr = new byte[8192];
        long file_size = downloadEpisode.getFile_size() - j;
        if (downloadEpisode.getFile_size() <= 0) {
            file_size = -1;
        }
        int i = 0;
        while (!this.f12158d) {
            percent = inputStream.read(bArr, 0, 8192);
            if (percent < 0) {
                downloadEpisode.setPercent(100);
                downloadEpisode.setProgress(file_size);
                bufferedOutputStream.close();
                C3109a.m16754a("file was dowloaded, episod id = " + downloadEpisode.getEpisode_id(), C3110b.dowloader_sevice);
                return false;
            }
            bufferedOutputStream.write(bArr, 0, percent);
            j += (long) percent;
            downloadEpisode.setProgress(j);
            percent = (int) ((((double) j) / ((double) downloadEpisode.getFile_size())) * 100.0d);
            downloadEpisode.setPercent(percent);
            i++;
            if (i >= 10) {
                downloadEpisode.save();
                m16774g(downloadEpisode);
                i = 0;
            }
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        downloadEpisode.setProgress(j);
        downloadEpisode.setPercent(percent);
        downloadEpisode.save();
        if (this.f12161g) {
            downloadEpisode.setDeleted(1);
            downloadEpisode.save();
        } else {
            m16776i(downloadEpisode);
        }
        return true;
    }

    /* renamed from: f */
    private void m16773f(DownloadEpisode downloadEpisode) {
        this.f12162h = false;
        if (downloadEpisode.getAuto() == 1) {
            C3065b.m16568a("auto_torrent_tv_downloaded");
        }
        this.f12160f.mo2042d(downloadEpisode);
    }

    /* renamed from: g */
    private void m16774g(DownloadEpisode downloadEpisode) {
        this.f12162h = true;
        this.f12160f.mo2038a(downloadEpisode);
    }

    /* renamed from: h */
    private void m16775h(DownloadEpisode downloadEpisode) {
        this.f12160f.mo2043e(downloadEpisode);
    }

    /* renamed from: i */
    private void m16776i(DownloadEpisode downloadEpisode) {
        this.f12162h = false;
        this.f12160f.mo2039b(downloadEpisode);
    }

    /* renamed from: j */
    private void m16777j(DownloadEpisode downloadEpisode) {
        this.f12162h = true;
        this.f12160f.mo2041c(downloadEpisode);
    }
}
