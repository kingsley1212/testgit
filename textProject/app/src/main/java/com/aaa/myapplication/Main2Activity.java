package com.aaa.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    LineGraphicView tu;
    ArrayList<Double> yList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tu = (LineGraphicView) findViewById(R.id.line_graphic);

        yList = new ArrayList<>();
        yList.add( .103);
        yList.add(4.05);
        yList.add(6.60);
        yList.add(3.08);
        yList.add(4.32);
        yList.add(2.0);
        yList.add(5.0);

        ArrayList<String> xRawDatas = new ArrayList<>();
        xRawDatas.add("05-19");
        xRawDatas.add("05-20");
        xRawDatas.add("05-21");
        xRawDatas.add("05-22");
        xRawDatas.add("05-23");
        xRawDatas.add("05-24");
        xRawDatas.add("05-25");
        xRawDatas.add("05-26");
        tu.setData(yList, xRawDatas, 8, 2);
    }
}
