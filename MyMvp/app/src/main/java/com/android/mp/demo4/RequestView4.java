package com.android.mp.demo4;

import com.android.mp.bean.WeatherBean;

/**
 * @author david
 * @date 2021/8/21  12:26
 * @description
 */
public interface RequestView4 extends IMvpBaseView4 {
    void requestLoading();

    void resultSuccess(WeatherBean result);

    void resultFailure(String result);
}
