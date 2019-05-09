package com.github.mune0903.qiitaclient_mvvm.data.remote.client

import com.github.mune0903.qiitaclient_mvvm.data.remote.SEARCH
import com.github.mune0903.qiitaclient_mvvm.data.remote.model.Article
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaClient {

    @GET(SEARCH)
    fun search(@Query("query") query: String): Observable<List<Article>>
}