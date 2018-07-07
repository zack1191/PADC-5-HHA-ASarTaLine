package com.hha.heinhtetaung.asataline.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 7/7/2018.
 */

public class ShopByPopularity {

    private String shopByPupularityId;

    @SerializedName("mealShop")
    private MealShopVO mealShopVO;

    public String getShopByPupularityId() {
        return shopByPupularityId;
    }

    public void setShopByPupularityId(String shopByPupularityId) {
        this.shopByPupularityId = shopByPupularityId;
    }

    public MealShopVO getMealShopVO() {
        return mealShopVO;
    }

    public void setMealShopVO(MealShopVO mealShopVO) {
        this.mealShopVO = mealShopVO;
    }
}
