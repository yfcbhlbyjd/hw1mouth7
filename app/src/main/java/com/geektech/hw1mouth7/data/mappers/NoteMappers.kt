package com.geektech.hw1mouth7.data.mappers

import com.geektech.hw1mouth7.data.model.NoteEntity
import com.geektech.hw1mouth7.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createAt
)