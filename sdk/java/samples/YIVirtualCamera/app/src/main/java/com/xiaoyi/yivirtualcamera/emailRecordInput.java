package com.xiaoyi.yivirtualcamera;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class emailRecordInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_record_input);
        TextView step1 = (TextView) findViewById(R.id.step1);
        TextView step2 = (TextView) findViewById(R.id.step2);
        TextView step3 = (TextView) findViewById(R.id.step3);
        TextView preview = (TextView) findViewById(R.id.preview);
        TextView rollcam = (TextView) findViewById(R.id.rollcam);
        Typeface hoopDemoBold = Typeface.createFromAsset(getAssets(), "fonts/typo-hoop.demo-bold.otf");

        step1.setTypeface(hoopDemoBold);
        step2.setTypeface(hoopDemoBold);
        step3.setTypeface(hoopDemoBold);
        rollcam.setTypeface(hoopDemoBold);
    }
}
