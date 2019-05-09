package com.github.mune0903.qiitaclient_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.data.repository.QiitaRepository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
        private val qiitaRepository: QiitaRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    // apiから取ってきたデータは_articlesに流す
    private val _articles = MutableLiveData<List<Article>>()
    // Fragmentでarticlesを監視する
    val articles: LiveData<List<Article>> = _articles

    fun search(keyword: String) {
        // TODO
        // Fragmentから呼ぶ
        // repositoryのsearchArticleメソッドを呼ぶ
    }

    // FragmentのDetach後に呼ばれる
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}