package com.hha.heinhtetaung.asataline.network.api;

import com.hha.heinhtetaung.asataline.network.responses.GetWarDeeResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 7/7/2018.
 */

public interface ASarTaLineApi {
    @FormUrlEncoded
    @POST("GetWarDee.php")
    io.reactivex.Observable<GetWarDeeResponse> getWarDeeItems(@Field("access_token") String access_token);
}
