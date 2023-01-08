package com.xupt.stealage.controller.req;

import com.xupt.stealage.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 用户请求实体类
 */
@Data
public class UserReq {

    private String name;

    private String password;

    @NotBlank(message = "学生头像必须上传")
    private String picture;

    public static User convert(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return user;
    }
}
