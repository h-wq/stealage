package com.xupt.read.service.impl;

import com.xupt.read.mapper.EvaluateMapper;
import com.xupt.read.model.Book;
import com.xupt.read.model.BookType;
import com.xupt.read.model.Evaluate;
import com.xupt.read.pageCapture.CapturePage;
import com.xupt.read.parseManger.BookInfo;
import com.xupt.read.parseManger.PageParseManger;
import com.xupt.read.parseManger.UrlParse;
import com.xupt.read.service.BookService;
import com.xupt.read.service.BookTypeService;
import com.xupt.read.service.SearchService;
import com.xupt.read.urlManger.UrlManger;
import com.xupt.read.urlManger.UrlSave;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public List<String> parseUrlBookName(String html, String name) {
        List<String> urls = new ArrayList<>();
        try {
            Document document = Jsoup.parse(html);
            Elements elements = document.getElementsByClass("result");

            for (Element element : elements) {

                Element titleElement = element.getElementsByClass("title").get(0);
                Element h3Element = titleElement.child(0);
                String bookName = h3Element.selectFirst("a[target=_blank]").html();
                Elements spanElements = element.getElementsByClass("subject-cast");
                if (spanElements == null || spanElements.isEmpty()) {
                    continue;
                }
                String authorName = spanElements.get(0).html();
                if (!bookName.contains(name) && !authorName.contains(name)) {
                    continue;
                }

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
    public BookInfo getBookInfo(String url, String name) {
        BookInfo bookInfo = null;
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
//                Thread.sleep(3000);
                String urlA = UrlManger.getUrl();
                System.out.println("正在爬取的url：" + urlA);
                bookInfo = spiderBook(urlA, name);

                if (bookInfo != null) {
                    //插入图书信息
                    Book book = new Book();
                    book.setName(bookInfo.getBookName());
                    book.setPicture(bookInfo.getImgPath());
                    book.setAuthor(bookInfo.getAuthorName());
                    book.setLink(bookInfo.getBookLink());
                    book.setSynopsis(bookInfo.getBookInfo());
                    book.setScore(bookInfo.getScore());
                    book.setPopularity(bookInfo.getPopularity());
                    book.setAuthorInfo(bookInfo.getAuthorInfo());
                    book.setBookPublish(bookInfo.getBookPublish());
                    book.setPublishYear(bookInfo.getPublishYear());
                    bookService.addBook(book);
                    int bookId = book.getId();

                    Integer typeId = bookTypeService.isHasBookType(bookInfo.getBookType());
                    if (typeId == null) {
                        BookType bookType = new BookType();
                        bookType.setName(bookInfo.getBookType());
                        bookTypeService.addBookType(bookType);
                        typeId = bookType.getId();
                    }
                    Book updateBook = new Book();
                    updateBook.setId(bookId);
                    updateBook.setTypeId(typeId);
                    bookService.updateBookById(updateBook);

                    List<String> comments = bookInfo.getBookComment();
                    List<Evaluate> evaluates = comments.stream().map(comment -> {
                        if (!StringUtils.isEmpty(comment)) {
                            Evaluate evaluate = new Evaluate();
                            evaluate.setBookId(bookId);
                            evaluate.setUserId(0);
                            evaluate.setRemarks(comment);
                            return evaluate;
                        }
                        return null;
                    }).filter(Objects::nonNull).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(evaluates)) {
                        evaluateMapper.insertBatch(evaluates);
                    }

                    bookInfo.setId(bookId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfo;
    }

    private BookInfo spiderBook(String url, String name) {
        /**获取页面*/
        String html = CapturePage.getHtml(url);

        /**解析书籍的url并将书籍url添加到url管理器里*/
        UrlParse.parseUrlSub(html);

        /**解析书籍  默认爬取3页的短评*/
        BookInfo bookInfo = PageParseManger.parseBookInfo(html, url, name, 3);

        /**数据输出*/
//        DataOutput.output(bookInfo);

        return bookInfo;
    }
}
