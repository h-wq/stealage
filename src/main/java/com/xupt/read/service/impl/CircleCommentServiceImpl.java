package com.xupt.read.service.impl;

import com.xupt.read.mapper.CircleCommentMapper;
import com.xupt.read.model.CircleComment;
import com.xupt.read.model.CircleCommentExample;
import com.xupt.read.service.CircleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleCommentServiceImpl implements CircleCommentService {

    @Autowired
    private CircleCommentMapper circleCommentMapper;

    @Override
    public List<CircleComment> getCircleComments(List<Integer> circleIds) {
        CircleCommentExample example = new CircleCommentExample();
        example.createCriteria().andCircleIdIn(circleIds);
        example.setOrderByClause("created_at desc");

        return circleCommentMapper.selectByExample(example);
    }

    @Override
    public Integer addCircleComment(CircleComment circleComment) {
        return circleCommentMapper.insertSelective(circleComment);
    }
}
