package ar.com.wolox.android.example.ui.training.homePage.news

import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<INewsView>() {

    private lateinit var news: MutableList<News>
    private var count: Int = 3

    fun loadNews(): MutableList<News> {
        news = mutableListOf<News>()
        val fakeNews = News("Hola", "\"An ex-counterintelligence agent who defected to Iran in 2013 helped the Islamic Republic in \\\"targeting her former fellow agents\\\" and exposed a Defense Department program considered one of the crown jewels of U.S. intelligence, according to an explosive indictment unsealed", "data:image/jpeg;base64,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")
        val fakeNews1 = News("Bootstrap", "\"An ex-counterintelligence agent who defected to Iran in 2013 helped the Islamic Republic in \\\"targeting her former fellow agents\\\" and exposed a Defense Department program considered one of the crown jewels of U.S. intelligence, according to an explosive indictment unsealed", "data:image/jpeg;base64,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")
        val fakeNews2 = News("Wolox", "\"An ex-counterintelligence agent who defected to Iran in 2013 helped the Islamic Republic in \\\"targeting her former fellow agents\\\" and exposed a Defense Department program considered one of the crown jewels of U.S. intelligence, according to an explosive indictment unsealed", "data:image/jpeg;base64,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")
        val fakeNews3 = News("Android", "\"An ex-counterintelligence agent who defected to Iran in 2013 helped the Islamic Republic in \\\"targeting her former fellow agents\\\" and exposed a Defense Department program considered one of the crown jewels of U.S. intelligence, according to an explosive indictment unsealed", "data:image/jpeg;base64,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")
        news.add(fakeNews)
        news.add(fakeNews1)
        news.add(fakeNews2)
        news.add(fakeNews3)
        return news
    }

    fun refreshNews() {
        if (count>0) {
            view.addNews()
            count--
        } else {
            view.noNews()
        }
    }
}