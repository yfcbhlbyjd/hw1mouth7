package com.geektech.hw1mouth7.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.hw1mouth7.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}