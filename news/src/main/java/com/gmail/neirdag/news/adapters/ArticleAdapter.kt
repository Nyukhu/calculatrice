package com.gmail.neirdag.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.neirdag.news.R
import com.gmail.neirdag.news.models.Article
import com.gmail.neirdag.news.models.CategoryItem

class ArticleAdapter(
    private val dataset: List<Article>,
    private val callback: (article:Article) -> Unit
) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    inner class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {

            root.setOnClickListener {
                callback(item)
            }

            val txtTitle = root.findViewById<TextView>(R.id.category_title)
            val txtDesc = root.findViewById<TextView>(R.id.category_description)
            txtTitle.text = item.title
            txtDesc.text = item.description
            val imageView = root.findViewById<ImageView>(R.id.category_image)
            Glide.with(root).load(item.urlToImage).into(imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item_layout, parent, false)
        return ViewHolder(rootView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataset.size
}