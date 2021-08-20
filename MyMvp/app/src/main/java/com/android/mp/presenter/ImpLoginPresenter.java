package com.android.mp.presenter;

import com.android.mp.bean.LoginBean;
import com.android.mp.callback.LoginCallBack;
import com.android.mp.model.ImpLoginModel;
import com.android.mp.view.LoginView;

public class ImpLoginPresenter implements LoginPresenter, LoginCallBack {
    private ImpLoginModel impLoginModel;
    private LoginView loginView;

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
}
