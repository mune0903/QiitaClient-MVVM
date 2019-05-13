package com.github.mune0903.qiitaclient_mvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.mune0903.qiitaclient_mvvm.R
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.databinding.FragmentMainBinding

class ArticleRecyclerAdapter(var listener: MainViewModel.OnItemClickListener?) : RecyclerView.Adapter<ArticleRecyclerAdapter.ViewHolder>() {
    //TODO
    val userActions = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val v = LayoutInflater.from(context)
                .inflate(R.layout.item_article, parent, false)
        val binding = DataBindingUtil.bind<FragmentMainBinding>(v)
        return ViewHolder(binding)
    }

    override fun OnBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userActions[position]
        listener
    }

    class ViewHolder(val binding: FragmentMainBinding?) : RecyclerView.ViewHolder(binding?.root)
}
