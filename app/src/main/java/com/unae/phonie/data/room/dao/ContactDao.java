package com.unae.phonie.data.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.unae.phonie.data.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //같은 데이터가 들어왔을 때 무시한다
    void insertContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("SELECT * from Phone")
    List<Contact> getAllContacts();

    @Query("SELECT * from Phone where name like '%' || :name || '%'")
    Contact getByName(String name);

    @Query("SELECT * from Phone where phoneNum like '%' || :phoneNum || '%'")
    Contact getByNumber(String phoneNum);
}
