package com.gmail.neirdag.news.service

import com.gmail.neirdag.news.models.Article
import com.gmail.neirdag.news.models.ArticleResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("/v2/everything")
    fun list(@Query("q") query: String): Call<ArticleResult>
}