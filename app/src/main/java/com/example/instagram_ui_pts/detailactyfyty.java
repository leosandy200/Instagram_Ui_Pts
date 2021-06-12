package com.example.instagram_ui_pts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class detailactyfyty extends AppCompatActivity {
// untuk mendlarasikan
    Bundle bundle;
    String name;
    String detail;
    String image;

    TextView txt_name, txt_detail;
    ImageView img_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactyfyty);
// untuk meneri,a data dari acttiviy lain
        bundle = getIntent().getExtras();
        if (bundle != null) {
            txt_name = findViewById(R.id.name_detail);
            img_image = findViewById(R.id.image_detail);
            txt_detail = findViewById(R.id.detail_detail);

            name = bundle.getString("name");
            image = bundle.getString("image");
            detail = bundle.getString("detail");
            Log.d("image", image);
        }
        txt_name.setText(name);
        txt_detail.setText(detail);

//        Load url dari url dengan library Picasso
        Picasso.get().load(image).placeholder(R.drawable.astrology).error(R.drawable.astrology).into(img_image);
    }
}