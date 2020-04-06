package com.hello.mylife.controller.resp;

import com.hello.micro.sdk.entity.food.FoodEntity;
import lombok.Builder;
import org.springframework.beans.BeanUtils;

@Builder
public class FoodResp {

    private Integer id;

    private String name;

    private String flavorIds;

    private String materialIds;

    private String pictures;

    private Integer styleId;

    public static FoodResp convert(FoodEntity foodEntity) {
        FoodResp foodResp = FoodResp.builder().build();
        BeanUtils.copyProperties(foodEntity, foodResp);
        return foodResp;
    }
}
