package com.example.startandroid;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tvInfo;
    private SharedPreferences sp;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        tvInfo = findViewById(R.id.tvInfo);
        sp = PreferenceManager.getDefaultSharedPreferences(this);

    }
    protected void OnResume(){
       String listValues = sp.getString("list" ,"не выбрано");
       tvInfo.setText("Значение списка - " + listValues);
        super.onResume();
    }
    public boolean OnCreateOptionsMenu(Menu menu){
        MenuItem mi = menu.add(0, 1, 0 ,"Preferences");
        mi.setIntent(new Intent(this, PreferenceActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}



