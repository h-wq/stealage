package com.xupt.read.urlManger;

import com.xupt.read.util.Strings;
import java.util.HashSet;

/**
 * @description：  爬取过得url
 */
public class UrlSpiderUsed {
    private static HashSet<String> urlUsed = new HashSet<String>();

    public static void addUsedUrl(String url){
        if(Strings.isEmptyOrNull(url)){
            return;
        }

        urlUsed.add(url);
    }

    public static HashSet<String> getUrlUsed(){
        return urlUsed;
    }
}
