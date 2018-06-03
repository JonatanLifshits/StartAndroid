package com.example.startandroid;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PrefActivity extends PreferenceActivity {
    private CheckBoxPreference chbp;
    private PreferenceCategory categ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        chbp = (CheckBoxPreference) findPreference("chbp");
        categ2 = (PreferenceCategory) findPreference("categ2");
        categ2.setEnabled(chbp.isChecked());
        chbp.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                return false;
            }
        });
    }
}
