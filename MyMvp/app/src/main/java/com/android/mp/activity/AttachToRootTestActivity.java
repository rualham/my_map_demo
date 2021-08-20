package com.android.mp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.mp.R;
import com.android.mp.widget.CustomLinear;

public class AttachToRootTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_linearout);
//        setContentView(new CustomLinear(this));
        final LinearLayout outLayout = (LinearLayout) findViewById(R.id.ll);
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.item_btn, outLayout, true);
//        TextView textView = (TextView) inflater.inflate(R.layout.item_btn, outLayout, false);
//        TextView textView = (TextView) inflater.inflate(R.layout.item_btn, null, false);
//        outLayout.addView(textView);
    }
}
