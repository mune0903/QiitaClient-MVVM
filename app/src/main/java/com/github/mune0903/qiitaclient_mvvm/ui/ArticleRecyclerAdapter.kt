package com.github.mune0903.qiitaclient_mvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mune0903.qiitaclient_mvvm.R
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.databinding.ItemArticleBinding

class ArticleRecyclerAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<ArticleRecyclerAdapter.ViewHolder>() {

    val userActions = ArrayList<Article>()

    override fun getItemCount(): Int = userActions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        val binding = ItemArticleBinding.bind(v)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = userActions[position]
        holder.binding.article = article
        holder.binding.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(article: Article)
    }

    class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)
}
