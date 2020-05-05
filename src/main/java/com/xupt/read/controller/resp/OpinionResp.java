package com.xupt.read.controller.resp;

import com.xupt.read.model.Opinion;
import com.xupt.read.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 意见反馈返回实体类
 */
@Builder
@Data
public class OpinionResp {

    private UserResp userResp;

    private String content;

    private Boolean isSolve;

    private long time;

    public static OpinionResp convert(List<User> users, Opinion opinion) {

        User user = users.stream().filter(u -> opinion.getUserId().equals(u.getId())).findFirst().get();
        UserResp userResp = UserResp.convert(user);
        return OpinionResp.builder()
                .userResp(userResp)
                .content(opinion.getContent())
                .isSolve(opinion.getIsSolve())
                .time(opinion.getCreatedAt().getTime())
                .build();
    }
}