package com.android.mp.view;

import com.android.mp.bean.LoginBean;

public interface LoginView {
    void onSuccess(LoginBean loginBean);

    void onFail(String error);
}
