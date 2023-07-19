package com.ezatpanah.koindi_roomdatabase_youtube.repository

import com.ezatpanah.koindi_roomdatabase_youtube.db.NoteDao
import com.ezatpanah.koindi_roomdatabase_youtube.db.NoteEntity

class DatabaseRepository(private val dao: NoteDao) {

    suspend fun saveNote(note: NoteEntity) = dao.saveNote(note)
    fun getAllNotes() = dao.getAllNotes()

}