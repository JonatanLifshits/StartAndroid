package com.example.startandroid;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
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

    }
    protected void OnResume(){
        Boolean notif = sp.getBoolean("notif",false);
        String address = sp.getString("address","");
        String text = "Notifications are" + ((notif) ? "enabled, address = " + address : "disabled");
        tvInfo.setText(text);
        super.onResume();
    }
    public boolean OnCreateOptionsMenu(Menu menu){
        MenuItem mi = menu.add(0, 1, 0 ,"Preferences");
        mi.setIntent(new Intent(this, PreferenceActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}



