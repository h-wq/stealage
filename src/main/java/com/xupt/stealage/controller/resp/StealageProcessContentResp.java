package com.xupt.stealage.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xupt.stealage.model.StealageProcessContent;
import com.xupt.stealage.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 失物招领处理内容返回实体类
 */
@Builder
@Data
public class StealageProcessContentResp {

    private int id;

    private int stealageId;

    private boolean isSelf;

    private UserResp userResp;;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public static StealageProcessContentResp convert(StealageProcessContent stealageProcessContent, int stealageUserId, User contentUser) {
        return StealageProcessContentResp.builder()
                .id(stealageProcessContent.getId())
                .stealageId(stealageProcessContent.getStealageId())
                .isSelf(stealageUserId == contentUser.getId())
                .userResp(UserResp.convert(contentUser))
                .content(stealageProcessContent.getContent())
                .createTime(stealageProcessContent.getCreateTime())
                .build();
    }
}
