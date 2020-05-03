package com.xupt.read.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtils {

    public static String uploadFile(String uploadPath, MultipartFile file) {
        InputStream is = null;
        OutputStream os = null;
        String path = null;
        String fileName = new Date().getTime() + "_" + file.getOriginalFilename();
        try{
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(uploadPath);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            is = file.getInputStream();
            path = tempFile.getPath() + fileName;
            os = new FileOutputStream(path);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    public static List<String> uploadFile(String uploadPath, List<MultipartFile> files) {
        List<String> paths= new ArrayList<>();
        for (MultipartFile file : files) {
            String path = uploadFile(uploadPath, file);
            paths.add(path);
        }
        return paths;
    }
}
