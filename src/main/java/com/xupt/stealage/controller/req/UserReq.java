package com.xupt.stealage.controller.req;

import com.xupt.stealage.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用户请求实体类
 */
@Data
public class UserReq {

    @NotBlank
    @Size(max = 10, min = 2, message = "学生昵称长度必须大于等于2或小于等于10")
    private String name;

    @NotBlank
    @Size(max = 20, min = 6, message = "学生昵称长度必须大于等于6或小于等于20")
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
