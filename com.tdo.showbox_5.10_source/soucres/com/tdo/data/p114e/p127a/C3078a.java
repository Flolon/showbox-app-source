package com.tdo.showbox.data.p114e.p127a;

import com.tdo.showbox.models.Phrase;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3181h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SubtitleConvertor */
/* renamed from: com.tdo.showbox.data.e.a.a */
public class C3078a {
    /* renamed from: a */
    public static boolean m16652a(String str, int i) {
        try {
            Reader inputStreamReader;
            String a = C3181h.m16977a(C3176e.m16970b(new FileInputStream(new File(str))));
            InputStream fileInputStream = new FileInputStream(new File(str));
            if (a.equalsIgnoreCase("MACCYRILLIC")) {
                inputStreamReader = new InputStreamReader(fileInputStream, "cp1256");
            } else {
                inputStreamReader = new InputStreamReader(fileInputStream, a);
            }
            File file = new File(str + ".tmp");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            C3078a.m16651a(bufferedReader, bufferedWriter, i);
            bufferedReader.close();
            bufferedWriter.close();
            C3176e.m16968a(new File(str));
            file.renameTo(new File(str));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private static void m16651a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, int i) throws Exception {
        String str = "";
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        Object obj = null;
        while (true) {
            str3 = bufferedReader.readLine();
            if (str3 == null) {
                break;
            }
            Iterator it;
            if (!str3.equals("")) {
                obj = 1;
            } else if (obj != null) {
                try {
                    bufferedWriter.write(str + "\n" + new Phrase(str, str2, arrayList, (long) i).generateTimeString() + "\n");
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        bufferedWriter.write(((String) it.next()) + "\n");
                    }
                    bufferedWriter.write("\n");
                } catch (Exception e) {
                }
                str = "";
                str2 = "";
                arrayList.clear();
                obj = null;
            }
            if (str.equals("")) {
                str = str3;
            } else if (str2.equals("")) {
                str2 = str3;
            } else {
                arrayList.add(str3);
            }
        }
        if (obj != null) {
            try {
                bufferedWriter.write(str + "\n" + new Phrase(str, str2, arrayList, (long) i).generateTimeString() + "\n");
                it = arrayList.iterator();
                while (it.hasNext()) {
                    bufferedWriter.write(((String) it.next()) + "\n");
                }
                bufferedWriter.write("\n");
            } catch (Exception e2) {
            }
        }
    }
}
