package com.exmaple.localization.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.exmaple.localization.R
import com.exmaple.localization.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch


class SecondFragment : Fragment() {

    private val viewModel: SharedMainViewModel by activityViewModels()
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            viewModel.onEvent(SharedMainViewModel.UiEvent.Increment)
        }
       lifecycleScope.launch {
            viewModel.state.collect{
                binding.textView2.text = it.counter.toString()
            }
        }
        binding.buttonGoToMain.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
       }

}