package com.xupt.stealage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.mapper.OpinionMapper;
import com.xupt.stealage.model.Opinion;
import com.xupt.stealage.model.OpinionExample;
import com.xupt.stealage.service.OpinionService;
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
        example.setOrderByClause("create_time desc");

        PageHelper.offsetPage(offset, size, true);
        List<Opinion> opinionList = opinionMapper.selectByExample(example);
        PageInfo<Opinion> pageInfo = new PageInfo<>(opinionList);
        opinionList = pageInfo.getList();
        return PageResult.create(pageInfo, opinionList);
    }
}
