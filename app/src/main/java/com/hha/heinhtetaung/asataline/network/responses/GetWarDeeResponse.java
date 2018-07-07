package com.hha.heinhtetaung.asataline.network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.asataline.data.vo.WarDeeVO;

import java.util.List;

/**
 * Created by E5 on 7/7/2018.
 */

public class GetWarDeeResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    String apiVersion;

    @SerializedName("astlWarDee")
    private List<WarDeeVO> warDeeVOS;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<WarDeeVO> getWarDeeVOS() {
        return warDeeVOS;
    }

    public void setWarDeeVOS(List<WarDeeVO> warDeeVOS) {
        this.warDeeVOS = warDeeVOS;
    }
}
