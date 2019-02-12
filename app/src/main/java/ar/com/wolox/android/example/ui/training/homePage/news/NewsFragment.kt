package ar.com.wolox.android.example.ui.training.homePage.news

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.news_fragment_page.*

/**
 * LoginFragment is used for user to Login
 */
class NewsFragment : WolmoFragment<BasePresenter<Any>>() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun init() {
        viewManager = LinearLayoutManager(context)
        // viewAdapter = RecyclerAdapter(context)
        mRecyclerView = news_recycler.apply {
            // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    override fun layout(): Int = ar.com.wolox.android.R.layout.news_fragment_page
}