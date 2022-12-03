package com.xupt.stealage.service;

import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.model.Opinion;

public interface OpinionService {

    Integer addOpinion(Opinion opinion);

    PageResult<Opinion> getOpinions(int offset, int size);
}
