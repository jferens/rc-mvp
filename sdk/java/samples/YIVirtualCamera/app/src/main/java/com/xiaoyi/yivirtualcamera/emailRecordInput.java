package com.xiaoyi.yivirtualcamera;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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

        //get the spinner from the xml.
        Spinner dropdown1 = (Spinner) findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        String[] items1 = new String[]{"5 seconds", "10 seconds", "30 seconds"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        //set the spinners adapter to the previously created one.
        dropdown1.setAdapter(adapter1);

        //get the spinner from the xml.
        Spinner dropdown2 = (Spinner) findViewById(R.id.spinner2);
        //create a list of items for the spinner.
        String[] items2 = new String[]{"30 seconds", "1 minute", "5 minutes"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        //set the spinners adapter to the previously created one.
        dropdown2.setAdapter(adapter2);
    }
}
