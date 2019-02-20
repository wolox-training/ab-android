package ar.com.wolox.android.example.ui.training.homePage.news

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import kotlinx.android.synthetic.main.recycler_news.view.*

class RecyclerAdapter(private val news: MutableList<News>) :
        RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(val row: ConstraintLayout) : RecyclerView.ViewHolder(row)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.MyViewHolder {
        val row = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_news, parent, false) as ConstraintLayout
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.row.vText_title.text = news[position].getTitle()
        holder.row.vText_description.text = news[position].getText()
        holder.row.vImageViewRow.setImageURI(news[position].getPicture())
        holder.row.vlike.setOnClickListener {
            if (news[position].isLike()) {
                it.setBackgroundResource(R.drawable.ic_like_off)
                news[position].setLike(false)
            } else {
                it.setBackgroundResource(R.drawable.ic_like_on)
                news[position].setLike(true)
            }
        }
    }
    public fun addMoreRows(newNews: MutableList<News>) {
        news.addAll(newNews)
        notifyDataSetChanged()
    }

    override fun getItemCount() = news.size
}
