package com.xupt.stealage.service.impl;

import com.xupt.stealage.mapper.StealageTypeMapper;
import com.xupt.stealage.model.StealageType;
import com.xupt.stealage.model.StealageTypeExample;
import com.xupt.stealage.service.StealageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StealageTypeServiceImpl implements StealageTypeService {

    @Autowired
    private StealageTypeMapper stealageTypeMapper;

    @Override
    public Integer addStealageType(String name) {
        StealageType stealageType = new StealageType();
        stealageType.setName(name);
        return stealageTypeMapper.insertSelective(stealageType);
    }

    @Override
    public Integer addStealageType(StealageType stealageType) {
        return stealageTypeMapper.insertSelective(stealageType);
    }

    @Override
    public List<StealageType> getStealageTypes() {
        StealageTypeExample example = new StealageTypeExample();
        return stealageTypeMapper.selectByExample(example);
    }

    @Override
    public StealageType getById(Integer id) {
        return stealageTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StealageType> getByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        StealageTypeExample example = new StealageTypeExample();
        example.createCriteria().andIdIn(ids);
        return stealageTypeMapper.selectByExample(example);
    }

    @Override
    public boolean isHasStealageType(String name) {
        StealageTypeExample example = new StealageTypeExample();
        example.createCriteria().andNameEqualTo(name);
        StealageType stealageType = stealageTypeMapper.selectByExample(example).stream().findFirst().orElse(null);
        return stealageType != null;
    }
}
