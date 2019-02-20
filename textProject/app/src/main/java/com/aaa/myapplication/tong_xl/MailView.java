package com.aaa.myapplication.tong_xl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.aaa.myapplication.R;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public class MailView extends View {
    public static String[] b = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};
    private Paint paint;
    private TextView dialog;
    private int position = -1;
    private LinneClick linneClick;
    public void setLinneClick(LinneClick linneClick) {
        this.linneClick = linneClick;
    }

    public interface LinneClick{
         void onItemClick(String s,int s1);
    }

    public MailView(Context context) {
        super(context);
        initView();
    }

    public MailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setTextView(TextView textView) {
        this.dialog = textView;
    }

    private void initView() {
        paint = new Paint();
        paint.setTextSize(30);
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(33, 65, 98));
        paint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int with = getWidth();
        int heighy = getHeight();
        int singleH = heighy / b.length;
        for (int i = 0; i < b.length; i++) {
            paint.setColor(Color.rgb(33, 65, 98));
            // paint.setColor(Color.WHITE);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            paint.setTextSize(30);
            float postX = with / 2 - paint.measureText(b[i]) / 2;
            float postY = singleH * i + singleH;
            if (i == position) {
                paint.setColor(Color.parseColor("#3399ff"));
                paint.setFakeBoldText(true);
            }
            canvas.drawText(b[i], postX, postY, paint);
//            恢复默认设置
            paint.reset();
        }
        canvas.drawText("你好啊", 20, 20, paint);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        float s1 = event.getY() / getHeight() * b.length;
        int s = (int) (event.getY() / getHeight() * b.length);
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                setBackground(new ColorDrawable(0x00000000));
                position = -1;
                invalidate();
                if (dialog != null) {
                    dialog.setVisibility(GONE);
                }
                break;
            default:
                setBackgroundResource(R.drawable.sidebar_background);
                if (s >= 0 && s < b.length) {

                    linneClick.onItemClick(b[s],s);
                    if (dialog != null) {
                        dialog.setVisibility(VISIBLE);
                        dialog.setText(b[s]);

                    }
                    position = s;
                    invalidate();
                }
                break;

        }
        return true;
    }
}
