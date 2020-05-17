package com.xupt.read.urlManger;

import com.xupt.read.util.Strings;

/**
 * @description：   url管理器   使用hashSet缓存url并去重，不太适合爬取数据集很大的数据
 */

public class UrlManger {

    /**
     *
     * @param url  过滤添加到urlStore里的url
     */
    public static void addUrl(String url){
        if(Strings.isEmptyOrNull(url)){
            return;
        }

        /**过滤禁用的url*/
        if(!UrlFilter.isEmpty()){
            for(String filterUrl : UrlFilter.getFilterUrl()){
                if(filterUrl.equals(url)){
                    return;
                }
            }
        }

        /**过滤前缀黑名单匹配的url*/
        if(!UrlFilter.isFilterPrefixEmpty()){
            for(String filterUrl : UrlFilter.getFilterPrefix()){
                if(url.contains(filterUrl)){
                    return;
                }
            }
        }

        UrlSave.addUrl(url);
    }

    /**
     *
     * @return  获取的url是经过过滤的，去重
     */
    public static String getUrl(){
        boolean flag = true;
        String url = null;
        while(flag) {
            url = UrlSave.getUrl();
            if (!UrlSpiderUsed.getUrlUsed().contains(url)) {
                flag = false;
                UrlSpiderUsed.addUsedUrl(url);
            }
            UrlSave.removeUrl(url);
        }

        return url;
    }

    public static boolean isEmpty(){
        return UrlSave.isEmpty();
    }

    public static void addFilterUrl(String url){

        UrlFilter.addFilter(url);
    }

    public static void addFilterPrefix(String url){
        UrlFilter.addFilterUrlPrefix(url);
    }
}
