package com.android.mp.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.mp.R;
import com.android.mp.bean.LoginBean;
import com.android.mp.databinding.MyActivityBinding;
import com.android.mp.model.ImpLoginModel;
import com.android.mp.presenter.ImpLoginPresenter;
import com.android.mp.view.LoginView;

public class MainActivity extends Activity implements LoginView {

    private MyActivityBinding binding;
    private ImpLoginPresenter impLoginPresenter;
    private Button myLoginBt;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        binding = MyActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        impLoginPresenter = new ImpLoginPresenter(new ImpLoginModel(), this);
        impLoginPresenter.attach(this);
    }

    private void initView() {
        myLoginBt = (Button) findViewById(R.id.my_login_bt);
        myLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                impLoginPresenter.loginPresenter("这里填写申请账号", "这里填写密码");
                startActivity(new Intent(MainActivity.this,GoodActivity.class));
            }
        });
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void onSuccess(LoginBean loginBean) {
//        Toast.makeText(this, loginBean.getData().getNickname(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        impLoginPresenter.detach();
        impLoginPresenter.interruptHttp();
    }


    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }
}
