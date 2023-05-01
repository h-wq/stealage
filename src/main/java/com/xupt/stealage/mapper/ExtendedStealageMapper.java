package com.xupt.stealage.mapper;

import com.xupt.stealage.model.StealageTopUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendedStealageMapper {

    List<StealageTopUser> selectTopUser(@Param("isRecruitment") boolean isRecruitment);
}
