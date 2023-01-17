package com.geektech.hw1mouth7.presentation.ui.create_edit_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.hw1mouth7.R
import com.geektech.hw1mouth7.databinding.FragmentNoteAddBinding
import com.geektech.hw1mouth7.domain.model.Note
import com.geektech.hw1mouth7.presentation.base.BaseFragment
import com.geektech.hw1mouth7.presentation.extension.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteAddFragment :
    BaseFragment<FragmentNoteAddBinding, NoteAddViewModel>(R.layout.fragment_note_add) {

    override val binding by viewBinding(FragmentNoteAddBinding::bind)
    override val viewModel by viewModels<NoteAddViewModel>()

    override fun setupListeners() {
        binding.btnSave.setOnClickListener {
            viewModel.createNote(
                Note(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDescription.text.toString(),
                    createAt = System.currentTimeMillis()
                )
            )
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
        viewModel.editNote(
            Note(
                title = binding.etTitle.toString(),
                description = binding.etDescription.toString(),
                createAt = System.currentTimeMillis()
            )
        )
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.editNoteState.collectState(
                    onLoading = {
                        //Progress Bar
                    },
                    onError = {
                        showToast(it)
                    },
                    onSuccess = {
                        Toast.makeText(requireContext(), "Successfully edited!", Toast.LENGTH_SHORT).show()
                        findNavController().navigateUp()
                    }
                )
            }
        }
    }

}