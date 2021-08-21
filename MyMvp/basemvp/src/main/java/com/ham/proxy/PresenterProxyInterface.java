package com.ham.proxy;

import com.ham.mybasemvp.factory.PresenterMvpFactory;
import com.ham.presenter.BaseMvpPresenter;
import com.ham.view.BaseMvpView;

/**
 * @author david
 * @date 2021/8/21  14:59
 * @description
 */

public interface PresenterProxyInterface<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(PresenterMvpFactory<V,P> presenterFactory);
    /**
     * 获取Presenter的工厂类
     * @return 返回PresenterMvpFactory类型
     */
    PresenterMvpFactory<V,P> getPresenterFactory();
    /**
     * 获取创建的Presenter
     * @return 指定类型的Presenter
     */
    P getMvpPresenter();
}
