package com.xupt.read.parseManger;

import com.xupt.read.urlManger.UrlManger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @description：  解析页面
 */
public class UrlParse {

    /**
     *
     * @param html   解析主页html的书籍url链接
     */
    public static void parseUrlMain(String html){
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("list-col list-col5 list-express slide-item");

        for(Element element : elements){
            Elements eles = element.getElementsByClass("cover");
            for(Element e : eles){

                 Elements elements1 = e.select("a[href]");
                 for(Element el : elements1){
                     String url = el.attr("href");
                     UrlManger.addUrl(url);
                 }
            }
        }

    }

    /**
     * class="content clearfix"
     * @param html  解析数据详情页面的url
     */
    public static void parseUrlSub(String html){
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("content clearfix");

        for(Element element : elements){

            Elements subElements = element.select("a[href]");
            for(Element e : subElements){
                String url = e.attr("href");
                UrlManger.addUrl(url);
            }
        }
    }
}
