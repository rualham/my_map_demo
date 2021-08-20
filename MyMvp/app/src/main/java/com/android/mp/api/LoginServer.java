package com.android.mp.api;

import com.android.mp.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginServer {
    String baseUrl = "https://www.wanandroid.com/user/";

    @POST("login")
    Observable<LoginBean> login(@Query("username") String username, @Query("password") String password);
}
