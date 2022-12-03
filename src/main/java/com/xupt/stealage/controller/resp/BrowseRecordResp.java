//package com.xupt.stealage.controller.resp;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.Builder;
//import lombok.Data;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * 用户浏览记录请求实体类
// */
//@Builder
//@Data
//public class BrowseRecordResp {
//
//    private BookResp bookResp;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date time;
//
//    public static BrowseRecordResp convert(List<Book> books, BrowseRecord browseRecord, List<BookType> bookTypes) {
//
//        Book book = books.stream().filter(b -> browseRecord.getBookId().equals(b.getId())).findFirst().get();
//        BookResp bookResp = BookResp.convert(book, bookTypes);
//        return BrowseRecordResp.builder()
//                .bookResp(bookResp)
//                .time(browseRecord.getCreateTime())
//                .build();
//    }
//}
