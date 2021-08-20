package com.android.mp.callback;

import com.android.mp.bean.LoginBean;

public interface LoginCallBack {
    void onSuccess(LoginBean loginBean);
    void onFail(String error);
}
