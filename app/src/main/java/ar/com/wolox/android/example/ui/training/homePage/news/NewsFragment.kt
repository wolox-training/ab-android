package ar.com.wolox.android.example.ui.training.homePage.news

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news_page.*
import javax.inject.Inject

/**
 * NewsFragment is used for display news
 */
class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), INewsView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var news: MutableList<News>

    override fun layout(): Int = R.layout.fragment_news_page

    override fun init() {
        vSwipeRefreshLayout.setOnRefreshListener {
            presenter.refreshNews()
            vSwipeRefreshLayout.setRefreshing(false)
        }

        recyclerView = news_recycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun addNews(addedNews: MutableList<News>) {
        news.addAll(addedNews)
        viewAdapter.notifyDataSetChanged()
    }

    override fun initializer() {
        news = mutableListOf<News>()
        viewManager = LinearLayoutManager(context)
        viewAdapter = RecyclerAdapter(news)
    }

    override fun noNews() {
        Toast.makeText(context, getString(R.string.news_fragment_no_more_news_to_show), Toast.LENGTH_LONG).show()
    }
}