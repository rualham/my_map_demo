package com.android.mp.view;

import com.android.mp.bean.LoginBean;

/**
 * @author ham
 * @date 2021/11/16
 * @description V层接口，定义V层需要作出的动作的接口
 */
public interface LoginView {
//    请求时展示加载

    void requestLoading();

    void onSuccess(LoginBean loginBean);

    void onFail(String error);
}
