package com.example.startandroid;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    final String LOG_TAG = "MyLogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    public void onClickStart(View v){
        startService(new Intent(this, MyService.class));
    }
    protected void onClickStop(View v) {
        stopService(new Intent(this, MyService.class));
    }
}

