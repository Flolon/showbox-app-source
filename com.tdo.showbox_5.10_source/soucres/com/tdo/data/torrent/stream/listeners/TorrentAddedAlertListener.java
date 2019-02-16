package com.tdo.showbox.data.torrent.stream.listeners;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.TorrentAddedAlert;

public abstract class TorrentAddedAlertListener implements AlertListener {
    public abstract void torrentAdded(TorrentAddedAlert torrentAddedAlert);

    public int[] types() {
        return new int[]{AlertType.TORRENT_ADDED.getSwig()};
    }

    public void alert(Alert<?> alert) {
        switch (alert.getType()) {
            case TORRENT_ADDED:
                torrentAdded((TorrentAddedAlert) alert);
                return;
            default:
                return;
        }
    }
}
