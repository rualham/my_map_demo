package com.android.mp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.mp.databinding.MyActivityBinding;
import com.android.mp.model.ImpLoginModel;
import com.android.mp.presenter.ImpLoginPresenter;

/**
 * @author david
 * @date 2021/8/21  10:41
 * @description
 */
public class MyDemoMvpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = MyActivityBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        initView();
//        impLoginPresenter = new ImpLoginPresenter(new ImpLoginModel(), this);
    }
}
