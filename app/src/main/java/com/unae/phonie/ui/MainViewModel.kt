package com.unae.phonie.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.unae.phonie.data.model.Contact
import com.unae.phonie.data.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val repository = RoomRepository()

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }

    fun delete(contact: Contact) = viewModelScope.launch {
        repository.delete(contact)
    }

    fun getAll(): LiveData<List<Contact>> = repository.getAll()

    fun getByName(name: String) = viewModelScope.launch {
        repository.getByName(name)
    }

    fun getByNumber(number: String) = viewModelScope.launch {
        repository.getByNumber(number)
    }

}