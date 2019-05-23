package com.github.mune0903.qiitaclient_mvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mune0903.qiitaclient_mvvm.R
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.databinding.FragmentMainBinding
import com.github.mune0903.qiitaclient_mvvm.util.factory.ViewModelFactory


class MainFragment : Fragment(), ArticleRecyclerAdapter.OnItemClickListener {

    // viewにアクセスするやつ
    private lateinit var binding: FragmentMainBinding

    // ViewModel
    private lateinit var viewModel: MainViewModel

    private val adapter = ArticleRecyclerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        // データの処理
        viewModel.apply{
            articles.observe(this@MainFragment, Observer { articles ->
                articles?.let {
                    val articleArray = it as ArrayList<Article>
                    adapter.run {
                        userActions.clear()
                        userActions.addAll(articleArray)
                        notifyDataSetChanged()
                    }
                }
            })
            onButtonClick.observe(this@MainFragment, Observer {
                search(binding.queryEditText.text.toString())
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // databindingの設定
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)
        return binding.root
    }

    // データのfetchやUI操作に関わる処理はonViewCreatedで実行する
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerViewの設定
        setupRecyclerView()
        // ボタン処理
        onClickButton()
        // UIにMainViewModelを渡す
        binding.viewModel = viewModel
    }

    override fun onItemClick(article: Article) {
        // TODO 遷移の処理

    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MainFragment.adapter
        }
    }

    private fun onClickButton() {
        binding.searchButton.setOnClickListener {
            viewModel.search(binding.queryEditText.text.toString())
        }
    }

    companion object {

        // タグをつけることでActivityでFragmentの識別が可能になる
        val TAG: String = MainFragment::class.java.simpleName

        // Javaから呼ばれる可能性のあるコードはJvmStaticアノテーションをつける
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}