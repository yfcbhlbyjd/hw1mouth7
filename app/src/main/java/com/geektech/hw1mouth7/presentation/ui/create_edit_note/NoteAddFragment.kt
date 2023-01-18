package com.geektech.hw1mouth7.presentation.ui.create_edit_note

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.hw1mouth7.R
import com.geektech.hw1mouth7.databinding.FragmentNoteAddBinding
import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.presentation.base.BaseFragment
import com.geektech.hw1mouth7.presentation.extension.showToast
import com.geektech.hw1mouth7.presentation.ui.notes.NoteListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteAddFragment :
    BaseFragment<FragmentNoteAddBinding, NoteAddViewModel>(R.layout.fragment_note_add) {

    override val binding by viewBinding(FragmentNoteAddBinding::bind)
    override val viewModel by viewModels<NoteAddViewModel>()
    private var note: Note? = null

    override fun initialize() {
        note = arguments?.getSerializable(NoteListFragment.EDIT_NOTE_KEY) as Note
        if (note != null) {
            binding.etTitle.setText(note!!.title)
            binding.etDescription.setText(note!!.description)
        }
    }

    override fun setupListeners() {
        binding.btnSave.setOnClickListener {
            if (note == null) {
                viewModel.createNote(
                    Note(
                        title = binding.etTitle.text.toString(),
                        description = binding.etDescription.text.toString(),
                        createAt = System.currentTimeMillis()
                    )
                )
            } else {
                viewModel.editNote(
                    Note(
                        title = binding.etTitle.toString(),
                        description = binding.etDescription.toString(),
                        createAt = System.currentTimeMillis()
                    )
                )
            }
        }
    }

    override fun setupSubscribers() {
        viewModel.createNoteState.collectState(
            onLoading = {
                //Progress Bar
            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
        viewModel.editNoteState.collectState(
            onLoading = {
                //Progress Bar
            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                findNavController().navigateUp()
                }
            )
        }
    }

