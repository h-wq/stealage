package com.xupt.read.service;

import com.xupt.read.parseManger.BookInfo;

import java.util.List;

public interface SearchService {

    List<String> parseUrlBookName(String html, String name);

    BookInfo getBookInfo(String url, String name);
}
