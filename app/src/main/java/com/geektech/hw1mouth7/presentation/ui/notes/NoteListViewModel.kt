package com.geektech.hw1mouth7.presentation.ui.notes


import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.domain.usecase.DeleteNoteUseCase
import com.geektech.hw1mouth7.domain.usecase.GetAllNotesUseCase
import com.geektech.hw1mouth7.presentation.base.BaseViewModel
import com.geektech.hw1mouth7.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesState)
    }

    fun deleteNote(note: Note)  {
        deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }
}

