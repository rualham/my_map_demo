package com.android.mp.demo4;

/**
 * @author david
 * @date 2021/8/21  12:14
 * @description
 */
public abstract class AbstractMvpPresenter4<V extends IMvpBaseView4> {
    private V mMvpView;
    /**
     * 绑定V层
     * @param view
     */
    public void attachMvpView(V view){
        this.mMvpView = view;
    }
    /**
     * 解除绑定V层
     */
    public void detachMvpView(){
        mMvpView = null;
    }
    /**
     * 获取V层
     * @return
     */
    public V getmMvpView() {
        return mMvpView;
    }
}
