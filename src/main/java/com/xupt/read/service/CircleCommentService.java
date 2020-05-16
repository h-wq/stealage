package com.xupt.read.service;

import com.xupt.read.model.CircleComment;

import java.util.List;

public interface CircleCommentService {

    List<CircleComment> getCircleComments(List<Integer> circleIds);

    Integer addCircleComment(CircleComment circleComment);

    Integer deleteCircleComment(Integer id);
}
