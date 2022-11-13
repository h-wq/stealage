package com.xupt.read.service;

import com.xupt.read.model.CircleLike;

import java.util.List;

public interface CircleLikeService {

    List<CircleLike> getCircleLikes(List<Integer> circleIds);

    Integer addCircleLike(CircleLike circleLike);

    Integer deleteCircleLike(Integer id);
}
