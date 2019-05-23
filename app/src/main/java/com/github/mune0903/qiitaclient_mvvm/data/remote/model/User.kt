package com.github.mune0903.qiitaclient_mvvm.data.remote.model

import java.io.Serializable

data class User(
        val id: String,
        val name: String,
        val profile_image_url: String
) : Serializable