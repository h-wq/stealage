package com.xupt.stealage.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.stealage.model.StealageProcessContent;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 失物招领处理内容请求实体类
 */
@Data
public class StealageProcessContentReq {

    @NotNull
    @JsonProperty(value = "stealage_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer stealageId;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    @NotBlank
    private String content;

    public static StealageProcessContent convert(StealageProcessContentReq req) {
        StealageProcessContent stealageProcessContent = new StealageProcessContent();
        BeanUtils.copyProperties(req, stealageProcessContent);
        stealageProcessContent.setCreateTime(new Date());
        stealageProcessContent.setUpdateTime(new Date());
        return stealageProcessContent;
    }
}
