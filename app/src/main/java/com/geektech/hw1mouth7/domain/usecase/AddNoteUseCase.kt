package com.geektech.hw1mouth7.domain.usecase

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository

class AddNoteUseCase (private val noteRepository: NoteRepository) {
    fun addNote(note: Note) = noteRepository.addNote(note)
}