package com.unae.phonie.ui

import android.util.Log
import androidx.lifecycle.*
import com.unae.phonie.data.model.Contact
import com.unae.phonie.data.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ContactViewModel : ViewModel() {
    private val repository = RoomRepository()

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }

    fun delete(contact: Contact) = viewModelScope.launch {
        repository.delete(contact)
    }

    fun getAll(): LiveData<List<Contact>> = repository.getAll()

    fun getById(id: Int): LiveData<Contact> = liveData<Contact> {
        emit(repository.getById(id))
    }

    fun getByName(name: String): List<Contact> = runBlocking {
        repository.getByName(name)
    }

    fun getByNumber(number: String): List<Contact> = runBlocking {
        repository.getByNumber(number)
    }

}