package com.unae.phonie.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.unae.phonie.data.model.Contact

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //같은 데이터가 들어왔을 때 무시한다
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * from Phone")
    fun getAllContacts(): LiveData<List<Contact>>


    @Query("SELECT * from Phone where name like '%' || :name || '%'")
    suspend fun getByName(name: String): Contact

    @Query("SELECT * from Phone where phoneNum like '%' || :phoneNum || '%'")
    suspend fun getByNumber(phoneNum: String): Contact

    @Query("SELECT * from Phone where id = :id")
    suspend fun getById(id: Int): Contact

}