package com.xupt.read.urlManger;

import com.xupt.read.util.Strings;
import java.util.HashSet;

/**
 * @description： 保存待爬取的url
 */
public class UrlSave {
    private static HashSet<String> urlStore = new HashSet<String>();


    public static synchronized boolean addUrl(String url) {
        if (Strings.isEmptyOrNull(url)) {
            return false;
        }

        urlStore.add(url);

        return true;
    }

    public static synchronized String getUrl() {
        if(urlStore.isEmpty()){
            return null;
        }

        return urlStore.iterator().next();
    }

    public static boolean isEmpty(){
        return urlStore.isEmpty();
    }

    public static void removeUrl(String url){
        if(Strings.isEmptyOrNull(url)){
            return;
        }

        urlStore.remove(url);
    }

    public static HashSet<String> getUrlStore(){
        return urlStore;
    }
}
