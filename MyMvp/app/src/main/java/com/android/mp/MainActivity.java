package com.android.mp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.mp.bean.LoginBean;
import com.android.mp.databinding.MyActivityBinding;
import com.android.mp.model.ImpLoginModel;
import com.android.mp.presenter.ImpLoginPresenter;
import com.android.mp.view.LoginView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity implements LoginView {

    private MyActivityBinding binding;
    private ImpLoginPresenter impLoginPresenter;
    private Button myLoginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MyActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        impLoginPresenter = new ImpLoginPresenter(new ImpLoginModel(), this);
    }

    private void initView() {
        myLoginBt = (Button) findViewById(R.id.my_login_bt);
        myLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                impLoginPresenter.loginPresenter("这里填写申请账号", "这里填写密码");
            }
        });
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
}
