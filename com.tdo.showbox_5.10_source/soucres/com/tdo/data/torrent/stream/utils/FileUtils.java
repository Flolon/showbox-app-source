package com.tdo.showbox.data.torrent.stream.utils;

import java.io.File;

public final class FileUtils {
    private FileUtils() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static boolean recursiveDelete(File file) {
        int i = 0;
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return false;
            }
            int length = list.length;
            while (i < length) {
                recursiveDelete(new File(file, list[i]));
                i++;
            }
        }
        return file.delete();
    }
}
