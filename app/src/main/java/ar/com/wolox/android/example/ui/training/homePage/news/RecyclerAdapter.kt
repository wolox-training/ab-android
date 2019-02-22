package ar.com.wolox.android.example.ui.training.homePage.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import kotlinx.android.synthetic.main.recycler_news.view.*
import org.ocpsoft.prettytime.PrettyTime
import java.util.Date
import android.icu.text.SimpleDateFormat

class RecyclerAdapter(private val news: MutableList<News>) :
        RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_news, parent, false))

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bindHolder(news[position])

    override fun getItemCount() = news.size
}

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    lateinit var convertedDate: Date
    var p = PrettyTime()
    val title = view.vText_title
    val description = view.vText_description
    val image = view.vImageViewRow
    val like = view.vlike
    val time = view.vText_time

    fun bindHolder(item: News) {
        title.text = item.title
        description.text = item.text
        image.setImageURI(item.picture)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        convertedDate = dateFormat.parse(item.createdAt)
        time.text = p.format(convertedDate)
        like.setOnClickListener {
            if (item.like) {
                it.setBackgroundResource(ar.com.wolox.android.R.drawable.ic_like_off)
                item.like = false
            } else {
                it.setBackgroundResource(ar.com.wolox.android.R.drawable.ic_like_on)
                item.like = true
            }
        }
    }
}
