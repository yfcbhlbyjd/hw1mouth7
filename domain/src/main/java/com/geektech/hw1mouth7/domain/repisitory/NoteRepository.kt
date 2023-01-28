package com.geektech.hw1mouth7.domain.repisitory

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

}