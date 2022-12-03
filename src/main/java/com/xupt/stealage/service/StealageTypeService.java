package com.xupt.stealage.service;

import com.xupt.stealage.model.StealageType;

import java.util.List;

public interface StealageTypeService {

    Integer addStealageType(String name);

    Integer addStealageType(StealageType stealageType);

    List<StealageType> getStealageTypes();

    StealageType getById(Integer id);

    List<StealageType> getByIds(List<Integer> ids);

    boolean isHasStealageType(String name);
}
