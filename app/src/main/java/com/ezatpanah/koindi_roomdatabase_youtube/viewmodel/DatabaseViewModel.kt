package com.ezatpanah.koindi_roomdatabase_youtube.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezatpanah.koindi_roomdatabase_youtube.db.NoteEntity
import com.ezatpanah.koindi_roomdatabase_youtube.repository.DatabaseRepository
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DatabaseRepository) : ViewModel() {

    private val _notesList = MutableLiveData<List<NoteEntity>>()
    val notesList: LiveData<List<NoteEntity>>
        get() = _notesList

    fun getAllNotes() = viewModelScope.launch {
        repository.getAllNotes().collect() {
            _notesList.postValue(it)
        }
    }

    fun saveNote(note: NoteEntity) = viewModelScope.launch {
        repository.saveNote(note)
    }


}