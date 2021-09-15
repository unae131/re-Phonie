package com.unae.phonie.data.repository

import android.app.Application
import com.unae.phonie.data.model.Contact
import com.unae.phonie.data.room.dao.ContactDao
import com.unae.phonie.data.room.database.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RoomRepository {
    private val dao: ContactDao

    init {
        val db = MyDatabase.getInstance()
        dao = db.contactDao()
    }

    suspend fun insert(contact: Contact) = dao.insertContact(contact)
    suspend fun delete(contact: Contact) = dao.deleteContact(contact)
    suspend fun getAll() = dao.getAllContacts()
    suspend fun getByName(name: String) = dao.getByName(name)
    suspend fun getByNumber(number: String) = dao.getByNumber(number)
}