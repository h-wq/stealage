package com.xupt.stealage.service.impl;

import com.xupt.stealage.mapper.CircleCommentMapper;
import com.xupt.stealage.model.CircleComment;
import com.xupt.stealage.model.CircleCommentExample;
import com.xupt.stealage.service.CircleCommentService;
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
        example.createCriteria().andCircleIdIn(circleIds).andIsDeleteEqualTo(false);
        example.setOrderByClause("create_time desc");

        return circleCommentMapper.selectByExample(example);
    }

    @Override
    public Integer addCircleComment(CircleComment circleComment) {
        return circleCommentMapper.insertSelective(circleComment);
    }

    @Override
    public Integer deleteCircleComment(Integer id) {
        CircleComment circleComment = new CircleComment();
        circleComment.setId(id);
        circleComment.setIsDelete(true);
        return circleCommentMapper.updateByPrimaryKeySelective(circleComment);
    }
}
