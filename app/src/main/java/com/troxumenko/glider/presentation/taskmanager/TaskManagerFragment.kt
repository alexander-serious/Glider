package com.troxumenko.glider.presentation.taskmanager

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.troxumenko.glider.databinding.FragmentManagerTaskBinding
import com.troxumenko.glider.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskManagerFragment : BaseFragment<FragmentManagerTaskBinding>() {
    override fun creatingBinding(parent: ViewGroup?): FragmentManagerTaskBinding = inflate()

    private val viewModel: TaskManagerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            editTextTask.setText(viewModel.taskName)
            checkBoxImportant.isChecked = viewModel.taskImportance
            checkBoxImportant.jumpDrawablesToCurrentState()
            textViewDateCreated.isVisible = viewModel.task != null
            textViewDateCreated.text = "Created: ${viewModel.task?.createdDateFormatted}"
        }
    }
}