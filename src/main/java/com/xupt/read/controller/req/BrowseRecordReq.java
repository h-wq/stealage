package com.xupt.read.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xupt.read.model.BrowseRecord;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户浏览记录请求实体类
 */
@Data
public class BrowseRecordReq {

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    @NotNull
    @Min(value = 1)
    @JsonProperty(value = "book_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer bookId;

    public static BrowseRecord convert(BrowseRecordReq req) {
        BrowseRecord browseRecord = new BrowseRecord();
        BeanUtils.copyProperties(req, browseRecord);
        return browseRecord;
    }
}
