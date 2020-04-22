package com.gmail.neirdag.news.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.neirdag.news.R
import com.gmail.neirdag.news.activities.change
import com.gmail.neirdag.news.adapters.CategoryAdapter
import com.gmail.neirdag.news.models.CategoryItem


class RecylerViewFragment :Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = listOf<CategoryItem>(
            CategoryItem("Politique","La SNCF joue un rôle important dans la vie politique française. En effet les trains et les gares sont le théâtre de nombreuses contestations et mouvmeent populaires s'opposant à de nombreuses lois et personnes","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS4_WM6EDjcD8r6dCez6NTOI6ktaTkrLOUYbhavJnMG7j1rRn0F&usqp=CAU","politics"),
            CategoryItem("Economie","Le Rôle de la SNCF dans la vie économique n'est plus à prouver, en possédant les voies ferrées françaises elle contribue au commerce interne et à l'acheminement des marchandises importées partout sur le territoire","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS4_WM6EDjcD8r6dCez6NTOI6ktaTkrLOUYbhavJnMG7j1rRn0F&usqp=CAU","economy"),
            CategoryItem("Education","Transportant a faible coût(toujours trop élevé) les étudiants, la SNCF permets aux étudiants de pouvoir étudier plus loin qu'il ne l'aurais pu sans les trains","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS4_WM6EDjcD8r6dCez6NTOI6ktaTkrLOUYbhavJnMG7j1rRn0F&usqp=CAU","education"),
            CategoryItem("Pandémie","Malheureusement La SNCF, en facilitant le transport des gens, a aussi facilité la propagation de maladies tel que le COVID-19","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS4_WM6EDjcD8r6dCez6NTOI6ktaTkrLOUYbhavJnMG7j1rRn0F&usqp=CAU","pandemic"),
            CategoryItem("Sciences","Le train offre un moment de vide idéal pour permettre aux gens de penser. Quoi de mieux pour faire avancer la science ? Je vous le demande...","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS4_WM6EDjcD8r6dCez6NTOI6ktaTkrLOUYbhavJnMG7j1rRn0F&usqp=CAU","science"),
            CategoryItem("Ecologie","za wordo, toki o tomare, est la réplique de DIO Brando, célèbre acteur de l'environnement, voulant stopper l'écoulement du temps afin de préserver le monde","https://medias.spotern.com/spots/w640/66/66607-1532336916.jpg","environnement")
        )
        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = CategoryAdapter(categories){
            this.activity!!.change(ListArticleFragment.newInstance(it.categoryQueryName))
        }

        recyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
        recyclerView.layoutManager = GridLayoutManager(this.activity, 1)
    }
}