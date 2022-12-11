package com.xupt.stealage.controller;

import com.alibaba.fastjson.JSONObject;
import com.xupt.stealage.common.result.JsonResult;
import com.xupt.stealage.common.result.PageResult;
import com.xupt.stealage.controller.req.CircleReq;
import com.xupt.stealage.controller.resp.CircleResp;
import com.xupt.stealage.model.*;
import com.xupt.stealage.service.*;
import com.xupt.stealage.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 朋友圈相关接口
 */
@RestController
@RequestMapping(value = "/circles")
@Slf4j
public class CircleController {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Autowired
    private UserService userService;

    @Autowired
    private CircleService circleService;

    @Autowired
    private CircleCommentService circleCommentService;

    @Autowired
    private CircleLikeService circleLikeService;

    @Autowired
    private StealageService stealageService;

    /**
     * 获取朋友圈
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult getCircles(@RequestParam(name = "user_id") Integer userId,
                                 @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                 @RequestParam(name = "page_size", defaultValue = "2147483647") int pageSize) {
        if (pageNum < 1 || pageSize < 1) {
            return JsonResult.fail(-1, "参数异常！");
        }

        User user = userService.getById(userId);
        if (user == null) {
            return JsonResult.fail(-1, "此用户不存在！");
        }
        List<Integer> friendIds = StringUtils.isEmpty(user.getFriendIds()) ? new ArrayList<>() : JSONObject.parseArray(user.getFriendIds(), Integer.class);
        friendIds.add(userId);

        PageResult<Circle> pageResult = circleService.getCircles(friendIds, (pageNum - 1) * pageSize, pageSize);
        List<Circle> circleList = pageResult.getItems();
        if (CollectionUtils.isEmpty(circleList)) {
            return JsonResult.success(PageResult.fromList(Collections.emptyList()));
        }
        List<CircleComment> circleCommentList = circleCommentService.getCircleComments(circleList.stream().map(Circle::getId).collect(Collectors.toList()));
        List<CircleComment> friendCircleCommentList = circleCommentList.stream().filter(circleComment -> friendIds.contains(circleComment.getUserId())).collect(Collectors.toList());
        List<CircleLike> circleLikeList = circleLikeService.getCircleLikes(circleList.stream().map(Circle::getId).collect(Collectors.toList()));
        List<CircleLike> friendCircleLikeList = circleLikeList.stream().filter(circleLike -> friendIds.contains(circleLike.getUserId())).collect(Collectors.toList());

        List<User> userList = userService.getByIds(Stream.concat(Stream.concat(circleList.stream().map(Circle::getUserId), friendCircleCommentList.stream().map(CircleComment::getUserId)), friendCircleLikeList.stream().map(CircleLike::getUserId)).distinct().collect(Collectors.toList()));
        List<Stealage> stealageList = stealageService.getByIds(circleList.stream().map(Circle::getStealageId).collect(Collectors.toList()));

        List<CircleResp> circleRespList = circleList.stream().map(circle -> CircleResp.convert(circle, friendCircleCommentList, friendCircleLikeList, userList, stealageList, userId)).collect(Collectors.toList());
        PageResult<CircleResp> respPageResult = PageResult.fromPageResult(circleRespList, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 发送朋友圈
     */
    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addCircle(@RequestBody @Valid CircleReq circleReq) {
        Integer result = circleService.addCircle(CircleReq.convert(circleReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "发表朋友圈失败！");
    }

    /**
     * 朋友圈上传图片
     */
    @RequestMapping(value = "/upload_pictures", method = RequestMethod.POST, consumes = "multipart/form-data")
    public JsonResult uploadPictures(@RequestParam(name = "file") MultipartFile file) {
        String path = FileUtils.uploadFile(fileUploadPath, file);
        return !StringUtils.isEmpty(path) ? JsonResult.success(path) : JsonResult.fail(-1, "朋友圈上传图片失败！");
    }

    /**
     * 删除朋友圈
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteCircleComment(@PathVariable Integer id) {
        Integer result = circleService.deleteCircle(id);
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "删除朋友圈失败！");
    }
}
