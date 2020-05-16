package com.xupt.read.controller.resp;

import com.xupt.read.model.*;
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

    private List<CircleLikeResp> circleLikeRespList;

    @Data
    private static class CircleCommentResp {

        private Integer id;

        private String userName;

        private String comment;
    }

    @Data
    private static class CircleLikeResp {

        private Integer id;

        private String userName;
    }

    public static CircleResp convert(Circle circle, List<CircleComment> circleComments, List<Likes> circleLikes, List<User> users, List<Book> books) {

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
            circleCommentResp.setId(circleComment.getId());
            User circleCommentUser = users.stream().filter(user -> user.getId().equals(circleComment.getUserId())).findFirst().get();
            circleCommentResp.setUserName(circleCommentUser.getName());
            circleCommentResp.setComment(circleComment.getComment());
            return circleCommentResp;
        }).collect(Collectors.toList());
        circleResp.setCircleCommentRespList(circleCommentRespList);

        List<CircleLikeResp> circleLikeRespList = circleLikes.stream().map(circleLike -> {
            CircleLikeResp circleLikeResp = new CircleLikeResp();
            circleLikeResp.setId(circleLike.getId());
            User circleLikeUser = users.stream().filter(user -> user.getId().equals(circleLike.getUserId())).findFirst().get();
            circleLikeResp.setUserName(circleLikeUser.getName());
            return circleLikeResp;
        }).collect(Collectors.toList());
        circleResp.setCircleLikeRespList(circleLikeRespList);

        return circleResp;
    }
}
