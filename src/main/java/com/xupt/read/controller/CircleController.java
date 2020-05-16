package com.xupt.read.controller;

import com.alibaba.fastjson.JSONObject;
import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.CircleReq;
import com.xupt.read.controller.resp.CircleResp;
import com.xupt.read.model.*;
import com.xupt.read.service.*;
import com.xupt.read.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    private LikesService likesService;

    @Autowired
    private BookService bookService;

    /**
     * 获取朋友圈
     */
    @RequestMapping(method = RequestMethod.GET)
    public JsonResult getCircles(@RequestParam(name = "user_id") Integer userId,
                                 @RequestParam(name = "page_num", defaultValue = "1") int pageNum,
                                 @RequestParam(name = "page_size", defaultValue = "20") int pageSize) {

        if (pageNum < 1 || pageSize < 1) {
            return JsonResult.fail(-1, "参数异常！");
        }

        User user = userService.getById(userId);
        if (user == null) {
            return JsonResult.fail(-1, "此用户不存在！");
        }
        List<Integer> friendIds = JSONObject.parseArray(user.getFriendIds(), Integer.class);
        PageResult<Circle> pageResult = circleService.getCircles(friendIds, (pageNum - 1) * pageSize, pageSize);
        List<Circle> circleList = pageResult.getItems();
        if (CollectionUtils.isEmpty(circleList)) {
            return JsonResult.success();
        }
        List<CircleComment> circleCommentList = circleCommentService.getCircleComments(circleList.stream().map(Circle::getId).collect(Collectors.toList()));
        List<CircleComment> friendCircleCommentList = circleCommentList.stream().filter(circleComment -> friendIds.contains(circleComment.getUserId()) || userId.equals(circleComment.getUserId())).collect(Collectors.toList());
        List<Likes> circleLikeList = likesService.getCircleLikes(circleList.stream().map(Circle::getId).collect(Collectors.toList()));
        List<Likes> friendCircleLikeList = circleLikeList.stream().filter(circleLike -> friendIds.contains(circleLike.getUserId()) || userId.equals(circleLike.getUserId())).collect(Collectors.toList());

        List<User> userList = userService.getByIds(Stream.concat(Stream.concat(circleList.stream().map(Circle::getUserId), friendCircleCommentList.stream().map(CircleComment::getUserId)), friendCircleLikeList.stream().map(Likes::getUserId)).distinct().collect(Collectors.toList()));
        List<Book> bookList = bookService.getByIds(circleList.stream().map(Circle::getBookId).collect(Collectors.toList()));

        List<CircleResp> circleRespList = circleList.stream().map(circle -> CircleResp.convert(circle, friendCircleCommentList, friendCircleLikeList, userList, bookList)).collect(Collectors.toList());
        PageResult<CircleResp> respPageResult = PageResult.fromPageResult(circleRespList, pageResult);
        return JsonResult.success(respPageResult);
    }

    /**
     * 发送朋友圈
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    public JsonResult addCircle(@Valid CircleReq circleReq, HttpServletRequest request) {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        List<String> paths = FileUtils.uploadFile(fileUploadPath, files);
        Integer result = circleService.addCircle(CircleReq.convert(circleReq, paths));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "发表朋友圈失败！");
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
