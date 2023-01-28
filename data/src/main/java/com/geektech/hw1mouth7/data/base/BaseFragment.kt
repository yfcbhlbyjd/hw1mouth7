package com.geektech.hw1mouth7.data.base

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.geektech.hw1mouth7.domain.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB: ViewBinding, VM : ViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupRequests()
        setupSubscribers()
        setupListeners()
    }

    protected open fun initialize() {}

    protected open fun setupListeners(){}

    protected open fun setupSubscribers() {}

    protected open fun setupRequests() {}

    protected fun <T> StateFlow<com.geektech.hw1mouth7.domain.utils.UIState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (message: String) -> Unit,
        onSuccess: (data: T) -> Unit

    ){
        viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            this@collectState.collect { state ->
                when(state){

                    is com.geektech.hw1mouth7.domain.utils.UIState.Error -> onError(state.message)
                    is com.geektech.hw1mouth7.domain.utils.UIState.Loading -> onLoading()
                    is com.geektech.hw1mouth7.domain.utils.UIState.Success -> onSuccess(state.data)
                    is com.geektech.hw1mouth7.domain.utils.UIState.Empty -> {}
                }
            }
        }
     }
  }
}
