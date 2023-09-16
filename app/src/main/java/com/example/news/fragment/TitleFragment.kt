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
import androidx.recyclerview.widget.RecyclerView
import com.example.news.MainActivity
import com.example.news.adapter.Adapter
import com.example.news.R
import com.example.news.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.title_recycler_view)

        val articles = resources.getStringArray(R.array.news_list)
        val adapter = Adapter(requireContext(), articles) { news ->
            onArticleItemClick(news)
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
        recyclerView.adapter = adapter
        return view
    }

    private fun onArticleItemClick(news: String) {
        val activity = requireActivity() as MainActivity
        activity.showDetailFragment(news)
    }

}
