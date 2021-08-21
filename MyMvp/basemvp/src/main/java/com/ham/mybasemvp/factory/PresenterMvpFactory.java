package com.ham.mybasemvp.factory;

import com.ham.presenter.BaseMvpPresenter;
import com.ham.view.BaseMvpView;

/**
 * @author david
 * @date 2021/8/21  14:53
 * @description
 */

public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
