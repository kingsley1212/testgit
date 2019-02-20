package com.aaa.myapplication.music;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/11/16 0016.
 */

public class LinSjView extends ViewGroup {
    public LinSjView(Context context) {
        super(context);
    }

    public LinSjView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinSjView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int resultHeight =0;
        int resultWidth = 0;

        int lineHeight = 0;
        int lineWidth = 0;
        for (int i = 0,childCount=getChildCount();i<childCount;i++){

        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
