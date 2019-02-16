package com.tdo.showbox.data.torrent.stream;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.FileStorage;
import com.frostwire.jlibtorrent.Priority;
import com.frostwire.jlibtorrent.TorrentHandle;
import com.frostwire.jlibtorrent.TorrentInfo;
import com.frostwire.jlibtorrent.TorrentStatus;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.BlockFinishedAlert;
import com.frostwire.jlibtorrent.alerts.PieceFinishedAlert;
import com.tdo.showbox.data.torrent.stream.listeners.TorrentListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class Torrent implements AlertListener {
    private static final Integer DEFAULT_PREPARE_COUNT = Integer.valueOf(5);
    private static final Integer MAX_PREPARE_COUNT = Integer.valueOf(20);
    private static final Integer MIN_PREPARE_COUNT = Integer.valueOf(2);
    private Integer firstPieceIndex;
    private Boolean[] hasPieces;
    private Integer lastPieceIndex;
    private final TorrentListener listener;
    private Integer piecesToPrepare;
    private List<Integer> preparePieces;
    private Double prepareProgress = Double.valueOf(0.0d);
    private final Long prepareSize;
    private Double progressStep = Double.valueOf(0.0d);
    private Integer selectedFileIndex = Integer.valueOf(-1);
    private State state = State.RETRIEVING_META;
    private final TorrentHandle torrentHandle;

    public enum State {
        UNKNOWN,
        RETRIEVING_META,
        STARTING,
        STREAMING
    }

    public Torrent(TorrentHandle torrentHandle, TorrentListener torrentListener, Long l) {
        this.torrentHandle = torrentHandle;
        this.listener = torrentListener;
        this.prepareSize = l;
        torrentHandle.setPriority(Priority.NORMAL.getSwig());
        if (this.selectedFileIndex.intValue() == -1) {
            setLargestFile();
        }
        if (this.listener != null) {
            this.listener.onStreamPrepared(this);
        }
    }

    private void resetPriorities() {
        Priority[] piecePriorities = this.torrentHandle.getPiecePriorities();
        int i = 0;
        while (i < piecePriorities.length) {
            if (i < this.firstPieceIndex.intValue() || i > this.lastPieceIndex.intValue()) {
                this.torrentHandle.setPiecePriority(i, Priority.IGNORE);
            } else {
                this.torrentHandle.setPiecePriority(i, Priority.NORMAL);
            }
            i++;
        }
    }

    public TorrentHandle getTorrentHandle() {
        return this.torrentHandle;
    }

    public File getVideoFile() {
        return new File(this.torrentHandle.getSavePath() + "/" + this.torrentHandle.getTorrentInfo().getFiles().getFilePath(this.selectedFileIndex.intValue()));
    }

    public File getSaveLocation() {
        return new File(this.torrentHandle.getSavePath() + "/" + this.torrentHandle.getName());
    }

    public void resume() {
        this.torrentHandle.resume();
    }

    public void pause() {
        this.torrentHandle.pause();
    }

    public void setLargestFile() {
        setSelectedFileIndex(Integer.valueOf(-1));
    }

    public void setSelectedFileIndex(Integer num) {
        int i;
        int i2;
        int i3 = 0;
        FileStorage files = this.torrentHandle.getTorrentInfo().getFiles();
        if (num.intValue() == -1) {
            long j = 0;
            i = -1;
            for (i2 = 0; i2 < files.getNumFiles(); i2++) {
                long fileSize = files.getFileSize(i2);
                if (j < fileSize) {
                    this.torrentHandle.setFilePriority(i, Priority.IGNORE);
                    this.torrentHandle.setFilePriority(i2, Priority.NORMAL);
                    i = i2;
                    j = fileSize;
                } else {
                    this.torrentHandle.setFilePriority(i2, Priority.IGNORE);
                }
            }
            num = Integer.valueOf(i);
        } else {
            for (i2 = 0; i2 < files.getNumFiles(); i2++) {
                if (i2 == num.intValue()) {
                    this.torrentHandle.setFilePriority(i2, Priority.NORMAL);
                } else {
                    this.torrentHandle.setFilePriority(i2, Priority.IGNORE);
                }
            }
        }
        this.selectedFileIndex = num;
        Priority[] piecePriorities = this.torrentHandle.getPiecePriorities();
        i2 = -1;
        i = -1;
        while (i3 < piecePriorities.length) {
            if (piecePriorities[i3] != Priority.IGNORE) {
                if (i == -1) {
                    i = i3;
                }
                piecePriorities[i3] = Priority.IGNORE;
            } else if (i != -1 && i2 == -1) {
                i2 = i3 - 1;
            }
            i3++;
        }
        if (i2 == -1) {
            i2 = piecePriorities.length - 1;
        }
        int i4 = (i2 - i) + 1;
        i3 = this.torrentHandle.getTorrentInfo().getPieceLength();
        if (i3 > 0) {
            i3 = (int) (this.prepareSize.longValue() / ((long) i3));
            if (i3 < MIN_PREPARE_COUNT.intValue()) {
                i3 = MIN_PREPARE_COUNT.intValue();
            } else if (i3 > MAX_PREPARE_COUNT.intValue()) {
                i3 = MAX_PREPARE_COUNT.intValue();
            }
        } else {
            i3 = DEFAULT_PREPARE_COUNT.intValue();
        }
        if (i4 < i3) {
            i3 = i4 / 2;
        }
        this.firstPieceIndex = Integer.valueOf(i);
        this.lastPieceIndex = Integer.valueOf(i2);
        this.piecesToPrepare = Integer.valueOf(i3);
    }

    public String[] getFileNames() {
        FileStorage files = this.torrentHandle.getTorrentInfo().getFiles();
        String[] strArr = new String[files.getNumFiles()];
        for (int i = 0; i < files.getNumFiles(); i++) {
            strArr[i] = files.getFileName(i);
        }
        return strArr;
    }

    public void startDownload() {
        if (this.state != State.STREAMING) {
            int i;
            this.state = State.STARTING;
            this.torrentHandle.setPriority(Priority.NORMAL.getSwig());
            List arrayList = new ArrayList();
            Priority[] piecePriorities = this.torrentHandle.getPiecePriorities();
            for (i = 0; i < piecePriorities.length; i++) {
                if (piecePriorities[i] != Priority.IGNORE) {
                    this.torrentHandle.setPiecePriority(i, Priority.NORMAL);
                }
            }
            for (i = 0; i < this.piecesToPrepare.intValue(); i++) {
                arrayList.add(Integer.valueOf(this.lastPieceIndex.intValue() - i));
                this.torrentHandle.setPiecePriority(this.lastPieceIndex.intValue() - i, Priority.SEVEN);
                this.torrentHandle.setPieceDeadline(this.lastPieceIndex.intValue() - i, IjkMediaCodecInfo.RANK_MAX);
            }
            for (i = 0; i < this.piecesToPrepare.intValue(); i++) {
                arrayList.add(Integer.valueOf(this.firstPieceIndex.intValue() + i));
                this.torrentHandle.setPiecePriority(this.firstPieceIndex.intValue() + i, Priority.SEVEN);
                this.torrentHandle.setPieceDeadline(this.firstPieceIndex.intValue() + i, IjkMediaCodecInfo.RANK_MAX);
            }
            this.preparePieces = arrayList;
            this.hasPieces = new Boolean[((this.lastPieceIndex.intValue() - this.firstPieceIndex.intValue()) + 1)];
            Arrays.fill(this.hasPieces, Boolean.valueOf(false));
            TorrentInfo torrentInfo = this.torrentHandle.getTorrentInfo();
            TorrentStatus status = this.torrentHandle.getStatus();
            this.progressStep = Double.valueOf(100.0d / ((double) ((torrentInfo.getPieceLength() * arrayList.size()) / status.getBlockSize())));
            this.torrentHandle.resume();
            this.listener.onStreamStarted(this);
        }
    }

    private void startSequentialMode() {
        resetPriorities();
        if (this.hasPieces == null) {
            this.torrentHandle.setSequentialDownload(true);
            return;
        }
        for (int intValue = this.firstPieceIndex.intValue() + this.piecesToPrepare.intValue(); intValue < (this.firstPieceIndex.intValue() + this.piecesToPrepare.intValue()) + 5; intValue++) {
            this.torrentHandle.setPiecePriority(intValue, Priority.SEVEN);
            this.torrentHandle.setPieceDeadline(intValue, IjkMediaCodecInfo.RANK_MAX);
        }
    }

    public State getState() {
        return this.state;
    }

    private void pieceFinished(PieceFinishedAlert pieceFinishedAlert) {
        if (this.state != State.STREAMING || this.hasPieces == null) {
            Iterator it = this.preparePieces.iterator();
            while (it.hasNext()) {
                if (((Integer) it.next()).intValue() == pieceFinishedAlert.getPieceIndex()) {
                    it.remove();
                }
            }
            if (this.hasPieces != null) {
                this.hasPieces[pieceFinishedAlert.getPieceIndex() - this.firstPieceIndex.intValue()] = Boolean.valueOf(true);
            }
            if (this.preparePieces.size() == 0) {
                startSequentialMode();
                this.prepareProgress = Double.valueOf(100.0d);
                sendStreamProgress();
                this.state = State.STREAMING;
                if (this.listener != null) {
                    this.listener.onStreamReady(this);
                    return;
                }
                return;
            }
            return;
        }
        this.hasPieces[pieceFinishedAlert.getPieceIndex() - this.firstPieceIndex.intValue()] = Boolean.valueOf(true);
        int pieceIndex = pieceFinishedAlert.getPieceIndex() - this.firstPieceIndex.intValue();
        while (pieceIndex < this.hasPieces.length) {
            if (this.hasPieces[pieceIndex].booleanValue()) {
                pieceIndex++;
            } else {
                this.torrentHandle.setPiecePriority(this.firstPieceIndex.intValue() + pieceIndex, Priority.SEVEN);
                this.torrentHandle.setPieceDeadline(pieceIndex + this.firstPieceIndex.intValue(), IjkMediaCodecInfo.RANK_MAX);
                return;
            }
        }
    }

    private void blockFinished(BlockFinishedAlert blockFinishedAlert) {
        for (Integer intValue : this.preparePieces) {
            if (intValue.intValue() == blockFinishedAlert.getPieceIndex()) {
                this.prepareProgress = Double.valueOf(this.prepareProgress.doubleValue() + this.progressStep.doubleValue());
                break;
            }
        }
        sendStreamProgress();
    }

    private void sendStreamProgress() {
        TorrentStatus status = this.torrentHandle.getStatus();
        float progress = status.getProgress() * 100.0f;
        int numSeeds = status.getNumSeeds();
        int downloadPayloadRate = status.getDownloadPayloadRate();
        if (this.listener != null && this.prepareProgress.doubleValue() >= 1.0d) {
            this.listener.onStreamProgress(this, new StreamStatus(progress, this.prepareProgress.intValue(), numSeeds, downloadPayloadRate));
        }
    }

    public int[] types() {
        return new int[]{AlertType.PIECE_FINISHED.getSwig(), AlertType.BLOCK_FINISHED.getSwig()};
    }

    public void alert(Alert<?> alert) {
        switch (alert.getType()) {
            case PIECE_FINISHED:
                pieceFinished((PieceFinishedAlert) alert);
                return;
            case BLOCK_FINISHED:
                blockFinished((BlockFinishedAlert) alert);
                return;
            default:
                return;
        }
    }
}
