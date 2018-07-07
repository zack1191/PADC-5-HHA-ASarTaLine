package com.hha.heinhtetaung.asataline.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 7/7/2018.
 */

public class ShopByDistanceVO {

    private String shopByDistanceId;

    @SerializedName("mealShop")
    private MealShopVO mealShopVO;

    private float distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public void setShopByDistanceId(String shopByDistanceId) {
        this.shopByDistanceId = shopByDistanceId;
    }

    public MealShopVO getMealShopVO() {
        return mealShopVO;
    }

    public void setMealShopVO(MealShopVO mealShopVO) {
        this.mealShopVO = mealShopVO;
    }

    public float getDistanceInFeet() {
        return distanceInFeet;
    }

    public void setDistanceInFeet(float distanceInFeet) {
        this.distanceInFeet = distanceInFeet;
    }
}
