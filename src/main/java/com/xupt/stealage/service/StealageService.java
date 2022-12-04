package com.xupt.stealage.service;

import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.data.StealageStatus;
import com.xupt.stealage.model.Stealage;

import java.util.List;

public interface StealageService {

    Integer addStealage(Stealage stealage);

    Stealage getById(Integer id);

    List<Stealage> getByIds(List<Integer> ids);

    PageResult<Stealage> getByStatuses(List<StealageStatus> stealageStatuses, int offset, int size);

    PageResult<Stealage> getByName(String name, int offset, int size);

    PageResult<Stealage> getByStealageTypeId(int stealageTypeId, int offset, int size);

    PageResult<Stealage> getByIsRecruitment(boolean isRecruitment, int offset, int size);

    PageResult<Stealage> getByUserId(int userId, int offset, int size);

    Integer updateStealageById(Stealage stealage);
}
