package com.xupt.read.service.impl;

import com.xupt.read.mapper.CircleLikeMapper;
import com.xupt.read.model.CircleLike;
import com.xupt.read.model.CircleLikeExample;
import com.xupt.read.service.CircleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleLikeServiceImpl implements CircleLikeService {

    @Autowired
    private CircleLikeMapper circleLikeMapper;

    @Override
    public List<CircleLike> getCircleLikes(List<Integer> circleIds) {
        CircleLikeExample example = new CircleLikeExample();
        example.createCriteria().andCircleIdIn(circleIds).andIsDeleteEqualTo(false);
        example.setOrderByClause("create_time desc");

        return circleLikeMapper.selectByExample(example);
    }

    @Override
    public Integer addCircleLike(CircleLike circleLike) {
        return circleLikeMapper.insertSelective(circleLike);
    }

    @Override
    public Integer deleteCircleLike(Integer id) {
        CircleLike circleLike = new CircleLike();
        circleLike.setId(id);
        circleLike.setIsDelete(true);
        return circleLikeMapper.updateByPrimaryKeySelective(circleLike);
    }
}
