package com.ezatpanah.koindi_roomdatabase_youtube.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ezatpanah.koindi_roomdatabase_youtube.utils.Constants.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var noteId :Int =0,
    @ColumnInfo(name = "note_title")
    var noteTitle:String="",
    @ColumnInfo(name = "note_desc")
    var noteDesc : String=""
)