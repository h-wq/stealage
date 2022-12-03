package com.xupt.stealage.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xupt.stealage.model.Evaluate;
import com.xupt.stealage.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 失物招领评论返回实体类
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public static EvaluateResp convert(List<User> users, Evaluate evaluate) {
        User user = users.stream().filter(u -> evaluate.getUserId().equals(u.getId())).findFirst().orElse(new User());
        UserResp userResp = UserResp.convert(user);
        return EvaluateResp.builder()
                .userResp(userResp)
                .remarks(evaluate.getRemarks())
                .time(evaluate.getCreateTime())
                .build();
    }
}
