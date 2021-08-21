package com.android.mp.demo5;

import com.android.mp.bean.WeatherBean;
import com.ham.view.BaseMvpView;

/**
 * @date 2017/11/17
 * @description
 */
public interface RequestView5 extends BaseMvpView {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
