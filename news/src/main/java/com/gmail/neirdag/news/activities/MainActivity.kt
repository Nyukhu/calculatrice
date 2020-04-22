package com.gmail.neirdag.news.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gmail.neirdag.news.R
import com.gmail.neirdag.news.fragments.ListArticleFragment
import com.gmail.neirdag.news.fragments.RecylerViewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        change(RecylerViewFragment())
    }
}
fun FragmentActivity.change(fragment: Fragment){
    supportFragmentManager.beginTransaction().apply {
        //replacer le précédent fragment, s'il existe
        replace(R.id.fragment_layout, fragment)
        //ajouter la transaction dans la stack
        addToBackStack(null)
    }.commit()
}