package com.unae.phonie.data.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.unae.phonie.data.model.Contact;
import com.unae.phonie.data.room.dao.ContactDao;

@Database(entities = {Contact.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
    private static MyDatabase instance = null;

    public static MyDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "Phone.db").allowMainThreadQueries().build();
        }

        return instance;
    }
}
