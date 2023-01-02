package com.geektech.hw1mouth7.di

import android.content.Context
import androidx.room.Room
import com.geektech.hw1mouth7.data.local.room.NoteDao
import com.geektech.hw1mouth7.data.local.room.NoteDatabase
import com.geektech.hw1mouth7.data.repisitory.NoteRepositoryImpl
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase = Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note"
        ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDao: NoteDao
    ): NoteRepository = NoteRepositoryImpl(noteDao)

}