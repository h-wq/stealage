package com.xupt.read.parseManger;

import java.io.*;

public class TxtDownload {

    private static final String FILE_UPLOAD_PATH = "/work/project/file/upload/read/txt";

    public static String download(String txt, String name, int chapterNum){
        FileOutputStream fos = null;
        String path = FILE_UPLOAD_PATH;
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            path += "/" + name + "/" + chapterNum + "/" + name + chapterNum + ".txt";
            File file = new File(path);
            fos = new FileOutputStream(file);
            fos.write(txt.getBytes());
            fos.flush();
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
        return path;
    }
}
