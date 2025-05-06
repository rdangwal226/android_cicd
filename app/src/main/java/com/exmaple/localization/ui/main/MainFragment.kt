package com.exmaple.localization.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.exmaple.localization.R
import com.exmaple.localization.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: SharedMainViewModel by activityViewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            viewModel.onEvent(SharedMainViewModel.UiEvent.Increment)
        }
        lifecycleScope.launch {
            viewModel.state.collect{
                binding.textView.text = it.counter.toString()
            }
        }
        binding.buttonGoToSecond.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}