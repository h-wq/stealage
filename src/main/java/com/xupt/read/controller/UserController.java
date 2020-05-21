package com.xupt.read.controller;

import com.xupt.read.common.result.JsonResult;
import com.xupt.read.controller.req.UserReq;
import com.xupt.read.controller.resp.UserResp;
import com.xupt.read.model.User;
import com.xupt.read.service.UserService;
import com.xupt.read.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    public JsonResult addUser(@Valid UserReq userReq, @RequestParam("file") MultipartFile file) {

        // 图片上传处理
        String path = FileUtils.uploadFile(fileUploadPath, file);
        User user = UserReq.convert(userReq, path);
        Integer result = userService.addUser(user);
        return result == 1 ? JsonResult.success(user.getId()) : JsonResult.fail(-1, "添加用户失败！");
    }

    /**
     * 添加好友
     */
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
        Integer result = userService.addFriend(id, friendId);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "添加好友失败！");
    }
}
