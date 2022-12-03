package com.xupt.stealage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.mapper.CircleMapper;
import com.xupt.stealage.model.Circle;
import com.xupt.stealage.model.CircleExample;
import com.xupt.stealage.service.CircleService;
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
        example.createCriteria().andUserIdIn(userIds).andIsDeleteEqualTo(false);
        example.setOrderByClause("create_time desc");

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

    @Override
    public Integer deleteCircle(Integer id) {
        Circle circle = new Circle();
        circle.setId(id);
        circle.setIsDelete(true);
        return circleMapper.updateByPrimaryKeySelective(circle);
    }
}
