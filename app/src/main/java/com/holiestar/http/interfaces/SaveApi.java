package com.holiestar.http.interfaces;

import com.holiestar.http.model.UserInfoData;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface SaveApi {

    @POST
    Flowable<UserInfoData> save(
            @Url String url,
            @Body Map<String, Object> params
    );

    @POST
    Flowable<UserInfoData> save2(
            @Url String url,
            @Body UserInfoData userInfoData
    );


    @POST
    Flowable<UserInfoData> wrongEample(
            @Url String url,
            @FieldMap Map<String, String> params
    );



}
