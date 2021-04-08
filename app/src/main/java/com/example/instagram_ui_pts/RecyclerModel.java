package com.example.instagram_ui_pts;

public class RecyclerModel {

//    Menambahkan variabel yang diperlukan dalam recyclerView
    private String image, name, desc;

    public RecyclerModel() {

    }

//    Membuat constructor sesuai dengan variabel sudah dituliskan
    public RecyclerModel(String image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

//    Membuat getter dan setter
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
