package com.xupt.stealage.controller.resp;

import com.xupt.stealage.model.User;
import lombok.Builder;
import lombok.Data;

/**
 * 用户返回实体类
 */
@Builder
@Data
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
