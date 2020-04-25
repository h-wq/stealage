package com.xupt.read.service;

import com.xupt.read.common.result.PageResult;
import com.xupt.read.model.Opinion;

public interface OpinionService {

    Integer addOpinion(Opinion opinion);

    PageResult<Opinion> getOpinions(int offset, int size);
}
