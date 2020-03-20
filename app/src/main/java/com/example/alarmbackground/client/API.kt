package com.example.alarmbackground.client

import com.example.alarmbackground.model.Posts
import com.example.alarmbackground.model.Test
import io.reactivex.Single
import retrofit2.http.GET

interface API {
    @GET("posts")
    fun getListPosts() : Single<List<Posts>>

    @GET("l26tg")
    fun getNotify() : Single<Test>

}