package ar.com.wolox.android.example.ui.training.homePage.news

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import kotlinx.android.synthetic.main.fragment_news_page.*
import javax.inject.Inject

/**
 * NewsFragment is used for display news
 */
class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), INewsView {

    @Inject internal lateinit var toastFactory: ToastFactory
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var news: MutableList<News>

    override fun layout(): Int = R.layout.fragment_news_page

    override fun init() {
        vSwipeRefreshLayout.setOnRefreshListener {
            presenter.onRefreshNews()
            vSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun addNews(addedNews: MutableList<News>) {
        news.addAll(addedNews)
        viewAdapter.notifyDataSetChanged()
    }

    override fun showNews(addedNews: MutableList<News>) {
        news = mutableListOf<News>()
        news.addAll(addedNews)
        viewAdapter = RecyclerAdapter(news)
        val viewManager = LinearLayoutManager(context)
        recyclerView = news_recycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        recyclerView.layoutManager = viewManager

        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(10, viewManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                presenter.loadNews()
            }
        })
    }

    override fun noNews() {
        toastFactory.show(R.string.news_fragment_no_more_news_to_show)
    }
    override fun showError() {
        toastFactory.show(R.string.unknown_error)
    }
}