package com.github.mune0903.qiitaclient_mvvm.data.repository

import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import io.reactivex.Observable


interface QiitaRepository {
    fun searchArticle(keyword: String): Observable<List<Article>>
}