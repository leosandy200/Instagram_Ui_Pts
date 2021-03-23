package com.example.instagram_ui_pts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        btn = (TextView) findViewById(R.id.buttonPanel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("Leosandy") &&
                        password.getText().toString().equals("wahyurismono")) {
                    Toast.makeText(MainActivity.this, "Sukses Login", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}


