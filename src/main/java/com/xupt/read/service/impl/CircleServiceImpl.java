package com.xupt.read.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.mapper.CircleMapper;
import com.xupt.read.model.Circle;
import com.xupt.read.model.CircleExample;
import com.xupt.read.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private CircleMapper circleMapper;

    @Override
    public PageResult<Circle> getCircles(List<Integer> userIds, int offset, int size) {
        CircleExample example = new CircleExample();
        example.createCriteria().andUserIdIn(userIds);
        example.setOrderByClause("create_at desc");

        PageHelper.offsetPage(offset, size, true);
        List<Circle> circleList = circleMapper.selectByExample(example);
        PageInfo<Circle> pageInfo = new PageInfo<>(circleList);
        circleList = pageInfo.getList();
        return PageResult.create(pageInfo, circleList);
    }

    @Override
    public Integer addCircle(Circle circle) {
        return circleMapper.insertSelective(circle);
    }
}
