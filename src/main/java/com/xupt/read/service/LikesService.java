package com.xupt.read.service;

import com.xupt.read.model.Likes;

import java.util.List;

public interface LikesService {

    List<Likes> getCircleLikes(List<Integer> circleIds);

    Integer addCircleLike(Likes like);

    Integer deleteCircleLike(Integer id);
}
