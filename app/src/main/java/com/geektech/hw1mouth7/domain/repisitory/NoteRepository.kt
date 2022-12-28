package com.geektech.hw1mouth7.domain.repisitory

import com.geektech.hw1mouth7.domain.model.Note

interface NoteRepository {

    fun addNote(note: Note)

    fun getAllNotes(): List<Note>

    fun editNote(note: Note)

    fun deleteNote(note: Note)

}