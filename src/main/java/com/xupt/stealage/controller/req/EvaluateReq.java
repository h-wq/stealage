package com.xupt.stealage.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.stealage.model.Evaluate;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 失物招领评论请求实体类
 */
@Data
public class EvaluateReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "stealage_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer stealageId;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    /**
     * 评论
     */
    @NotBlank
    private String remarks;

    public static Evaluate convert(EvaluateReq req) {
        Evaluate evaluate = new Evaluate();
        BeanUtils.copyProperties(req, evaluate);
        return evaluate;
    }
}
