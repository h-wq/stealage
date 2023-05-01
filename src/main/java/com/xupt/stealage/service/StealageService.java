package com.xupt.stealage.service;

import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.data.StealageStatus;
import com.xupt.stealage.model.Stealage;
import com.xupt.stealage.model.StealageTopUser;

import java.util.List;

public interface StealageService {

    Integer addStealage(Stealage stealage);

    Integer modifyStealageStatus(Integer id, StealageStatus stealageStatus);

    Integer deleteStealage(Integer id);

    Stealage getById(Integer id);

    List<Stealage> getByIds(List<Integer> ids);

    PageResult<Stealage> getByStatuses(List<StealageStatus> stealageStatuses, int offset, int size);

    PageResult<Stealage> getByName(String name, int offset, int size);

    PageResult<Stealage> getByStealageTypeId(int stealageTypeId, int offset, int size);

    PageResult<Stealage> getByStealageTypeId(int stealageTypeId, Boolean isRecruitment, int offset, int size);

    PageResult<Stealage> getByIsRecruitment(boolean isRecruitment, int offset, int size);

    PageResult<Stealage> getByUserId(int userId, int offset, int size);

    List<Integer> getDaysOfThisMonth();

    PageResult<Stealage> getByDayOfThisMonth(int day, int offset, int size);

    List<StealageTopUser> getTopUser(int top, boolean isRecruitment);

    Integer updateStealageById(Stealage stealage);
}
