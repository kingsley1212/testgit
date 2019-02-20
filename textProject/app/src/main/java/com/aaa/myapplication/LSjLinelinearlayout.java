package com.aaa.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */

public class LSjLinelinearlayout extends View {
    private Paint paint,paint1;
    private int width,height;
    private List<String> Xline = new ArrayList<>();
    private List<String> Yline = new ArrayList<>();
    private List<String> point = new ArrayList<>();

    public LSjLinelinearlayout(Context context) {
        super(context);
    }

    public LSjLinelinearlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LSjLinelinearlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
         width = getMeasuredWidth()-getPaddingLeft()-getPaddingRight();
         height = getMeasuredHeight()-getPaddingTop()-getPaddingBottom();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initView();
        setData();
        drawLine(canvas);

    }

    private void drawLine(Canvas canvas) {
        int offset=height/Yline.size();
        Collections.reverse(Yline);
//        canvas.drawLine(100,100,600,width,paint);
        for (int i =0;i<Yline.size();i++){
            if (i==Yline.size()-1){
                canvas.drawLine(getPaddingLeft(),offset,width,offset,paint1);
            }else {
                canvas.drawLine(getPaddingLeft(),offset,width,offset,paint);
            }
            canvas.drawText(Yline.get(i),10,offset,paint1);
         offset+=height/Yline.size();
        }
        int offset1 = 0;
        for (int i =0;i<Xline.size();i++){
            if (i==0){

                canvas.drawLine(getPaddingLeft()+offset1,height,getPaddingLeft()+offset1,height/Yline.size(),paint1);
            }else {
                canvas.drawLine(getPaddingLeft()+offset1,height,getPaddingLeft()+offset1,height/Yline.size(),paint);

            }
            canvas.drawText(Xline.get(i),getPaddingLeft()+offset1,height+getPaddingBottom(),paint1);
            canvas.drawLine(width,height,width,height/Yline.size(),paint);
//            canvas.drawLine();

         offset1+=width/Xline.size();
        }

//        canvas.drawLines();
    }

    private void initView() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(3);
        paint1.setTextSize(20);

    }

    private void setData() {
        for (int i= 0;i<5;i++){
            Xline.add(""+i+1);
            Yline.add(""+i);
            point.add(""+i);
        }
    }
}
