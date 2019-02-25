package ar.com.wolox.android.example.ui.training.homePage.news

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsService
import ar.com.wolox.android.example.utils.networkCallback
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val retrofitServices: RetrofitServices) : BasePresenter<INewsView>() {

    private lateinit var news: MutableList<News>
    private lateinit var pagedNews: MutableList<News>
    private var count: Int = 3
    val PAGE_SIZE = 10
    var firstTime = true

    override fun onViewAttached() {
        super.onViewAttached()
        loadNews()
    }

    fun loadNews() {
        news = mutableListOf<News>()
        retrofitServices.getService(NewsService::class.java).getNews().enqueue(
                networkCallback {
                    onResponseSuccessful {
                        news = it as MutableList<News>
                        loadPagedNews()
                    }

                    onResponseFailed { _, _ -> runIfViewAttached(Runnable { view.showError() }) }

                    onCallFailure { runIfViewAttached(Runnable { view.showError() }) }
                }
        )
    }

    fun loadPagedNews() {
        pagedNews = mutableListOf<News>()
        if (news.size < PAGE_SIZE) {
            var i = PAGE_SIZE - news.size
            var j = news.size - 1
            pagedNews.addAll(news)
            while (i > 0) {
                while (j > 0 && i > 0) {
                    pagedNews.add(news.get(j))
                    i--
                    j--
                }
                j = news.size - 1
            }
        } else {
            if (news.size == PAGE_SIZE) {
                pagedNews.addAll(news)
            } else {
                var i = news.size - PAGE_SIZE
                while (i > news.size - 1) {
                    pagedNews.add(news.get(i - 1))
                    i++
                }
            }
        }

        if (firstTime) {
            firstTime = false
            view.showNews(pagedNews)
        } else {
            view.addNews(pagedNews)
        }
    }

    fun onRefreshNews() {
        if (count>0) {
            loadPagedNews()
            count--
        } else {
            view.noNews()
        }
    }
}