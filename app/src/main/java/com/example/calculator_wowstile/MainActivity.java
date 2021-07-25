package com.example.calculator_wowstile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String total = "";
    double v1, v2;
    String sign = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSwitchStettings (View view){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void OnClick(View view){
        Button button = (Button)view;
        String str = button.getText().toString();
        total += str;
        EditText edit = (EditText)findViewById(R.id.editTextNumber);
        edit.setText(total);
    }

    public void OnAdd(View view){
        v1 = Double.parseDouble(total);
        total = "";
        Button button = (Button)view;
        String str = button.getText().toString();
        sign = str;
        EditText edit = (EditText)findViewById(R.id.editTextNumber);
        edit.setText("");
    }

    public void OnCalculate(View view){
        EditText edit = (EditText)findViewById(R.id.editTextNumber);
        String str2 =edit.getText().toString();
        v2 = Double.parseDouble(str2);
        double result = 0;
        if (sign.equals("+")){
            result = v1 + v2;
        } else if (sign.equals("-")){
            result = v1 - v2;
        } else if (sign.equals("*")){
            result = v1 * v2;
        } else if (sign.equals("/")){
            result = v1 / v2;
        }
        edit.setText(result + "");
    }

    public void Clear(View view){
        EditText editText = (EditText)findViewById(R.id.editTextNumber);
        editText.setText("");
        total = "";
    }


}