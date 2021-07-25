package com.example.calculator_wowstile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    private static final String NAME_SHARED_PREFERENCE = "LOGIN";
    private static final String appTheme = "APP_THEME";

    private static final int Calculator_wowStile = 0;
    private static final int Calculator_secondTheme = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(codeStyleToStyleId(getCodeStyle()));
        setContentView(R.layout.activity_settings);
        initRadioButoons();
    }

    public void onSwitchStettings (View view){
        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private int codeStyleToStyle(int code) {
        return codeStyleToStyleId(getCodeStyle());
    }

    private int getCodeStyle(){
        SharedPreferences preferences =  getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        return preferences.getInt(appTheme, R.style.Calculator_wowStile);
    }

    private void setAppTheme(int codeStyle){
        SharedPreferences preferences =  getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        preferences.edit().putInt(appTheme, codeStyle).apply();
    }

    private int codeStyleToStyleId(int codeStyle){
        switch (codeStyle){
            case Calculator_wowStile:
                return R.style.Calculator_secondTheme;
            default:
                return R.style.Calculator_wowStile;
        }
    }

    private void initRadioButoons() {
        findViewById(R.id.radioButton_wowStyle).setOnClickListener(v -> {
            setAppTheme(Calculator_wowStile);
            recreate();
        });
        findViewById(R.id.radioButton2_secondTheme).setOnClickListener(v -> {
            setAppTheme(Calculator_secondTheme);
            recreate();
        });
    }


}