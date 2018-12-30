package com.xiaoyi.yivirtualcamera;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class SendOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_options);

        // connect to Local Wifi
        String ssid2 = "YDXJ_5232706_5G";
        String key2 = "1234567890";


        WifiConfiguration wifiConfig2 = new WifiConfiguration();
        wifiConfig2.SSID = String.format("\"%s\"", ssid2);
        wifiConfig2.preSharedKey = String.format("\"%s\"", key2);

        WifiManager wifiManager2 = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        ConnectivityManager connManager2 = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager2.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        Log.d("WIFI-DISCONNECT", "disconnecting from existing wifi connection");

        //remember id
        int netId2 = wifiManager2.addNetwork(wifiConfig2);
        wifiManager2.enableNetwork(netId2, true);
        wifiManager2.removeNetwork(netId2);

        Log.d("WIFI-CONNECT", "connecting to yi wifi connection");
        System.out.println("HEY1 - ");
        wifiManager2.disconnect();
        if (mWifi.getState() == NetworkInfo.State.DISCONNECTED ) {
            wifiManager2.reconnect();
            System.out.println("DONE!-2");
        }


    }

    /**
     * Called when the user taps the Email button
     */
    public void sendEmail(View view) {
        Intent intent = new Intent(this, emailRecordInput.class);
        startActivity(intent);


    }

}
