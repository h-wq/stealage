package com.xupt.read.controller.req;

import com.xupt.read.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 用户请求实体类
 */
@Data
public class UserReq {

    @NotBlank
    private String name;

    @NotBlank
    private String picture;

    public static User convert(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return user;
    }
}
