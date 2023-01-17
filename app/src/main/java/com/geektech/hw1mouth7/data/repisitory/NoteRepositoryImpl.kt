package com.geektech.hw1mouth7.data.repisitory

import com.geektech.hw1mouth7.data.local.room.NoteDao
import com.geektech.hw1mouth7.data.mappers.toNote
import com.geektech.hw1mouth7.data.mappers.toNoteEntity
import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository
import com.geektech.hw1mouth7.data.local.room.base.BaseRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ): NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map{ it.toNote()}
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }
}