package com.unae.phonie.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Phone")
public class Contact {
    @PrimaryKey(autoGenerate = true) // id 자동 할당
    private int id = 0;
    private String name;
    private String phoneNum;
    private String image = "";

    public Contact(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
