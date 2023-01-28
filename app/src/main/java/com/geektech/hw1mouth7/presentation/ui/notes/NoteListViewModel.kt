package com.geektech.hw1mouth7.presentation.ui.notes


import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.usecase.DeleteNoteUseCase
import com.geektech.hw1mouth7.domain.usecase.GetAllNotesUseCase
import com.geektech.hw1mouth7.data.base.BaseViewModel
import com.geektech.hw1mouth7.domain.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNotesUseCase: com.geektech.hw1mouth7.domain.usecase.GetAllNotesUseCase,
    private val deleteNoteUseCase: com.geektech.hw1mouth7.domain.usecase.DeleteNoteUseCase
) : com.geektech.hw1mouth7.data.base.BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<com.geektech.hw1mouth7.domain.utils.UIState<List<com.geektech.hw1mouth7.domain.model.Note>>>(
        com.geektech.hw1mouth7.domain.utils.UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<com.geektech.hw1mouth7.domain.utils.UIState<Unit>>(
        com.geektech.hw1mouth7.domain.utils.UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesState)
    }

    fun deleteNote(note: com.geektech.hw1mouth7.domain.model.Note)  {
        deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }
}

