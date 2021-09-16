package com.unae.phonie.data.repository;

import android.app.Application;

import com.unae.phonie.data.room.dao.ContactDao;
import com.unae.phonie.data.room.database.MyDatabase;

import kotlinx.coroutines.CoroutineScope;

public class RoomRepository{
    private MyDatabase db;
    private ContactDao dao;

    RoomRepository(Application application){
        db = MyDatabase.getInstance(application);
        dao = db.contactDao();
    }
    

}
