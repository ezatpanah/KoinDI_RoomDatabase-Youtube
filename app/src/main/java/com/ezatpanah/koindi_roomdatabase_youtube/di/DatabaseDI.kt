package com.ezatpanah.koindi_roomdatabase_youtube.di

import android.content.Context
import androidx.room.Room
import com.ezatpanah.koindi_roomdatabase_youtube.db.NoteDatabase
import com.ezatpanah.koindi_roomdatabase_youtube.utils.Constants

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, NoteDatabase::class.java, Constants.NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: NoteDatabase) = db.noteDoa()