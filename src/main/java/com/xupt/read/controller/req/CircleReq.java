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

    public static Circle convert(CircleReq req, List<String> paths) {
        Circle circle = new Circle();
        BeanUtils.copyProperties(req, circle);
        circle.setPictures(paths.stream().map(String::valueOf).collect(Collectors.joining(",")));
        return circle;
    }
}
