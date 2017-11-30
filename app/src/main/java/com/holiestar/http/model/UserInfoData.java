package com.holiestar.http.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tony1 on 8/29/2016.
 */
public class UserInfoData implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;

    public String getName() {
        return name;
    }

    public UserInfoData setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfoData setEmail(String email) {
        this.email = email;
        return this;
    }
}
