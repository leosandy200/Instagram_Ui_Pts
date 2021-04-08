package com.example.instagram_ui_pts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<RecyclerModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

//        Menambahkan recyclerView dari activity_data.xml
        recyclerView = findViewById(R.id.recycler_view);

//        Menambahkan data ke recyclerView
        addData();
    }
    
    private void addData() {
//        Membuat arrayList
        arrayList = new ArrayList<>();

//        Menambahkan data ke arrayList sesuai dengan parameter di RecyclerModel
        arrayList.add(new RecyclerModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.pinimg.com%2F736x%2F19%2F53%2F6c%2F19536cea8a72cf631b006449a3e05c96.jpg&f=1&nofb=1", "Aries", "(21 Maret – 19 April) "));
        arrayList.add(new RecyclerModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fthumb7.shutterstock.com%2Fdisplay_pic_with_logo%2F1243096%2F357293564%2Fstock-vector-taurus-astrology-zodiac-sign-vector-zodiac-hand-drawn-style-357293564.jpg&f=1&nofb=1", "Taurus", "(20 April – 20 Mei)"));
        arrayList.add(new RecyclerModel("https://pixfeeds.com/images/astrology/gemini/1200-520944083-neon-gemini-sign.jpg", "Gemini", "(21 Mei – 20 Juni)"));
        arrayList.add(new RecyclerModel("https://st2.depositphotos.com/3804071/5373/v/450/depositphotos_53734497-stock-illustration-neon-signs-of-the-zodiac.jpg", "Cencer", "(21 Juni – 22 Juli)"));
        arrayList.add(new RecyclerModel("https://pixfeeds.com/images/astrology/leo/1200-520890387-zodiac-leo-sign.jpg", "Leo", " (23 Juli – 22 Agustus) "));
        arrayList.add(new RecyclerModel("https://thumb1.shutterstock.com/image-photo/stock-vector-virgo-zodiac-sign-horoscope-symbol-vector-illustration-450w-627363809.jpg", "Virgo", "(23 Agustus – 22 September) "));
        arrayList.add(new RecyclerModel("https://st2.depositphotos.com/2864463/12075/v/450/depositphotos_120755924-stock-illustration-vintage-thin-line-libra-zodiac.jpg", "Libra", " (23 September – 22 Oktober)"));
        arrayList.add(new RecyclerModel("https://pixfeeds.com/images/astrology/scorpio/1280-592674174-vintage-thin-line-scorpio-zodiac-sign-label.jpg", "Scorpio", "(23 Oktober – 21 November)"));
        arrayList.add(new RecyclerModel("https://clipground.com/images/sagittarius-logo-7.jpg", "Sagitarius", "(22 November – 21 Desember)"));
        arrayList.add(new RecyclerModel("https://image.shutterstock.com/image-vector/capricorn-zodiac-sign-constellation-on-450w-778707433.jpg", "Capricon", "(22 Desember – 19 Januari)"));
        arrayList.add(new RecyclerModel("https://media.istockphoto.com/vectors/aquarius-zodiac-sign-horoscope-symbol-vector-illustration-vector-id681362486?k=6&m=681362486&s=170667a&w=0&h=U3Sqc2o2j_c07z3F2Y9Rmh7KGcw84jgYyAyhQnOWOSs=", "Aquarius", "(20 Januari – 18 Februari)"));
        arrayList.add(new RecyclerModel("https://www.deccanherald.com/sites/dh/files/articleimages/2020/10/23/pisces-1590963265-905693-1603395001.jpg", "Pisces", "(19 Februari – 20 Maret)"));



//        Menginialisasi adapter sesuai dengan constructor di RecyclerAdapter
        adapter = new RecyclerAdapter(this, arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        Method onClick, mengatur apa yang terjadi apabila data di recyclerView ter-klik
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Menampilkan toast nama berdasarkan data yang dipilih
                Toast.makeText(getApplicationContext(), arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}