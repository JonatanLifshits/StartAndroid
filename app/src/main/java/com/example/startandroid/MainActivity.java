package com.example.startandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final String TABS_TAG_1 = "Tag1";
        final String TABS_TAG_2 = "Tag2";
    }
    TabHost tabHost = getTabHost();
    TabHost.TabSpec tabSpec;

    tabSpec.setContent(tabFactory);
        tabSpec.setIndicator("Вкладка 1");
        tabHost.addTab(tabSpec);

    tabSpec = tabHost.newTabSpec(TABS_TAG_2);
        tabSpec.setContent(tabFactory);
        tabSpec.setIndicator("Вкладка 2");
        tabHost.addTab(tabSpec);

}

    TabHost.TabContentFactory tabFactory = new TabHost.TabContentFactory() {

        @Override
        public View createTabContent(String tag) {
            if (tag.equals(TABS_TAG_1)) {
                return getLayoutInflater().inflate(R.layout.tab, null);
            } else if (tag.equals(TABS_TAG_2)) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText("Это создано вручную");
                return tv;
            }
            return null;
        }
    };
}

