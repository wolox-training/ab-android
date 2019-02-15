package ar.com.wolox.android.example.ui.training.homePage.news

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.news_fragment_page.*
import javax.inject.Inject

/**
 * NewsFragment is used for display news
 */
class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), INewsView {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var news: MutableList<News>

    override fun layout(): Int = R.layout.news_fragment_page

    override fun init() {
        news = presenter.loadNews()

        viewManager = LinearLayoutManager(context)
        viewAdapter = RecyclerAdapter(news)
            vSwipeRefreshLayout.setOnRefreshListener {
            presenter.refreshNews()
            vSwipeRefreshLayout.setRefreshing(false)
        }

        mRecyclerView = news_recycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun addNews() {
        news.addAll(news)
        viewAdapter.notifyDataSetChanged()
    }

    override fun noNews() {
        Toast.makeText(context, getString(R.string.no_news), Toast.LENGTH_LONG).show()
    }
}