package com.xupt.read.service;

import com.xupt.read.common.result.PageResult;
import com.xupt.read.model.Evaluate;

public interface EvaluateService {

    Integer addEvaluate(Evaluate evaluate);

    PageResult<Evaluate> getByBookId(Integer bookId, int offset, int size);
}
