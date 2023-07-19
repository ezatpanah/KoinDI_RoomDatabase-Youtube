package com.ezatpanah.koindi_roomdatabase_youtube.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1,exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){
    abstract  fun noteDoa():NoteDao
}