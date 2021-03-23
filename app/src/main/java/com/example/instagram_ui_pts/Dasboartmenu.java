package com.example.instagram_ui_pts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.instagram_ui_pts.ui.main.DasboartmenuFragment;

public class Dasboartmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dasboartmenu_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DasboartmenuFragment.newInstance())
                    .commitNow();
        }
    }
}