package com.xupt.stealage.controller;

import com.alibaba.fastjson.JSONObject;
import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.controller.req.UserReq;
import com.xupt.stealage.controller.resp.UserResp;
import com.xupt.stealage.model.User;
import com.xupt.stealage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Autowired
    private UserService userService;

    /**
     * 查找好友
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult query(@RequestParam(name = "name") String name) {
        List<UserResp> users = userService.getByName(name).stream().map(UserResp::convert).collect(Collectors.toList());
        return JsonResult.success(users);
    }

    /**
     * 添加用户
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addUser(@RequestBody @Valid UserReq userReq) {
        // 图片上传处理
//        String path = FileUtils.uploadFile(fileUploadPath, file);
        User user = UserReq.convert(userReq);
        Integer result = userService.addUser(user);
        return result == 1 ? JsonResult.success(user.getId()) : JsonResult.fail(-1, "添加用户失败！");
    }

    /**
     * 添加好友
     */
    @RequestMapping(value = "/add_friend", method = RequestMethod.GET)
    public JsonResult addFriend(@RequestParam(name = "id") Integer id, @RequestParam(name = "friend_id") Integer friendId) {
        if (id < 1 || friendId < 1) {
            return JsonResult.fail(-1, "参数异常！");
        }
        User user = userService.getById(id);
        User friendUser = userService.getById(friendId);
        if (user == null || friendUser == null) {
            return JsonResult.fail(-1, "添加好友失败，无此用户或无此好友！");
        }
        if (!StringUtils.isEmpty(user.getFriendIds()) && JSONObject.parseArray(user.getFriendIds(), Integer.class).contains(friendId)) {
            return JsonResult.fail(-1, "添加好友失败，此用户已经是好友，无需添加！");
        }
        Integer result = userService.addFriend(id, friendId);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加好友失败！");
    }
}
