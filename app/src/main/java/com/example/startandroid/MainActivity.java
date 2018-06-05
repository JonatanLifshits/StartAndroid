package com.example.startandroid;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private MyTask mt;
    private TextView tvInfo;
    final String LOG_TAG = "My logs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }
    public void OnClick(View v){
        switch (v.getId()){
        case R.id.btnStart:
            mt = new Mytask();
            mt.execute();
            break;
            case R.id.btnGet:
                showResult();
                break;
                default:
                    break;
        }
    }

    private void showResult() {
        if (mt == null) return;
        int result = -1;
        Log.d(LOG_TAG, "Try to get result");
        result = mt.get();
        Log.d(LOG_TAG, "get returns " + result);
        Toast.makeText(this, "get returns " + result, Toast.LENGTH_LONG).show();
        class MyTask extends AsyncTask<Void, Void, Integer> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                tvInfo.setText("Begin");
                Log.d(LOG_TAG, "Begin");
            }


            @Override
            protected Integer doInBackground(Void... params) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 100500;
            }

            @Override
            protected void onPostExecute(Integer result) {
                super.onPostExecute(result);
                tvInfo.setText("End. Result = " + result);
                Log.d(LOG_TAG, "End. Result = " + result);

            }
        }
    }

    private class Mytask extends MyTask {
    }
    private void showResult() {
        if (mt == null) return;
        int result = -1;
        try {
            Log.d(LOG_TAG, "Try to get result");
            result = mt.get(1, TimeUnit.SECONDS);
            Log.d(LOG_TAG, "get returns " + result);
            Toast.makeText(this, "get returns " + result, Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            Log.d(LOG_TAG, "get timeout, result = " + result);
            e.printStackTrace();
        }
    }
}

