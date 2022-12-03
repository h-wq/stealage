package com.xupt.stealage.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.stealage.model.CircleLike;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 朋友圈点赞请求实体类
 */
@Data
public class CircleLikeReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "circle_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer circleId;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    public static CircleLike convert(CircleLikeReq req) {
        CircleLike circleLike = new CircleLike();
        BeanUtils.copyProperties(req, circleLike);
        return circleLike;
    }
}
