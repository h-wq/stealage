package com.xupt.read.dataOut;

import com.xupt.read.parseManger.BookInfo;

/**
 * @description：  数据输出保存
 */
public class DataOutput {
    private static String path = "";

    public static void output(BookInfo bookInfo){
        if(bookInfo == null){
            return;
        }

        System.out.println(bookInfo.toString());

    }
}
