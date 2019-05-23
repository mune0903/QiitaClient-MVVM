package com.github.mune0903.qiitaclient_mvvm.ui.article


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mune0903.qiitaclient_mvvm.R
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private lateinit var binding: FragmentArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            bundle.getSerializable(ARTICLE) as Article
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        binding = FragmentArticleBinding.bind(view)
        return binding.root
    }

    companion object {

        private const val ARTICLE = "article"

        val TAG: String = ArticleFragment::class.java.simpleName

        fun newInstance(article: Article) = ArticleFragment().apply {
            Bundle().apply {
                putSerializable(ARTICLE, article)
            }
        }
    }
}
