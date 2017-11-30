package com.holiestar.http.loader;

import android.content.Context;

import com.holiestar.http.ApiLoader;
import com.holiestar.http.ApiManager;
import com.holiestar.http.interfaces.SaveApi;
import com.holiestar.http.model.UserInfoData;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SsuChi on 7/27/2015.
 */
public class LoaderSaveData extends ApiLoader {
    private String TAG = getClass().getSimpleName();
    private SaveApi saveApi;

    public LoaderSaveData(Context context) {
        super(context);
        init();
    }

    private void init() {

        this.saveApi = ApiManager.getRetrofit().create(SaveApi.class);
    }

    public void load(String name, String email) {
        callOnStart();
        saveApi
                .save("https://functionsexample.azurewebsites.net/api/bodyExample", getBody(name, email))
//                .save2("https://functionsexample.azurewebsites.net/api/bodyExample", getUserInfoData(name, email))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(azureResultData -> callOnSimpleLoaded(), this::callOnFailed);
    }

    private HashMap<String, Object> getBody(String name, String email) {
        return new HashMap<String, Object>() {
            {
                put("email", email);
                put("name", name.replace("'", ""));
            }
        };
    }

    private UserInfoData getUserInfoData(String name,String email){
        return new UserInfoData().setName(name).setEmail(email);
    }


}
