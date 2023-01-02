package com.geektech.hw1mouth7.domain.usecase

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.repisitory.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}