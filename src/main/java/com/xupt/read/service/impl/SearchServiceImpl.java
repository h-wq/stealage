package com.xupt.read.service.impl;

import com.xupt.read.dataOut.DataOutput;
import com.xupt.read.mapper.BookMapper;
import com.xupt.read.model.Book;
import com.xupt.read.pageCapture.CapturePage;
import com.xupt.read.parseManger.BookInfo;
import com.xupt.read.parseManger.PageParseManger;
import com.xupt.read.parseManger.UrlParse;
import com.xupt.read.service.SearchService;
import com.xupt.read.urlManger.UrlManger;
import com.xupt.read.urlManger.UrlSave;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<String> parseUrlBookName(String html) {
        List<String> urls = new ArrayList<>();
        try {
            Document document = Jsoup.parse(html);
            Elements elements = document.getElementsByClass("result");

            for (Element element : elements) {

                Element ele = element.getElementsByClass("nbg").get(0);
                String url = ele.attr("href");
                //解码
                url = URLDecoder.decode(url, "UTF-8");
                //截取想要的
                url = url.substring(url.indexOf("=") + 1, url.indexOf("&"));
                urls.add(url);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return urls;
    }

    @Override
    public BookInfo getBookInfo(String url) {
        BookInfo bookInfo = new BookInfo();
        try {
            String ebookUrl = "https://read.douban.com/ebook";
            UrlManger.addUrl(url);
            /**获取页面*/
            String html = CapturePage.getHtml(url);

            /**主页获取完书籍的连接后禁掉*/
            UrlManger.addFilterUrl(url);

            /**没有对电子书籍的页面解析，加入黑名单*/
            UrlManger.addFilterPrefix(ebookUrl);

            /**获取主页的书籍url*/
            UrlParse.parseUrlMain(html);

            /**爬取书籍信息  不保证所有的url都能正常的解析*/
            if (!UrlSave.isEmpty()) {
                /**目前没有ip代理爬慢一点，快了要封ip*/
                Thread.sleep(3000);
                String urlA = UrlManger.getUrl();
                System.out.println("正在爬取的url：" + urlA);
                bookInfo = spiderBook(urlA);

                //插入图书信息
                Book book = new Book();
                book.setName(bookInfo.getBookName());
                //todo?????图片信息
                book.setPicture(bookInfo.getImgName());
                book.setAuthor(bookInfo.getAuthorName());
                book.setLink(bookInfo.getBookLink());

                bookMapper.insertSelective(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfo;
    }

    private BookInfo spiderBook(String url) {
        /**获取页面*/
        String html = CapturePage.getHtml(url);

        /**解析书籍的url并将书籍url添加到url管理器里*/
        UrlParse.parseUrlSub(html);

        /**解析书籍  默认爬取3页的短评*/
        BookInfo bookInfo = PageParseManger.parseBookInfo(html, url, 3);

        /**数据输出*/
        DataOutput.output(bookInfo);

        return bookInfo;
    }
}
