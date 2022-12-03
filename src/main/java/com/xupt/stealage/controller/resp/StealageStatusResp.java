package com.xupt.stealage.controller.resp;

import com.xupt.stealage.data.StealageStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StealageStatusResp {

    private String name;

    private String desc;

    public static StealageStatusResp convert(StealageStatus stealageStatus) {
        return new StealageStatusResp(stealageStatus.name(), stealageStatus.getDesc());
    }
}
