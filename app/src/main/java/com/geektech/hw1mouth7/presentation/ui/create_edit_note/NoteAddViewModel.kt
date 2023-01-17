package com.geektech.hw1mouth7.presentation.ui.create_edit_note

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.usecase.CreateNoteUseCase
import com.geektech.hw1mouth7.domain.usecase.EditNoteUseCase
import com.geektech.hw1mouth7.presentation.base.BaseViewModel
import com.geektech.hw1mouth7.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteAddViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
): BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun createNote(note: Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }

    fun editNote(note: Note) {
        editNoteUseCase(note).collectFlow(_editNoteState)
    }

}