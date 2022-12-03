package com.xupt.stealage.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.stealage.data.StealageStatus;
import com.xupt.stealage.model.Stealage;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 失物招领请求实体类
 */
@Data
public class StealageReq {

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    @NotNull
    @JsonProperty(value = "is_recruitment", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isRecruitment;

    @NotBlank
    private String describe;

    @NotBlank
    private String place;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date stealageTime;

    @NotBlank
    @Min(value = 1)
    @JsonProperty(value = "type_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer typeId;

    public static Stealage convert(StealageReq req, String path) {
        Stealage stealage = new Stealage();
        BeanUtils.copyProperties(req, stealage);
        stealage.setPicture(path);
        stealage.setStatus(StealageStatus.PENDING.name());
        stealage.setCreateTime(new Date());
        stealage.setUpdateTime(new Date());
        return stealage;
    }
}
