package com.xupt.stealage.service;

import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.model.Evaluate;

public interface EvaluateService {

    Integer addEvaluate(Evaluate evaluate);

    PageResult<Evaluate> getByStealageId(Integer stealageId, int offset, int size);
}
