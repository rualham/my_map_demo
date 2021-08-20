package com.android.mp.model;

import com.android.mp.callback.LoginCallBack;

public interface LoginModel {
    void login(String usrname, String password, LoginCallBack loginCallBack);
}
