package com.xupt.read.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.mapper.OpinionMapper;
import com.xupt.read.model.Opinion;
import com.xupt.read.model.OpinionExample;
import com.xupt.read.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    private OpinionMapper opinionMapper;

    @Override
    public Integer addOpinion(Opinion opinion) {
        return opinionMapper.insertSelective(opinion);
    }

    @Override
    public PageResult<Opinion> getOpinions(int offset, int size) {
        OpinionExample example = new OpinionExample();
        example.setOrderByClause("created_time desc");

        PageHelper.offsetPage(offset, size, true);
        List<Opinion> opinionList = opinionMapper.selectByExample(example);
        PageInfo<Opinion> pageInfo = new PageInfo<>(opinionList);
        opinionList = pageInfo.getList();
        return PageResult.create(pageInfo, opinionList);
    }
}
