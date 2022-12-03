package com.xupt.stealage.controller.resp;

import com.xupt.stealage.model.StealageType;
import lombok.Builder;
import lombok.Data;

/**
 * 失物招领类型返回实体类
 */
@Builder
@Data
public class StealageTypeResp {

    private Integer id;

    private String name;

    public static StealageTypeResp convert(StealageType stealageType) {
        return StealageTypeResp.builder()
                .id(stealageType.getId())
                .name(stealageType.getName())
                .build();
    }
}
