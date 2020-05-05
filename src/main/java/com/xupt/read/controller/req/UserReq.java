package com.xupt.read.controller.req;

import com.xupt.read.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

/**
 * 用户请求实体类
 */
@Data
public class UserReq {

    @NotBlank
    private String name;

    public static User convert(UserReq req, String path) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        user.setPicture(path);
        return user;
    }
}
