package com.geektech.hw1mouth7.presentation.ui.notes

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.hw1mouth7.R
import com.geektech.hw1mouth7.databinding.FragmentNoteListBinding
import com.geektech.hw1mouth7.databinding.ItemNotesBinding
import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.presentation.base.BaseFragment
import com.geektech.hw1mouth7.presentation.extension.showToast
import com.geektech.hw1mouth7.presentation.ui.notes.adapter.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment: BaseFragment<FragmentNoteListBinding, NoteListViewModel>(R.layout.fragment_note_list) {

    override val binding by viewBinding(FragmentNoteListBinding::bind)
    private val _binding :ItemNotesBinding by viewBinding(ItemNotesBinding::bind)
    override val viewModel by viewModels<NoteListViewModel>()
    private val noteAdapter by lazy { NoteAdapter(this::onItemClick) }

    override fun initialize() {
        with(binding.rvNotes) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = noteAdapter
        }
    }

    override fun setupRequests() {
        viewModel.getAllNotes()

    }

    override fun setupSubscribers() {
        viewModel.getAllNotesState.collectState(
            onError = {
                showToast(it)
                binding.progress.isVisible = false
            },
            onLoading = {
                binding.progress.isVisible = true

            },
            onSuccess = {
                noteAdapter.submitList(it)
                binding.progress.isVisible = false
            }
        )
        viewModel.deleteNoteState.collectState(
            onError = {
                showToast(it)
                binding.progress.isVisible = false
            },
            onLoading = {
                binding.progress.isVisible = true

            },
            onSuccess = {
                showToast(R.string.status_deleted)
            }
        )
    }

    private fun onItemClick(note: Note) {
        val bundle = Bundle()
        bundle.putSerializable(EDIT_NOTE_KEY, note)
        findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment, bundle)
    }
    override fun setupListeners() {
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment)
            
        viewModel.deleteNote(
            _binding.itemTitle.setText(""),
            _binding.itemDescription.setText(""),
            _binding.itemCreatedAt.setText("")
        )
        }
    }

    companion object {
        const val EDIT_NOTE_KEY = "value"
    }

}

