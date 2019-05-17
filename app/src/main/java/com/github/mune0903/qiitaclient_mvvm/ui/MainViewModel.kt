package com.github.mune0903.qiitaclient_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.data.repository.QiitaRepository
import com.github.mune0903.qiitaclient_mvvm.util.extension.observeOnMainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

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
        qiitaRepository.searchArticle(keyword)
            .observeOnMainThread()
            .subscribe({
                _articles.value = it
            }, {
                Timber.e(it)
            }).addTo(disposable)
    }

    // FragmentのDetach後に呼ばれる
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}