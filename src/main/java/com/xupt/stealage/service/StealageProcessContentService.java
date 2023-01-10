package com.xupt.stealage.service;

import com.xupt.stealage.model.StealageProcessContent;

import java.util.List;

public interface StealageProcessContentService {

    List<StealageProcessContent> getContents(int stealageId, int userId);

    Integer addStealageProcessContent(StealageProcessContent stealageProcessContent);
}
