package com.android.mp.model;

import com.android.mp.api.LoginServer;
import com.android.mp.bean.LoginBean;
import com.android.mp.callback.LoginCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpLoginModel implements LoginModel {
    @Override
    public void login(String usrname, String password, final LoginCallBack loginCallBack) {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(LoginServer.baseUrl)
                .build();
        //创建接口对象
        LoginServer loginServer = retrofit.create(LoginServer.class);
        Observable<LoginBean> login = loginServer.login(usrname, password);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        //获取的数值回传
                        loginCallBack.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginCallBack.onFail("net error:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
