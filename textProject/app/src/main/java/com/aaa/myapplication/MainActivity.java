package com.aaa.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineChart mLineChart;
    private XAxis mXAxis;
    private String tradeDate;
    private YAxis leftAxis;
    private List<String> mXList;
    private List<String> mYList;
    private List<String> point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mXList = new ArrayList<>();
        mXList.add("10发");
        mXList.add("20的");
        mXList.add("30人");
        mXList.add("40好");
        mXList.add("50就");

        initLineChart();

        mYList = new ArrayList<>();
        mYList.add("10");
        mYList.add("30");
        mYList.add("50");
        mYList.add("60");
        mYList.add("70");
        point = new ArrayList<>();
        point.add("10");
        point.add("1576.562");
        point.add("0");
        point.add("114.5");
        point.add("55.6");
        if (mXList != null && mXList.size() != 0) {
            //设置一页最大显示个数为6，超出部分就滑动
            float ratio = (float) mXList.size() / (float) 7;
            //显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
            mLineChart.zoom(ratio, 1f, 0, 0);
            //设置自定义X轴值
            mXAxis.setValueFormatter(new IndexAxisValueFormatter(mXList));
        }
//        if (mYList != null && mYList.size() != 0) {
//            //设置一页最大显示个数为6，超出部分就滑动
//            float ratio = (float) mYList.size() / (float) 5;
//            //显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
//            mLineChart.zoom(ratio, 1f, 0, 0);
//            //设置自定义X轴值
//            leftAxis.setValueFormatter(new IndexAxisValueFormatter(mYList));
//        }
        generateDataLine(mXList,mYList,point);

    }
    private void generateDataLine(List<String> mList, List<String> mList1, List<String> point) {

        ArrayList<Entry> yValues1 = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            yValues1.add(new Entry(i, Float.parseFloat(point.get(i))));
        }

        LineDataSet set;
        if (mLineChart.getData() != null && mLineChart.getData().getDataSetCount() > 0) {
            set = (LineDataSet) mLineChart.getData().getDataSetByIndex(0);
            set.setValues(yValues1);
            mLineChart.getData().notifyDataChanged();
            mLineChart.notifyDataSetChanged();
        } else {
            //设置值给图表
            set = new LineDataSet(yValues1, "");
            set.setDrawCircles(false);
            set.setCubicIntensity(0.3f);

            set.setValueTextSize(8f);
            //设置图标不显示
            set.setDrawIcons(false);
            //设置Y值使用左边Y轴的坐标值
            set.setAxisDependency(YAxis.AxisDependency.LEFT);
            //设置线的颜色
            set.setColors(Color.parseColor("#42aaf7"));
            //设置数据点圆形的颜色
            set.setCircleColor(Color.BLUE);
            //设置填充圆形中间的颜色
            set.setCircleColorHole(Color.BLUE);
            //设置折线宽度
            set.setLineWidth(1f);
            //设置折现点圆点半径
            set.setCircleRadius(4f);
            //设置十字线颜色
            //set.setHighLightColor(Color.parseColor("#47DBCC"));
            //设置显示十字线，必须显示十字线，否则MarkerView不生效
            set.setHighlightEnabled(false);
            //设置是否在数据点中间显示一个孔
            set.setDrawCircleHole(false);

            //设置填充
            //设置允许填充
            // 填充曲线下方的区域设置,黄色和透明
            set.setDrawFilled(false);
            set.setFillColor(Color.parseColor("#78c3ff"));
            set.setFillAlpha(50);
            set.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return ""+value;
                }
            });
            //设置背景渐变
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                //设置渐变
                //Drawable drawable = ContextCompat.getDrawable(this, R.drawable.line_chart_gradient);
                //set.setFillDrawable(drawable);
            } else {
                set.setFillColor(Color.BLUE);
            }

            LineData data = new LineData(set);
            //设置显示数据点的值
            data.setDrawValues(true);

            mLineChart.setData(data);
            mLineChart.invalidate();
        }
    }

    private void initLineChart() {
        mLineChart = (LineChart)findViewById(R.id.market_chart);
        //设置没有数据时显示的文本
        mLineChart.setNoDataText("没有数据");
        mLineChart.setNoDataTextColor(Color.parseColor("#666666"));
        //设置描述文本不显示
        mLineChart.getDescription().setEnabled(false);
        //设置是否显示表格背景
        mLineChart.setDrawGridBackground(false);
        //设置是否可以触摸
        mLineChart.setTouchEnabled(true);
        mLineChart.setDragDecelerationFrictionCoef(0.9f);
        //设置是否可以拖拽
        mLineChart.setDragEnabled(true);
        //设置是否可以缩放
        mLineChart.setScaleEnabled(false);
        mLineChart.setDrawGridBackground(false);
        mLineChart.setHighlightPerDragEnabled(true);
        mLineChart.setPinchZoom(true);
        //设置背景颜色
        //mLineChart.setBackgroundColor(Color.BLUE);

        //设置从X轴出来的动画时间
        //mLineChart.animateX(1500);
        //设置XY轴动画
        mLineChart.animateXY(1500, 1500, Easing.EasingOption.EaseInSine, Easing.EasingOption.EaseInSine);
        Legend legend = mLineChart.getLegend();
        //隐藏掉图例
        legend.setForm(Legend.LegendForm.NONE);

        /**
         * x轴上的设置
         */
        mXAxis = mLineChart.getXAxis();
        //设置线为虚线
        //xAxis.enableGridDashedLine(10f, 10f, 0f);
        //设置字体大小10sp
        mXAxis.setTextSize(10f);
        //设置X轴字体颜色
        // xAxis.setTextColor(Color.BLACK);
        //设置从X轴发出横线
        mXAxis.setDrawGridLines(true);
//        xAxis.setGridColor(Color.BLUE);
        //设置网格线宽度
//        mXAxis.setGridLineWidth(1);
        //设置显示X轴
        mXAxis.setDrawAxisLine(true);
        //设置X轴显示的位置
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //一个界面显示6个Lable，那么这里要设置11个
        mXAxis.setLabelCount(6);
        //设置最小间隔，防止当放大时出现重复标签
        mXAxis.setGranularity(1f);
        //设置为true当一个页面显示条目过多，X轴值隔一个显示一个
        mXAxis.setGranularityEnabled(true);
        //设置X轴的颜色
        //xAxis.setAxisLineColor(Color.RED);
        //设置X轴的宽度
        mXAxis.setAxisLineWidth(1f);
        mXAxis.setYOffset(10);

//        mXAxis.setCenterAxisLabels(true);//设置标签居中
        mLineChart.invalidate();


        /**
         * 设置Y轴左边的条目数
         */
        leftAxis = mLineChart.getAxisLeft();
        //设置从Y轴发出横向直线(网格线)
        leftAxis.setDrawGridLines(true);
//        leftAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//
//                String tradeDate = mYList.get((int) value % mYList.size());
//               return tradeDate;
//            }
//        });
        //设置网格线的颜色
        //leftAxis.setGridColor(Color.RED);
        //设置网格线宽度
//        leftAxis.setGridLineWidth(1);
        //设置Y轴最小值是0，从0开始
        leftAxis.setAxisMinimum(0f);
//        leftAxis.setAxisMaximum((float)mXList.size());
//        leftAxis.setGranularityEnabled(true);
        //设置最小间隔，防止当放大时出现重复标签
        leftAxis.setGranularity(1f);
        //如果沿着轴线的线应该被绘制，则将其设置为true,隐藏Y轴
        leftAxis.setDrawAxisLine(true);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawGridLines(true);
        leftAxis.setTextSize(10f);
        leftAxis.setDrawLabels(true);//设置Y轴的值
        //leftAxis.setTextColor(Color.RED);
        //设置左边X轴显示
        leftAxis.setEnabled(true);///////////
        //设置Y轴的颜色
//        leftAxis.setAxisLineColor(Color.RED);
        //设置Y轴的宽度
        leftAxis.setAxisLineWidth(1f);
        leftAxis.setXOffset(18);


//        leftAxis.setValueFormatter(new IndexAxisValueFormatter(mYList));
        leftAxis.setLabelCount(6, false);


        YAxis rightAxis = mLineChart.getAxisRight();
        //设置右边Y轴显示
        rightAxis.setEnabled(false);
        rightAxis.setXOffset(18);
//        rightAxis.setValueFormatter(new IndexAxisValueFormatter(mYList));
        //设置从Y轴发出横向直线(网格线)
        rightAxis.setDrawGridLines(false);
        //设置网格线的颜色
        //leftAxis.setGridColor(Color.RED);
        //设置网格线宽度
        rightAxis.setGridLineWidth(1);
        //设置Y轴最小值是0，从0开始
        rightAxis.setAxisMinimum(0f);
        rightAxis.setGranularityEnabled(true);
        //设置最小间隔，防止当放大时出现重复标签
        rightAxis.setGranularity(1f);
        //如果沿着轴线的线应该被绘制，则将其设置为true,隐藏Y轴
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setTextSize(18f);
    }
}
