package com.aaa.myapplication.tong_xl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaa.myapplication.R;

public class mail_list_Activity extends AppCompatActivity {
    private TextView dianji_tv, dianji_tv1;
    private MailView mailView;
    private ImageView imagev;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list_);
        dianji_tv = (TextView) findViewById(R.id.dianji_tv);
        dianji_tv1 = (TextView) findViewById(R.id.dianji_tv1);
        mailView = (MailView) findViewById(R.id.mailView);
        imagev = (ImageView) findViewById(R.id.imagev);

        mailView.setTextView(dianji_tv);
        mailView.setLinneClick(new MailView.LinneClick() {
            @Override
            public void onItemClick(String s, int s1) {
                dianji_tv1.setText(s);
//                position = s1;
//                DisplayMetrics d = new DisplayMetrics();
//                getWindowManager().getDefaultDisplay().getMetrics(d);
//                int with = d.widthPixels;
//                int height = d.heightPixels;
//                int with1 = with - mailView.getWidth() - 20;
//                int height1 = height / 27 * position;
//                dianji_tv.setLayoutParams(new LinearLayout.LayoutParams(with1, height1));
            }
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.main_icon_banner);
        imagev.setImageDrawable(new filletView(bitmap));
        dianji_tv1.setBackground(new filletView(bitmap));
    }
}
