package com.xupt.stealage.service.impl;

import com.google.common.collect.Lists;
import com.xupt.stealage.mapper.StealageMapper;
import com.xupt.stealage.mapper.StealageProcessContentMapper;
import com.xupt.stealage.model.Stealage;
import com.xupt.stealage.model.StealageProcessContent;
import com.xupt.stealage.model.StealageProcessContentExample;
import com.xupt.stealage.service.StealageProcessContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StealageProcessContentServiceImpl implements StealageProcessContentService {

    @Autowired
    private StealageMapper stealageMapper;

    @Autowired
    private StealageProcessContentMapper stealageProcessContentMapper;

    @Override
    public List<StealageProcessContent> getContents(int stealageId, int userId) {
        Stealage stealage = stealageMapper.selectByPrimaryKey(stealageId);
        if (stealage == null) {
            return Collections.emptyList();
        }
        int selfUserId = stealage.getUserId();
        StealageProcessContentExample example = new StealageProcessContentExample();
        example.setOrderByClause("create_time asc");
        example.createCriteria().andUserIdIn(Lists.newArrayList(selfUserId, userId));
        return stealageProcessContentMapper.selectByExample(example);
    }

    @Override
    public Integer addStealageProcessContent(StealageProcessContent stealageProcessContent) {
        return stealageProcessContentMapper.insertSelective(stealageProcessContent);
    }
}
