package com.xupt.stealage.service;

import com.xupt.stealage.model.CircleLike;

import java.util.List;

public interface CircleLikeService {

    List<CircleLike> getCircleLikes(List<Integer> circleIds);

    Integer addCircleLike(CircleLike circleLike);

    Integer deleteCircleLike(Integer id);
}
