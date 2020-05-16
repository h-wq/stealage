package com.xupt.read.service.impl;

import com.xupt.read.mapper.LikesMapper;
import com.xupt.read.model.Likes;
import com.xupt.read.model.LikesExample;
import com.xupt.read.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesMapper likesMapper;

    @Override
    public List<Likes> getCircleLikes(List<Integer> circleIds) {
        LikesExample example = new LikesExample();
        example.createCriteria().andCircleIdIn(circleIds).andIsDeleteEqualTo(false);
        example.setOrderByClause("created_at desc");

        return likesMapper.selectByExample(example);
    }

    @Override
    public Integer addCircleLike(Likes like) {
        return likesMapper.insertSelective(like);
    }

    @Override
    public Integer deleteCircleLike(Integer id) {
        Likes likes = new Likes();
        likes.setId(id);
        likes.setIsDelete(true);
        return likesMapper.updateByPrimaryKeySelective(likes);
    }
}
