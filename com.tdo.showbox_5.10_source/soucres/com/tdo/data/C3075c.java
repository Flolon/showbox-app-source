package com.tdo.showbox.data;

import android.os.Environment;
import com.activeandroid.query.Select;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.p131f.C3176e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadsCacheCleaner */
/* renamed from: com.tdo.showbox.data.c */
public class C3075c {
    /* renamed from: a */
    private List<String> f12070a = new ArrayList();

    /* renamed from: a */
    public void m16645a() {
        List<DownloadEpisode> execute = new Select().from(DownloadEpisode.class).execute();
        File file = new File(Environment.getExternalStorageDirectory(), "show_box");
        if (execute.size() == 0) {
            try {
                C3176e.m16968a(file);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        for (DownloadEpisode full_path : execute) {
            this.f12070a.add(full_path.getFull_path());
        }
        m16644a(file);
    }

    /* renamed from: a */
    private void m16644a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                m16644a(a);
            }
        }
        if (file != null && file.isFile() && !this.f12070a.contains(file.getAbsolutePath())) {
            file.delete();
            C3094j.m16698a("DownloadsCacheCleaner", "remove " + file.getAbsolutePath());
        }
    }
}
