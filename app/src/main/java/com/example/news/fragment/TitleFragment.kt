package com.example.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.adapter.Adapter
import com.example.news.R
import com.example.news.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    private lateinit var binding : FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.titleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.titleRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        val adapter = Adapter(requireContext(), resources.getStringArray(R.array.news_list))

        adapter.setOnItemClickListener(object  : Adapter.OnItemClickListener {
            override fun onItemClick(article: String) {

            }
        })
        binding.titleRecyclerView.adapter = adapter
    }
}
