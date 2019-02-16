package com.tdo.showbox.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import com.tdo.showbox.R;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.torrent.stream.StreamStatus;
import com.tdo.showbox.data.torrent.stream.Torrent;
import com.tdo.showbox.data.torrent.stream.TorrentOptions.Builder;
import com.tdo.showbox.data.torrent.stream.TorrentStream;
import com.tdo.showbox.data.torrent.stream.listeners.TorrentListener;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.SubtitleIjkVideoView;
import java.io.File;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

public class TorrentStreamActivity extends Activity implements TorrentListener {
    /* renamed from: a */
    private SubtitleIjkVideoView f10799a;
    /* renamed from: b */
    private String f10800b;
    /* renamed from: c */
    private TorrentStream f10801c;
    /* renamed from: d */
    private String f10802d;
    /* renamed from: e */
    private ProgressDialog f10803e;

    /* renamed from: com.tdo.showbox.activities.TorrentStreamActivity$1 */
    class C26371 implements OnCancelListener {
        /* renamed from: a */
        final /* synthetic */ TorrentStreamActivity f10791a;

        C26371(TorrentStreamActivity torrentStreamActivity) {
            this.f10791a = torrentStreamActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f10791a.finish();
        }
    }

    /* renamed from: com.tdo.showbox.activities.TorrentStreamActivity$3 */
    class C26403 implements OnErrorListener {
        /* renamed from: a */
        final /* synthetic */ TorrentStreamActivity f10795a;

        C26403(TorrentStreamActivity torrentStreamActivity) {
            this.f10795a = torrentStreamActivity;
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            return false;
        }
    }

    /* renamed from: com.tdo.showbox.activities.TorrentStreamActivity$4 */
    class C26414 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ TorrentStreamActivity f10796a;

        C26414(TorrentStreamActivity torrentStreamActivity) {
            this.f10796a = torrentStreamActivity;
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            this.f10796a.finish();
        }
    }

    /* renamed from: com.tdo.showbox.activities.TorrentStreamActivity$5 */
    class C26425 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ TorrentStreamActivity f10797a;

        C26425(TorrentStreamActivity torrentStreamActivity) {
            this.f10797a = torrentStreamActivity;
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
        }
    }

    /* renamed from: com.tdo.showbox.activities.TorrentStreamActivity$6 */
    class C26436 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ TorrentStreamActivity f10798a;

        C26436(TorrentStreamActivity torrentStreamActivity) {
            this.f10798a = torrentStreamActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10798a.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_torrent_stream);
        this.f10799a = (SubtitleIjkVideoView) findViewById(R.id.video_view);
        this.f10799a.setmActivity(this);
        this.f10800b = getIntent().getStringExtra("uri");
        m15189a(this.f10800b);
    }

    /* renamed from: a */
    private void m15189a(final String str) {
        this.f10803e = new ProgressDialog(this);
        this.f10803e.setMessage("Preparing...");
        this.f10803e.setProgressStyle(1);
        this.f10803e.setIndeterminate(false);
        this.f10803e.setCanceledOnTouchOutside(false);
        this.f10803e.setOnCancelListener(new C26371(this));
        this.f10803e.setMax(100);
        this.f10803e.setProgress(0);
        this.f10803e.show();
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ TorrentStreamActivity f10794b;

            /* renamed from: com.tdo.showbox.activities.TorrentStreamActivity$2$1 */
            class C26381 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C26392 f10792a;

                C26381(C26392 c26392) {
                    this.f10792a = c26392;
                }

                public void run() {
                    if (this.f10792a.f10794b.f10803e != null) {
                        this.f10792a.f10794b.f10803e.setCancelable(true);
                    }
                    this.f10792a.f10794b.m15193c();
                }
            }

            public void run() {
                this.f10794b.f10800b = Uri.fromFile(new File(C2999a.m16321a(str, this.f10794b.m15191b(), "" + System.currentTimeMillis() + ".torrent"))).toString();
                this.f10794b.runOnUiThread(new C26381(this));
            }
        }).start();
    }

    /* renamed from: b */
    private String m15191b() {
        File file = new File(getExternalFilesDir(null), "tor");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    private void m15193c() {
        this.f10801c = TorrentStream.init(new Builder().saveLocation(m15191b()).removeFilesAfterStop(Boolean.valueOf(true)).build());
        this.f10801c.addListener(this);
        this.f10801c.startStream(this.f10800b, null);
    }

    /* renamed from: d */
    private void m15195d() {
        if (this.f10801c.isStreaming()) {
            this.f10801c.stopStream();
        }
        try {
            new File(this.f10802d).delete();
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private void m15192b(String str) {
        if (str != null) {
            try {
                this.f10799a.requestFocus();
                this.f10799a.setVisibility(0);
                this.f10799a.setMediaController(new MediaController(this));
                this.f10802d = new File(str).getAbsolutePath();
                this.f10799a.setVideoURI(Uri.fromFile(new File(str)));
                this.f10799a.setOnErrorListener(new C26403(this));
                this.f10799a.setOnCompletionListener(new C26414(this));
                this.f10799a.setOnPreparedListener(new C26425(this));
                this.f10799a.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void onDestroy() {
        m15195d();
        this.f10799a.setmActivity(null);
        m15196a();
        super.onDestroy();
    }

    /* renamed from: a */
    public void m15196a() {
        this.f10799a.m17303a();
        C3184j.m16984a(this.f10799a);
        this.f10799a = null;
    }

    public void onStreamPrepared(Torrent torrent) {
        torrent.startDownload();
    }

    public void onStreamStarted(Torrent torrent) {
    }

    public void onStreamError(Torrent torrent, Exception exception) {
        if (this.f10803e != null) {
            this.f10803e.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Can't open torrent file");
        builder.setPositiveButton("Cancel", new C26436(this));
        builder.setCancelable(false);
        builder.show();
    }

    public void onStreamReady(Torrent torrent) {
        if (this.f10803e != null) {
            this.f10803e.dismiss();
        }
        m15192b(torrent.getVideoFile().getAbsolutePath());
    }

    public void onStreamProgress(Torrent torrent, StreamStatus streamStatus) {
        if (this.f10803e != null && streamStatus.bufferProgress <= 100 && this.f10803e.getProgress() < 100 && this.f10803e.getProgress() != streamStatus.bufferProgress) {
            this.f10803e.setProgress(streamStatus.bufferProgress);
        }
    }

    public void onStreamStopped() {
    }
}
