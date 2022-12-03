package com.xupt.stealage.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.stealage.model.Opinion;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 意见反馈请求实体类
 */
@Data
public class OpinionReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    @NotBlank
    private String content;

    public static Opinion convert(OpinionReq req) {
        Opinion opinion = new Opinion();
        BeanUtils.copyProperties(req, opinion);
        return opinion;
    }
}
