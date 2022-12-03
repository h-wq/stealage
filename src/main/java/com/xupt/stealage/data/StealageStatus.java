package com.xupt.stealage.data;

import lombok.Getter;

public enum StealageStatus {

    PENDING("待处理"),

    PROCESSING("处理中"),

    COMPLETED("完成的");

    @Getter
    private String desc;

    StealageStatus(String desc) {
        this.desc = desc;
    }


}
