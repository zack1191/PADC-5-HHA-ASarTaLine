package com.hha.heinhtetaung.asataline.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by E5 on 7/7/2018.
 */

public class WarDeeVO {
    @SerializedName("warDeeId")
    private String warDeeId;

    private String name;

    private List<String> images;

    @SerializedName("generalTaste")
    private List<GeneralTasetVO> generalTasteVOS;

    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedForVOS;

    private int priceRangeMin;

    private int priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<MatchWarDeeVO> matchWarDeeVOS;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistanceVOS;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularity> shopByPopularityVOS;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<GeneralTasetVO> getGeneralTasteVOS() {
        return generalTasteVOS;
    }

    public void setGeneralTasteVOS(List<GeneralTasetVO> generalTasteVOS) {
        this.generalTasteVOS = generalTasteVOS;
    }

    public List<SuitedForVO> getSuitedForVOS() {
        return suitedForVOS;
    }

    public void setSuitedForVOS(List<SuitedForVO> suitedForVOS) {
        this.suitedForVOS = suitedForVOS;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public List<MatchWarDeeVO> getMatchWarDeeVOS() {
        return matchWarDeeVOS;
    }

    public void setMatchWarDeeVOS(List<MatchWarDeeVO> matchWarDeeVOS) {
        this.matchWarDeeVOS = matchWarDeeVOS;
    }

    public List<ShopByDistanceVO> getShopByDistanceVOS() {
        return shopByDistanceVOS;
    }

    public void setShopByDistanceVOS(List<ShopByDistanceVO> shopByDistanceVOS) {
        this.shopByDistanceVOS = shopByDistanceVOS;
    }

    public List<ShopByPopularity> getShopByPopularityVOS() {
        return shopByPopularityVOS;
    }

    public void setShopByPopularityVOS(List<ShopByPopularity> shopByPopularityVOS) {
        this.shopByPopularityVOS = shopByPopularityVOS;
    }
}
