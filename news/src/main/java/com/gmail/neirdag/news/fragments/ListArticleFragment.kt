package com.gmail.neirdag.news.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.neirdag.news.R
import com.gmail.neirdag.news.activities.change
import com.gmail.neirdag.news.adapters.ArticleAdapter
import com.gmail.neirdag.news.adapters.CategoryAdapter
import com.gmail.neirdag.news.models.Article
import com.gmail.neirdag.news.repositories.Articlepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListArticleFragment :Fragment() {
    private val repository = Articlepository()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    val category:String by lazy {
        arguments?.getString(ARGS_CATEGORY) ?: "ecology"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycleScope.launch {
            getData("$category")

        }
    }
    //S'execute dans un thread secondaire
    private suspend fun getData(query:String) {
        withContext(Dispatchers.IO) {
            val result = repository.list(query)
            bindData(result)

        }
    }
    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
            Log.d("Articles",result.toString())
            viewManager = LinearLayoutManager(activity)
            viewAdapter = ArticleAdapter(result){
            }
            recyclerView = activity!!.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)
                // use a linear layout manager
                layoutManager = viewManager
                // specify an viewAdapter (see also next example)
                adapter = viewAdapter

            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_list_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //recyclerView.layoutManager = GridLayoutManager(this.activity, 3)
    }

    companion object {
        const val ARGS_CATEGORY = "ARGS_CATEGORY"
        fun newInstance(category: String):ListArticleFragment {
            return ListArticleFragment().apply {
                //On sauvegarde l’opération dans les arguments,
                //Si le fragment se recrée, la valeur sera restaurée
                arguments = bundleOf(ARGS_CATEGORY to category)
            }
        }
    }
}