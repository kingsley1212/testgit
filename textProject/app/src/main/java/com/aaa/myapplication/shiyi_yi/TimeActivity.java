package com.aaa.myapplication.shiyi_yi;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.aaa.myapplication.R;

public class TimeActivity extends AppCompatActivity {
    private TextView time;
    private int anInt = 10;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    time.setEnabled(true);
                    time.setText("点击发送");
                    break;
                case 4:
                    time.setEnabled(false);
                    time.setText("已发送" + anInt);
                    break;
                case 5:
                    break;
                default:
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        time = (TextView) findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                countTime();
                anInt = 10;
                startTime();
            }
        });
    }

    private void countTime() {
        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setEnabled(false);
                time.setText("已发送" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                time.setEnabled(true);
                time.setText("点击发送");
            }
        }.start();
    }

    public void startTime() {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                anInt--;
                if (anInt <= 0) {
                    handler.sendEmptyMessage(0);
                } else {
                    handler.sendEmptyMessage(4);
                    handler.postDelayed(this, 1000);
                }
            }
        };
        new Thread(runnable).start();
    }
}
