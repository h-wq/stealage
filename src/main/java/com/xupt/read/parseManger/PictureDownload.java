package com.xupt.read.parseManger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PictureDownload {

    private static String fileUploadPath = "/project/file/upload/read/img";

    public static String download(String img, String name){
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        String path = fileUploadPath;
        URL url;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(img);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            path += "/" + name;
            File file = new File(path);
            fos = new FileOutputStream(file);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
        return path;
    }

    /**
     *  获取文件夹的路径
     * @return
     */
//    private static String getPath(){
//        String path = PictureDownload.class.getClassLoader().getResource("").getPath();
//        path = path.split("target")[0];
//        path = path + "download/picture";
//        return path;
//    }
}
