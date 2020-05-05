package com.xupt.read.controller.resp;

import com.xupt.read.model.User;
import lombok.Builder;

/**
 * 用户返回实体类
 */
@Builder
public class UserResp {

    private Integer id;

    private String name;

    private String picture;

    public static UserResp convert(User user) {

        return UserResp.builder()
                .id(user.getId())
                .name(user.getName())
                .picture(user.getPicture())
                .build();
    }
}
