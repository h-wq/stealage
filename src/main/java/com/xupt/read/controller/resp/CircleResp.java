package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.Circle;
import com.xupt.read.model.CircleComment;
import com.xupt.read.model.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 朋友圈返回实体类
 */
@Data
public class CircleResp {

    /**
     * 用户信息
     */
    private String userName;

    private String userPicture;

    /**
     * 书信息
     */
    private String bookName;

    /**
     * 朋友圈内容
     */
    private String pictures;

    private String comment;

    private Integer coefficient;

    private String location;

    private long time;

    private List<CircleCommentResp> circleCommentRespList;

    @Data
    private static class CircleCommentResp {

        private String userName;

        private String comment;
    }

    public static CircleResp convert(Circle circle, List<CircleComment> circleComments, List<User> users, List<Book> books) {

        CircleResp circleResp = new CircleResp();
        User circleUser = users.stream().filter(user -> user.getId().equals(circle.getUserId())).findFirst().get();
        circleResp.setUserName(circleUser.getName());
        circleResp.setUserPicture(circleUser.getPicture());
        Book circleBook = books.stream().filter(book -> book.getId().equals(circle.getBookId())).findFirst().get();
        circleResp.setBookName(circleBook.getName());
        circleResp.setPictures(circle.getPictures());
        circleResp.setComment(circle.getComment());
        circleResp.setCoefficient(circle.getCoefficient());
        circleResp.setLocation(circle.getLocation());
        circleResp.setTime(circle.getCreatedAt().getTime());
        circleComments = circleComments.stream().filter(circleComment -> circleComment.getCircleId().equals(circle.getId())).collect(Collectors.toList());
        List<CircleCommentResp> circleCommentRespList = circleComments.stream().map(circleComment -> {
            CircleCommentResp circleCommentResp = new CircleCommentResp();
            User circleCommentUser = users.stream().filter(user -> user.getId().equals(circleComment.getUserId())).findFirst().get();
            circleCommentResp.setUserName(circleCommentUser.getName());
            circleCommentResp.setComment(circleComment.getComment());
            return circleCommentResp;
        }).collect(Collectors.toList());
        circleResp.setCircleCommentRespList(circleCommentRespList);

        return circleResp;
    }
}