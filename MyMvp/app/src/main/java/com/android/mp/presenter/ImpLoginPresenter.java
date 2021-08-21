package com.android.mp.presenter;

import com.android.mp.bean.LoginBean;
import com.android.mp.callback.LoginCallBack;
import com.android.mp.model.ImpLoginModel;
import com.android.mp.view.LoginView;

public class ImpLoginPresenter implements LoginPresenter, LoginCallBack {
    private ImpLoginModel impLoginModel;
    private LoginView loginView;

    //推荐，v层与p层解耦
    public ImpLoginPresenter(ImpLoginModel impLoginModel) {
        this.impLoginModel = impLoginModel;
    }

    //此种写法会内存泄漏，不推荐。
    public ImpLoginPresenter(ImpLoginModel impLoginModel, LoginView loginView) {
        this.impLoginModel = impLoginModel;
        this.loginView = loginView;
    }

    @Override
    public void loginPresenter(String username, String password) {
        if (impLoginModel != null) {
            impLoginModel.login(username, password, this);
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginView != null) {
            loginView.onSuccess(loginBean);
        }
    }

    @Override
    public void onFail(String error) {
        if (loginView != null) {
            loginView.onFail(error);
        }
    }

    /**
     * 绑定
     *
     * @param view
     */
    public void attach(LoginView view) {
        this.loginView = view;
    }

    /**
     * 解除绑定
     */
    public void detach() {
        loginView = null;
    }

    /**
     * 取消网络请求
     */
    public void interruptHttp() {
//        impLoginModel.interruptHttp();
    }
}
