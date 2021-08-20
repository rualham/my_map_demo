package com.android.mp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.android.mp.R;

public class CustomLinear extends LinearLayout {
    public CustomLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomLinear(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_with_merge_tag, this);
    }
}
