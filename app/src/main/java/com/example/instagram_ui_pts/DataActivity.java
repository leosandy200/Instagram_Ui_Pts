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
        arrayList.add(new RecyclerModel("https://www.w3schools.com/w3css/img_lights.jpg", "Leo", "asdkljaskldjaskldjl"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet", "kuenya seh"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet 1", "kuenya seh"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet 2", "kuenya seh"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet 3", "kuenya seh"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet 4", "kuenya seh"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet 5", "kuenya seh"));
        arrayList.add(new RecyclerModel("https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/02/red-velvet-cake-slice-2.jpg", "Red Velvet 6", "kuenya seh"));

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