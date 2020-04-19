package com.xupt.read.controller;

import com.alibaba.fastjson.JSONObject;
import com.xupt.read.common.result.JsonResult;
import com.xupt.read.controller.req.UserReq;
import com.xupt.read.model.User;
import com.xupt.read.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addUser(@RequestBody UserReq userReq) {

        // todo 图片上传处理
        Integer result = userService.addUser(UserReq.convert(userReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加用户失败！");
    }

    @RequestMapping(value = "/{id}/add_friend", method = RequestMethod.POST)
    public JsonResult addFriend(@PathVariable Integer id, @RequestParam(name = "friend_id") Integer friendId) {

        if (id < 1 || friendId < 1) {
            return JsonResult.fail(-1, "参数异常！");
        }
        User user = userService.getById(id);
        User friendUser = userService.getById(friendId);
        if (user == null || friendUser == null) {
            return JsonResult.fail(-1, "添加好友失败，无此用户或无此好友！");
        }
        List<Integer> friendIds = StringUtils.isEmpty(user.getFriendIds()) ? new ArrayList<>() : JSONObject.parseArray(user.getFriendIds(), Integer.class);
        Integer result = userService.addFriend(id, JSONObject.toJSONString(friendIds.add(friendId)));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加好友失败！");
    }
}
