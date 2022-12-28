package com.geektech.hw1mouth7.domain.usecase

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository

class DeleteNoteUseCase (private val noteRepository: NoteRepository) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}