package com.example.startandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec Tabspec;

        Tabspec = tabHost.newTabSpec("tag1");
        Tabspec.setIndicator("вкладка 1");
        Tabspec.setContent(R.id.tvTab1);
        TabHost.TabSpec tabSpec = null;
        tabHost.addTab(tabSpec);
        Tabspec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Вкладка 2", getResources().getDrawable(R.drawable.tab_icon_selector));
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tag3");
        View v = getLayoutInflater().inflate(R.layout.tab_header,null);
        tabSpec.setIndicator(v);
        tabSpec.setContent(R.id.tvTab3);
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTabByTag("tag2");
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(),"tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }

}



