package ar.com.wolox.android.example.ui.training.homePage.news

import ar.com.wolox.android.example.model.News

/**
 * INewsView is used to show news
 */
interface INewsView {

    fun addNews(news: MutableList<News>)

    fun noNews()

    fun showNews(addedNews: MutableList<News>)

    fun showError()
}