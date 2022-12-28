package com.geektech.hw1mouth7.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.geektech.hw1mouth7.data.local.room.model.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteEntity>

    @Update
    fun editNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)
}