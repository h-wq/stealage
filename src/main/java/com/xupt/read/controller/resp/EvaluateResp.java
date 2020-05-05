package com.xupt.read.controller.resp;

import com.xupt.read.model.Evaluate;
import com.xupt.read.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 图书评价返回实体类
 */
@Builder
@Data
public class EvaluateResp {

    /**
     * 用户信息
     */
    private UserResp userResp;

    /**
     * 评价
     */
    private String remarks;

    private long time;

    public static EvaluateResp convert(List<User> users, Evaluate evaluate) {

        User user = users.stream().filter(u -> evaluate.getUserId().equals(u.getId())).findFirst().get();
        UserResp userResp = UserResp.convert(user);
        return EvaluateResp.builder()
                .userResp(userResp)
                .time(evaluate.getCreatedAt().getTime())
                .build();
    }
}
