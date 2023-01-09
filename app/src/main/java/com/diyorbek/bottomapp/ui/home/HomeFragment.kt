package com.diyorbek.bottomapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.bottomapp.adapter.LanguageAdapter
import com.diyorbek.bottomapp.databinding.FragmentHomeBinding
import com.diyorbek.bottomapp.util.Constants

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val languageAdapter by lazy { LanguageAdapter() }
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        languageAdapter.languageList = Constants.mixLanguages().toMutableList()
        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = languageAdapter
            addItemDecoration(DividerItemDecoration(requireContext(),RecyclerView.VERTICAL))
        }
        languageAdapter.onClick = {
            showButtonSheetDialog(it)
        }
    }

    private fun showButtonSheetDialog(languages: Languages) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}