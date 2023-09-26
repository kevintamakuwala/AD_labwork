package com.example.lab9;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        WifiManager w = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (w.isWifiEnabled()) {
                    w.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "wifi is disabled", Toast.LENGTH_LONG).show();
                }
                else
                {
                    w.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "wifi is enabled", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}