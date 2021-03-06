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

    private val _onButtonClick = MutableLiveData<Unit>()

    val onButtonClick: LiveData<Unit> = _onButtonClick

    fun search(keyword: String) {
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

    fun onButtonClick() {
        // TODO ボタン押した処理
        _onButtonClick.value = Unit
    }

    // FragmentのDetach後に呼ばれる
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}