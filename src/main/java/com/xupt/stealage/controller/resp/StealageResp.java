package com.xupt.stealage.controller.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xupt.stealage.data.StealageStatus;
import com.xupt.stealage.model.Stealage;
import com.xupt.stealage.model.StealageType;
import com.xupt.stealage.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 失物招领返回实体类
 */
@Builder
@Data
public class StealageResp {

    private int id;

    private String name;

    private UserResp userResp;;

    private boolean isRecruitment;

    private String describe;

    private String place;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date stealageTime;

    private String typeName;

    private String picture;

    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public static StealageResp convert(Stealage stealage, List<StealageType> stealageTypes, List<User> users) {
        StealageType type = stealageTypes.stream().filter(stealageType -> stealage.getTypeId().equals(stealageType.getId())).findFirst().orElse(null);
        User user = users.stream().filter(u -> stealage.getUserId().equals(u.getId())).findFirst().get();
        return buildStealageResp(stealage, type, user);
    }

    private static StealageResp buildStealageResp(Stealage stealage, StealageType type, User user) {
        return StealageResp.builder()
                .id(stealage.getId())
                .name(stealage.getName())
                .userResp(UserResp.convert(user))
                .isRecruitment(stealage.getIsRecruitment())
                .describe(stealage.getDescribe())
                .place(stealage.getPlace())
                .stealageTime(stealage.getStealageTime())
                .typeName(type == null ? "" : type.getName())
                .picture(stealage.getPicture())
                .status(StealageStatus.valueOf(stealage.getStatus()).getDesc())
                .createTime(stealage.getCreateTime())
                .build();
    }
}
