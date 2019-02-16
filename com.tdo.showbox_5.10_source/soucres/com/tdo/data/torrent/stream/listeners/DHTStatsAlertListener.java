package com.tdo.showbox.data.torrent.stream.listeners;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.DHTRoutingBucket;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.DhtStatsAlert;

public abstract class DHTStatsAlertListener implements AlertListener {
    public abstract void stats(int i);

    public int[] types() {
        return new int[]{AlertType.DHT_STATS.getSwig()};
    }

    public void alert(Alert<?> alert) {
        if (alert instanceof DhtStatsAlert) {
            stats(countTotalDHTNodes((DhtStatsAlert) alert));
        }
    }

    private int countTotalDHTNodes(DhtStatsAlert dhtStatsAlert) {
        int i = 0;
        DHTRoutingBucket[] routingTable = dhtStatsAlert.getRoutingTable();
        if (routingTable != null) {
            int i2 = 0;
            while (i2 < routingTable.length) {
                int numNodes = routingTable[i2].getNumNodes() + i;
                i2++;
                i = numNodes;
            }
        }
        return i;
    }
}
