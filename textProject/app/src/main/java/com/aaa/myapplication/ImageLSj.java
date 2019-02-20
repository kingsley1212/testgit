package com.aaa.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/10/27 0027.
 */

@SuppressLint("AppCompatCustomView")
public class ImageLSj extends ImageView {
    public ImageLSj(Context context) {
        super(context);
    }

    public ImageLSj(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageLSj(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
