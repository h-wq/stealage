package com.xupt.read.controller;

import com.alibaba.fastjson.JSONObject;
import com.xupt.read.common.result.JsonResult;
import com.xupt.read.common.result.PageResult;
import com.xupt.read.controller.req.CircleReq;
import com.xupt.read.controller.resp.CircleResp;
import com.xupt.read.model.Book;
import com.xupt.read.model.Circle;
import com.xupt.read.model.CircleComment;
import com.xupt.read.model.User;
import com.xupt.read.service.BookService;
import com.xupt.read.service.CircleCommentService;
import com.xupt.read.service.CircleService;
import com.xupt.read.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/circles")
@Slf4j
public class CircleController {

    @Autowired
    private UserService userService;

    @Autowired
    private CircleService circleService;

    @Autowired
    private CircleCommentService circleCommentService;

    @Autowired
    private BookService bookService;

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
        List<CircleComment> friendCircleCommentList = circleCommentList.stream().filter(circleComment -> friendIds.contains(circleComment.getUserId())).collect(Collectors.toList());
        List<User> userList = userService.getByIds(Stream.concat(circleList.stream().map(Circle::getUserId), circleCommentList.stream().map(CircleComment::getUserId)).distinct().collect(Collectors.toList()));
        List<Book> bookList = bookService.getByIds(circleList.stream().map(Circle::getBookId).collect(Collectors.toList()));

        List<CircleResp> circleRespList = circleList.stream().map(circle -> CircleResp.convert(circle, friendCircleCommentList, userList, bookList)).collect(Collectors.toList());
        PageResult<CircleResp> respPageResult = PageResult.fromPageResult(circleRespList, pageResult);
        return JsonResult.success(respPageResult);
    }

    @RequestMapping(method = RequestMethod.POST)
    public JsonResult addCircle(@RequestBody @Valid CircleReq circleReq) {

        Integer result = circleService.addCircle(CircleReq.convert(circleReq));
        return result == 1 ? JsonResult.success() : JsonResult.fail(-1, "发表朋友圈失败！");
    }
}
