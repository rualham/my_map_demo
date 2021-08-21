package com.android.mp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.android.mp.bean.WeatherBean;
import com.android.mp.demo5.RequestPresenter5;
import com.android.mp.demo5.RequestView5;
import com.ham.mybasemvp.factory.CreatePresenter;
import com.ham.view.AbstractMvpActivitiy;

@CreatePresenter(RequestPresenter5.class)
public class SecondActivity extends AbstractMvpActivitiy<RequestView5, RequestPresenter5> implements RequestView5{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(WeatherBean result) {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        RefWatcher refWatcher = MyApp.getRefWatcher(this);//1
//        refWatcher.watch(this);
    }
}
