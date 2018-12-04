package com.xiaoyi.yivirtualcamera;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Got to the start");

        // set full screen on app
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        // hide navigation bar
       View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);
        TextView logo = (TextView) findViewById(R.id.headline);
        TextView subHeadLine = (TextView) findViewById(R.id.subHeadline);
        Typeface hoopDemo = Typeface.createFromAsset(getAssets(), "fonts/typo-hoop.demo.otf");

        logo.setTypeface(hoopDemo);
        //subHeadLine.setTypeface(hoopDemo);

    }

    /**
     * Called when the user taps the Send button
     */
    public void startApp(View view) {
        Intent intent = new Intent(this, SendOptions.class);
        startActivity(intent);
    }
}