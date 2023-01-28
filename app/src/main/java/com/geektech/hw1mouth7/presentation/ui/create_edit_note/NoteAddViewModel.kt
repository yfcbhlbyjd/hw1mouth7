package com.geektech.hw1mouth7.presentation.ui.create_edit_note

import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.usecase.CreateNoteUseCase
import com.geektech.hw1mouth7.domain.usecase.EditNoteUseCase
import com.geektech.hw1mouth7.data.base.BaseViewModel
import com.geektech.hw1mouth7.domain.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteAddViewModel @Inject constructor(
    private val createNoteUseCase: com.geektech.hw1mouth7.domain.usecase.CreateNoteUseCase,
    private val editNoteUseCase: com.geektech.hw1mouth7.domain.usecase.EditNoteUseCase,
): com.geektech.hw1mouth7.data.base.BaseViewModel() {

    private val _createNoteState = MutableStateFlow<com.geektech.hw1mouth7.domain.utils.UIState<Unit>>(
        com.geektech.hw1mouth7.domain.utils.UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<com.geektech.hw1mouth7.domain.utils.UIState<Unit>>(
        com.geektech.hw1mouth7.domain.utils.UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun createNote(note: com.geektech.hw1mouth7.domain.model.Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }

    fun editNote(note: com.geektech.hw1mouth7.domain.model.Note) {
        editNoteUseCase(note).collectFlow(_editNoteState)
    }

}