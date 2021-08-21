package com.android.mp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.mp.R;
import com.android.mp.bean.WeatherBean;
import com.android.mp.demo5.RequestPresenter5;
import com.android.mp.demo5.RequestView5;
import com.android.mp.util.FieldView;
import com.android.mp.util.ViewFind;
import com.ham.mybasemvp.factory.CreatePresenter;
import com.ham.view.AbstractMvpAppCompatActivity;

/**
 * @author david
 * @date 2021/8/21  15:42
 * @description
 */

@CreatePresenter(RequestPresenter5.class)
public class GoodActivity extends AbstractMvpAppCompatActivity<RequestView5, RequestPresenter5> implements RequestView5 {

    @FieldView(R.id.tv_text)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_activity);
        ViewFind.bind(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoodActivity.this, SecondActivity.class));
            }
        });
        if (savedInstanceState != null) {
            Log.e("perfect-mvp", "MainActivity  onCreate 测试  = " + savedInstanceState.getString("test"));
        }
    }


    //点击事件
    public void request(View view) {
        Log.e("perfect-mvp", "点击事件");
        getMvpPresenter().clickRequest("101010100");
    }


    @Override
    public void requestLoading() {
        textView.setText("请求中,请稍后...");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp", "MainActivity onSaveInstanceState 测试");
        outState.putString("test", "test_save");
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        //成功
        textView.setText(result.getWeatherinfo().toString());
    }

    @Override
    public void resultFailure(String result) {
        //失败
        textView.setText(result);
    }
}
