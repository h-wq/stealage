package com.xupt.read.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.read.model.Circle;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 朋友圈请求实体类
 */
@Data
public class CircleReq {

    @NotNull
    @Min(value = 1)
    private Integer user_id;

    @NotNull
    @Min(value = 1)
    private Integer book_id;

    @NotBlank
    private String comment;

    /**
     * 评分
     */
    private Integer coefficient;

    @NotEmpty
    private String location;

    public static Circle convert(CircleReq req, List<String> paths) {
        Circle circle = new Circle();
        circle.setUserId(req.getUser_id());
        circle.setBookId(req.getBook_id());
        circle.setComment(req.getComment());
        circle.setCoefficient(req.getCoefficient());
        circle.setLocation(req.getLocation());
        circle.setPictures(paths.stream().map(String::valueOf).collect(Collectors.joining(",")));
        return circle;
    }
}
