package com.github.mune0903.qiitaclient_mvvm.data.repository

import com.github.mune0903.qiitaclient_mvvm.data.remote.client.QiitaClient
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import com.github.mune0903.qiitaclient_mvvm.observeOnMainThread
import io.reactivex.Observable
import retrofit2.Retrofit

class QiitaRepositoryImpl(
        private val retrofit: Retrofit
) : QiitaRepository {

    private val client by lazy { retrofit.create(QiitaClient::class.java) }

    override fun searchArticle(keyword: String): Observable<List<Article>> {
        return client.search(keyword)
                .observeOnMainThread()
    }
}