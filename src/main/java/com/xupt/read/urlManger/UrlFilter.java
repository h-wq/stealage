package com.xupt.read.urlManger;

import com.xupt.read.util.Strings;
import java.util.HashSet;

/**
 * @description： 需要过滤的url  url黑名单管理
 */
public class UrlFilter {
    private static HashSet<String> filter = new HashSet<String>();
    private static HashSet<String> filterPrefix = new HashSet<String>();

    /**添加url黑名单*/
    public static void addFilter(String url){
        if(Strings.isEmptyOrNull(url)){
            return;
        }

        filter.add(url);
    }

    public static boolean isEmpty(){
        return filter.isEmpty();
    }

    public static HashSet<String> getFilterUrl(){
        return filter;
    }

    /**添加url前缀黑名单*/
    public static void addFilterUrlPrefix(String url){
        if(Strings.isEmptyOrNull(url)){
            return;
        }

        filterPrefix.add(url);
    }

    public static HashSet<String> getFilterPrefix(){
        return filterPrefix;
    }

    public static boolean isFilterPrefixEmpty(){
        return filterPrefix.isEmpty();
    }
}
