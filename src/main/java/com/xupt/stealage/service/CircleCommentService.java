package com.xupt.stealage.service;

import com.xupt.stealage.model.CircleComment;

import java.util.List;

public interface CircleCommentService {

    List<CircleComment> getCircleComments(List<Integer> circleIds);

    Integer addCircleComment(CircleComment circleComment);

    Integer deleteCircleComment(Integer id);
}
