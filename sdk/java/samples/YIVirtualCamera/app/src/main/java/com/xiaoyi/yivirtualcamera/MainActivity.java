package com.xiaoyi.yivirtualcamera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        // connect to Local Wifi
        String ssid1 = "Homebase";
        String key1 = "BLn2gCCoZN";

        //String ssid1 = "YDXJ_5232706_5G";
        //String key1 = "1234567890";

        WifiConfiguration wifiConfig1 = new WifiConfiguration();
        wifiConfig1.SSID = String.format("\"%s\"", ssid1);
        wifiConfig1.preSharedKey = String.format("\"%s\"", key1);

        WifiManager wifiManager1 = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        ConnectivityManager connManager1 = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager1.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        Log.d("WIFI-DISCONNECT", "disconnecting from existing wifi connection");

        //remember id
        int netId1 = wifiManager1.addNetwork(wifiConfig1);
        wifiManager1.enableNetwork(netId1, true);
        wifiManager1.removeNetwork(netId1);

        Log.d("WIFI-CONNECT", "connecting to local wifi connection");
        System.out.println("HEY1 - ");
        wifiManager1.disconnect();
        if (mWifi.getState() == NetworkInfo.State.DISCONNECTED ) {
            wifiManager1.reconnect();
            System.out.println("DONE!-1");
        }





    }

    /**
     * Called when the user taps the Send button
     */
    public void startApp(View view) {
        Intent intent = new Intent(this, SendOptions.class);
        startActivity(intent);
    }


}