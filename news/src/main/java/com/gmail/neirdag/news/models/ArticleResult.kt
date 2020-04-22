package com.gmail.neirdag.news.models

data class ArticleResult(
    val status:String,
    val totalResults:Int,
    val articles:List<Article>
) {

}