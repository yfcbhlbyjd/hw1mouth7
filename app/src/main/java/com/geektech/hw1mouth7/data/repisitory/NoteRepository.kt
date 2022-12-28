package com.geektech.hw1mouth7.data.repisitory

import com.geektech.hw1mouth7.data.local.room.NoteDao
import com.geektech.hw1mouth7.data.mappers.toNote
import com.geektech.hw1mouth7.data.mappers.toNoteEntity
import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override fun addNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())

    }

    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes().map { it.toNote() }

    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.toNoteEntity())

    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())

    }
}