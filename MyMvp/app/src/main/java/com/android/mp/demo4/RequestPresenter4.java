package com.android.mp.demo4;

import android.os.Handler;
import android.util.Log;

import com.android.mp.bean.WeatherBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author david
 * @date 2021/8/21  12:23
 * @description
 */
public class RequestPresenter4 extends AbstractMvpPresenter4<RequestView4> {
    private final RequestMode4 mRequestMode;
    public RequestPresenter4() {
        this.mRequestMode = new RequestMode4();
    }
    public void clickRequest(final String cityId){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRequestMode.request(cityId, new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        //判断View是否为空
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(t));
                        }
                    }
                });
            }
        },1000);
    }
    public void interruptHttp(){
        mRequestMode.interruptHttp();
    }
}
