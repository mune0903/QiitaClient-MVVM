package com.github.mune0903.qiitaclient_mvvm.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mune0903.qiitaclient_mvvm.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class ArticleRecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {

    val titleView: TextView = view.findViewById(R.id.title_text_view)
    val userNameView: TextView = view.findViewById(R.id.user_name_text_view)

}