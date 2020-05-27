package com.xupt.read.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.mapper.EvaluateMapper;
import com.xupt.read.model.Evaluate;
import com.xupt.read.model.EvaluateExample;
import com.xupt.read.service.EvaluateService;
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
    public PageResult<Evaluate> getByBookId(Integer bookId, int offset, int size) {
        EvaluateExample example = new EvaluateExample();
        example.createCriteria().andBookIdEqualTo(bookId);
        example.setOrderByClause("created_at desc");

        PageHelper.offsetPage(offset, size, true);
        List<Evaluate> evaluateList = evaluateMapper.selectByExample(example);
        PageInfo<Evaluate> pageInfo = new PageInfo<>(evaluateList);
        evaluateList = pageInfo.getList();
        return PageResult.create(pageInfo, evaluateList);
    }
}
