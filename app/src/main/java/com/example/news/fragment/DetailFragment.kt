package com.example.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.databinding.FragmentDetailBinding
import kotlin.collections.indexOf as indexOf1


class DetailFragment : Fragment() {

    companion object {
        private const val SELECTED_NEWS = "selected_news"
    }

    private lateinit var binding: FragmentDetailBinding
    private var selectedNews: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectedNews = arguments?.getString(SELECTED_NEWS)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        // xml 파일 연결 !
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        //선택된 기사에 해당하는 내용 찾아 textview에 설정
        binding.detail.text = selectedNews?.let { getArticle(it) }.toString()

        return binding.root

    }


    private fun getArticle(title : String) : Any? {
        val titles = resources.getStringArray(R.array.news_list)
        val articles = resources.getStringArray(R.array.article_list)

        //title 에 해당하는 index 찾기
        val idx = titles.indexOf1(title)


        return if (idx != -1) {
            articles[idx]
        } else ({
            ""
        }).toString()


    }
}