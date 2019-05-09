package com.github.mune0903.qiitaclient_mvvm.util.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.github.mune0903.qiitaclient_mvvm.data.remote.BASE_URL
import com.github.mune0903.qiitaclient_mvvm.data.repository.QiitaRepository
import com.github.mune0903.qiitaclient_mvvm.data.repository.QiitaRepositoryImpl
import com.github.mune0903.qiitaclient_mvvm.ui.MainViewModel
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


class ViewModelFactory : ViewModelProvider.Factory {

    // retrofitのインスタンス生成はコストが高いので本当はシングルトンにした方が良い
    private fun createRetrofit(): Retrofit {
        val okHttp = OkHttpClient()
                .newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        val moshi = Moshi.Builder().build()

        return Retrofit.Builder()
                .client(okHttp)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val retrofit = createRetrofit()

        val repository: QiitaRepository = QiitaRepositoryImpl(retrofit)
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
    }
}