package com.xupt.read.service;

import com.xupt.read.common.result.PageResult;
import com.xupt.read.model.Circle;

import java.util.List;

public interface CircleService {

    PageResult<Circle> getCircles(List<Integer> userIds, int offset, int size);

    Integer addCircle(Circle circle);
}
