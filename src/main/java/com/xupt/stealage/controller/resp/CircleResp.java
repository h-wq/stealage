package com.xupt.stealage.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xupt.stealage.model.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 朋友圈返回实体类
 */
@Data
public class CircleResp {

    private Integer id;

    /**
     * 用户信息
     */
    private Integer userId;

    private Boolean isSelf;

    private String userName;

    private String userPicture;

    /**
     * 失物招領信息
     */
    private String stealageName;

    /**
     * 朋友圈内容
     */
    private String pictures;

    private String comment;

    private Integer coefficient;

    private String location;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private List<CircleCommentResp> circleCommentRespList;

    private List<CircleLikeResp> circleLikeRespList;

    @Data
    private static class CircleCommentResp {

        private Integer id;

        private Integer userId;

        private Boolean isSelf;

        private String userName;

        private String userPicture;

        private String comment;
    }

    @Data
    private static class CircleLikeResp {

        private Integer id;

        private Integer userId;

        private Boolean isSelf;

        private String userName;
    }

    public static CircleResp convert(Circle circle, List<CircleComment> circleComments, List<CircleLike> circleLikes, List<User> users, List<Stealage> stealageList, Integer userId) {

        CircleResp circleResp = new CircleResp();
        circleResp.setId(circle.getId());

        User circleUser = users.stream().filter(user -> user.getId().equals(circle.getUserId())).findFirst().get();
        circleResp.setUserId(circleUser.getId());
        circleResp.setIsSelf(userId.equals(circleUser.getId()));
        circleResp.setUserName(circleUser.getName());
        circleResp.setUserPicture(circleUser.getPicture());
        Stealage circleStealage = stealageList.stream().filter(stealage -> stealage.getId().equals(circle.getStealageId())).findFirst().get();
        circleResp.setStealageName(circleStealage.getName());
        circleResp.setPictures(circle.getPictures());
        circleResp.setComment(circle.getComment());
        circleResp.setCoefficient(circle.getCoefficient());
        circleResp.setLocation(circle.getLocation());
        circleResp.setTime(circle.getCreateTime());
        List<CircleComment> thisCircleComments = circleComments.stream().filter(circleComment -> circleComment.getCircleId().equals(circle.getId())).collect(Collectors.toList());
        List<CircleCommentResp> circleCommentRespList = thisCircleComments.stream().map(circleComment -> {
            CircleCommentResp circleCommentResp = new CircleCommentResp();
            circleCommentResp.setId(circleComment.getId());
            User circleCommentUser = users.stream().filter(user -> user.getId().equals(circleComment.getUserId())).findFirst().get();
            circleCommentResp.setUserId(circleCommentUser.getId());
            circleCommentResp.setIsSelf(userId.equals(circleCommentUser.getId()));
            circleCommentResp.setUserName(circleCommentUser.getName());
            circleCommentResp.setUserPicture(circleCommentUser.getPicture());
            circleCommentResp.setComment(circleComment.getComment());
            return circleCommentResp;
        }).collect(Collectors.toList());
        circleResp.setCircleCommentRespList(circleCommentRespList);

        List<CircleLike> thisCircleLikes= circleLikes.stream().filter(circleLike -> circleLike.getCircleId().equals(circle.getId())).collect(Collectors.toList());
        List<CircleLikeResp> circleLikeRespList = thisCircleLikes.stream().map(circleLike -> {
            CircleLikeResp circleLikeResp = new CircleLikeResp();
            circleLikeResp.setId(circleLike.getId());
            User circleLikeUser = users.stream().filter(user -> user.getId().equals(circleLike.getUserId())).findFirst().get();
            circleLikeResp.setUserId(circleLikeUser.getId());
            circleLikeResp.setIsSelf(userId.equals(circleLikeResp.getId()));
            circleLikeResp.setUserName(circleLikeUser.getName());
            return circleLikeResp;
        }).collect(Collectors.toList());
        circleResp.setCircleLikeRespList(circleLikeRespList);

        return circleResp;
    }
}
