package com.tdo.showbox.models;

import java.util.ArrayList;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class Phrase {
    private final long begin;
    private String content;
    private long delay;
    private final long end;
    private String num;

    public Phrase(String str, String str2, ArrayList<String> arrayList, long j) throws Exception {
        String[] split;
        if (str.endsWith("")) {
            this.delay = j;
            this.num = str;
            split = str2.split("-->");
        } else {
            this.delay = j;
            this.num = str;
            split = str2.split("-->");
        }
        if (split.length != 2) {
            throw new Exception("can`t parse time");
        }
        this.begin = parseTime(split[0]);
        this.end = parseTime(split[1]);
        this.content = "";
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.content += ((String) it.next()) + "\n";
        }
    }

    private long parseTime(String str) {
        String[] split = str.replaceAll(" ", "").split(":");
        long parseInt = (0 + ((long) (((Integer.parseInt(split[0]) * IjkMediaCodecInfo.RANK_MAX) * 60) * 60))) + ((long) ((Integer.parseInt(split[1]) * IjkMediaCodecInfo.RANK_MAX) * 60));
        split = split[2].split(",");
        return ((long) Integer.parseInt(split[1])) + (parseInt + ((long) (Integer.parseInt(split[0]) * IjkMediaCodecInfo.RANK_MAX)));
    }

    public boolean isCanShow(long j) {
        return this.begin <= this.delay + j && this.end > this.delay + j;
    }

    public String getContent() {
        return this.content;
    }

    public String generateTimeString() {
        return getTimeStr(this.begin) + " --> " + getTimeStr(this.end);
    }

    private String getTimeStr(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j % 1000;
        String str = "" + (j3 / 60);
        String str2 = "" + (j3 % 60);
        return str + ":" + str2 + ":" + ("" + (j2 % 60)) + "," + j4;
    }

    public String getNum() {
        return this.num;
    }
}
