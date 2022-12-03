package com.xupt.stealage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.mapper.EvaluateMapper;
import com.xupt.stealage.model.Evaluate;
import com.xupt.stealage.model.EvaluateExample;
import com.xupt.stealage.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public Integer addEvaluate(Evaluate evaluate) {
        return evaluateMapper.insertSelective(evaluate);
    }

    @Override
    public PageResult<Evaluate> getByStealageId(Integer stealageId, int offset, int size) {
        EvaluateExample example = new EvaluateExample();
        example.createCriteria().andStealageIdEqualTo(stealageId);
        example.setOrderByClause("create_time desc");

        PageHelper.offsetPage(offset, size, true);
        List<Evaluate> evaluateList = evaluateMapper.selectByExampleWithBLOBs(example);
        PageInfo<Evaluate> pageInfo = new PageInfo<>(evaluateList);
        evaluateList = pageInfo.getList();
        return PageResult.create(pageInfo, evaluateList);
    }
}
