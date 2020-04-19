package com.xupt.read.controller.resp;

import com.xupt.read.model.Book;
import com.xupt.read.model.Circle;
import com.xupt.read.model.CircleComment;
import com.xupt.read.model.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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

    private String bookPicture;

    /**
     * 朋友圈内容
     */
    private String comment;

    private Integer coefficient;

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
        circleResp.setBookPicture(circleBook.getPicture());
        circleResp.setComment(circle.getComment());
        circleResp.setCoefficient(circle.getCoefficient());
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
