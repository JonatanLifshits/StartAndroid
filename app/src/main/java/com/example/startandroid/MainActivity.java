package com.example.startandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView myText;
    private Button myBtn;
    private CheckBox myCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myText =  findViewById(R.id.myText);
        myBtn = findViewById(R.id.myBtn);
        myCheckBox = findViewById(R.id.myCheckBox);

        myText.setText("Hello World!");
        myBtn.setText("My Button");
        myBtn.setEnabled(false);
        myCheckBox.setChecked(true);
    }
}
