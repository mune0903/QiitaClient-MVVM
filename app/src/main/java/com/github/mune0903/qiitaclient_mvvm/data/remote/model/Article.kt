package com.github.mune0903.qiitaclient_mvvm.data.remote.model

import java.io.Serializable

data class Article(
        val id: String,
        val title: String,
        val url: String,
        val user: User
) : Serializable