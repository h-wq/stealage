package com.xupt.stealage.data;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

public enum StealageStatus {

    PENDING("待处理"),

    PROCESSING("处理中"),

    COMPLETED("完成的");

    @Getter
    private String desc;

    StealageStatus(String desc) {
        this.desc = desc;
    }

    public static final List<StealageStatus> UN_COMPLETED = Lists.newArrayList(PENDING, PROCESSING);
}
