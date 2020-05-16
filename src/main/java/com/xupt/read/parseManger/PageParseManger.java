package com.xupt.read.parseManger;

import com.xupt.read.util.Md5Utils;

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
    public static BookInfo parseBookInfo(String html, String bookUrl, int commentNum){
        if(html == null){
            return null;
        }

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookUrl(bookUrl);

        /**解析img地址*/
        PageParse.getBookImg(html, bookInfo);
        String imgName = Md5Utils.encrypt(bookInfo.getImgName())+".jpg";

        /**下载图片*/
        PictureDownload.download(bookInfo.getImgName(),imgName);
        bookInfo.setImgName(imgName);
        bookInfo.setBookLink(bookUrl);

        /**书评*/
        PageParse.getBookComments(html, bookInfo, commentNum);

        /**书籍和作者的简介*/
        PageParse.getBookAndAuthorInfo(html, bookInfo);

        /**书籍的名字*/
        PageParse.getBookName(html, bookInfo);

        /**获取出版社 作者 出版年*/
        PageParse.getBookInfo(html, bookInfo);
        return bookInfo;
    }
}
