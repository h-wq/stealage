package com.xupt.stealage.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.stealage.model.CircleComment;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 朋友圈评论请求实体类
 */
@Data
public class CircleCommentReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "circle_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer circleId;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    @NotBlank
    private String comment;

    public static CircleComment convert(CircleCommentReq req) {
        CircleComment circleComment = new CircleComment();
        BeanUtils.copyProperties(req, circleComment);
        circleComment.setCreateTime(new Date());
        circleComment.setUpdateTime(new Date());
        return circleComment;
    }
}
