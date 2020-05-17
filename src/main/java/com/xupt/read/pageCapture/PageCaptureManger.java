package com.xupt.read.pageCapture;

import com.xupt.read.util.Strings;

/**
 * @description：  网页抓取调度器
 */
public class PageCaptureManger {
    public static String getPage(String url){
        if(Strings.isEmptyOrNull(url)){
            return null;
        }
        /**
         * 获取页面
         */
        String html = CapturePage.getHtml(url);
        return html;
    }
}
