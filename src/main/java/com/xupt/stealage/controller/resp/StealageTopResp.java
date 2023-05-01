package com.xupt.stealage.controller.resp;

import com.xupt.stealage.model.User;
import lombok.Builder;
import lombok.Data;

/**
 * 失物招领top返回实体类
 */
@Builder
@Data
public class StealageTopResp {

    private UserResp userResp;;

    private int count;

    public static StealageTopResp convert(User user, int count) {
        return StealageTopResp.builder()
                .userResp(UserResp.convert(user))
                .count(count)
                .build();
    }
}
