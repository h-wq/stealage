package com.xupt.read.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.read.model.Circle;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 朋友圈请求实体类
 */
@Data
public class CircleReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "book_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer bookId;

    @NotBlank
    private String comment;

    /**
     * 评分
     */
    private Integer coefficient;

    @NotEmpty
    private String location;

    public static Circle convert(CircleReq req) {
        Circle circle = new Circle();
        circle.setUserId(req.getUserId());
        circle.setBookId(req.getBookId());
        circle.setComment(req.getComment());
        circle.setCoefficient(req.getCoefficient());
        circle.setLocation(req.getLocation());
        return circle;
    }
}
