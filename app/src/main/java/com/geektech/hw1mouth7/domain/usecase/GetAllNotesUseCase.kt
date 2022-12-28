package com.geektech.hw1mouth7.domain.usecase

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository

class GetAllNotesUseCase (private val noteRepository: NoteRepository) {
    fun getAllNotes() = noteRepository.getAllNotes()
}