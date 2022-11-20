package com.xupt.read.parseManger;

import com.xupt.read.util.Md5Utils;
import org.jsoup.nodes.Document;

/**
 * @description：  网页解析管理器
 */
public class PageParseManger {

    /***
     *
     * @param html        爬取的页面
     * @param bookUrl     书籍链接
     * @param commentNum  爬取书籍的前number页短评
     * @return   解析书籍的信息
     */
    public static BookInfo parseBookInfo(String html, String bookUrl, String name, int commentNum){
        if(html == null){
            return null;
        }

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookUrl(bookUrl);

        Document document =PageParse.getDocument(html);

        /**书籍的名字*/
        PageParse.getBookName(document, bookInfo);

        /**获取出版社 作者 出版年*/
        PageParse.getBookInfo(document, bookInfo);

        if (name != null && !bookInfo.getBookName().contains(name) && !bookInfo.getAuthorName().contains(name)) {
            return null;
        }

        /**解析img地址*/
        PageParse.getBookImg(document, bookInfo);
        String imgName = Md5Utils.encrypt(bookInfo.getImgName()) + ".jpg";

        /**下载图片*/
        String path = PictureDownload.download(bookInfo.getImgName(), imgName);
        bookInfo.setImgName(imgName);
        bookInfo.setImgPath(path);
        bookInfo.setBookLink(bookUrl);

        /**书评*/
        PageParse.getBookComments(document, bookInfo, commentNum);

        /**书籍和作者的简介*/
        PageParse.getBookAndAuthorInfo(document, bookInfo);

        /**评分*/
        PageParse.getScore(document, bookInfo);

        /**人气*/
        PageParse.getPopularity(document, bookInfo);

        return bookInfo;
    }
}
