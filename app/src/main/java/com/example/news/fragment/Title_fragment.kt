package com.example.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.ARG_PARAM1
import com.example.news.ARG_PARAM2
import com.example.news.R
import com.example.news.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Title_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Title_fragment : Fragment() {

    private lateinit var binding : FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.titleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.titleRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        val adapter = ///어뎁터 만들고 옴
    }
}
