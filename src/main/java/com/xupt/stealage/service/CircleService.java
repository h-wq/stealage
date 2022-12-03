package com.xupt.stealage.service;

import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.model.Circle;

import java.util.List;

public interface CircleService {

    PageResult<Circle> getCircles(List<Integer> userIds, int offset, int size);

    Integer addCircle(Circle circle);

    Integer deleteCircle(Integer id);
}
