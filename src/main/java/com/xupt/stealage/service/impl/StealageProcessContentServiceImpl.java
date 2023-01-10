package com.xupt.stealage.service.impl;

import com.xupt.stealage.mapper.StealageProcessContentMapper;
import com.xupt.stealage.model.StealageProcessContent;
import com.xupt.stealage.model.StealageProcessContentExample;
import com.xupt.stealage.service.StealageProcessContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StealageProcessContentServiceImpl implements StealageProcessContentService {

    @Autowired
    private StealageProcessContentMapper stealageProcessContentMapper;

    @Override
    public List<StealageProcessContent> getContents(int stealageId) {
        StealageProcessContentExample example = new StealageProcessContentExample();
        example.setOrderByClause("create_time asc");
        example.createCriteria().andStealageIdEqualTo(stealageId);
        return stealageProcessContentMapper.selectByExample(example);
    }

    @Override
    public Integer addStealageProcessContent(StealageProcessContent stealageProcessContent) {
        return stealageProcessContentMapper.insertSelective(stealageProcessContent);
    }
}
