package com.example.startandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity  {
    TextView tv;
    CheckBox chb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       tv = findViewById(R.id.textView);
       chb = findViewById(R.id.chbExtMenu);
        }
        public boolean onCreateOptionsMenu(Menu menu) {
            menu.add(0, 1, 0, "add");
            menu.add(0, 2, 0, "edit");
            menu.add(0, 3, 3, "delete");
            menu.add(1, 4, 1, "copy");
            menu.add(1, 5, 2, "paste");
            menu.add(1, 6, 4, "exit");

            return super.onCreateOptionsMenu(menu);
        }
        public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(1,chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
        }
        public  boolean onOptionsItemSelected(MenuItem item){
            StringBuilder sb = new StringBuilder();
            sb.append("Item Menu");
            sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
            sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
            sb.append("\r\n order: " + String.valueOf(item.getOrder()));
            sb.append("\r\n title: " + item.getTitle());
            tv.setText(sb.toString());

            return super.onOptionsItemSelected(item);
        }
    }






