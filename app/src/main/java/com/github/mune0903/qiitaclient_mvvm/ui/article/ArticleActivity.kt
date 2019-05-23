package com.github.mune0903.qiitaclient_mvvm.ui.article

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mune0903.qiitaclient_mvvm.R
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val article = intent.getSerializableExtra(ARTICLE) as Article

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ArticleFragment.newInstance(article), ArticleFragment.TAG)
            .commit()
    }

    companion object {

        private const val ARTICLE = "article"

        fun createIntent(activity: Activity, article: Article) = Intent(activity, ArticleActivity::class.java).apply {
            putExtra(ARTICLE, article)
        }
    }
}
