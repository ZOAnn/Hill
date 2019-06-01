package com.androidcourse.hill

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity

class ContactFragment : Fragment() {

    lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view:View= inflater!!.inflate(R.layout.main_contact, container, false)


        listView = view.findViewById<ListView>(R.id.contact_list)
        val recipeList = Contact.getRecipesFromFile("contacts.json", view.context)
        val listItems = arrayOfNulls<String>(recipeList.size)
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.name
        }
        val adapter = ContactAdapter(view.context, recipeList)
        listView.adapter = adapter
        return view
    }

    companion object {
        fun newInstance(): ContactFragment = ContactFragment()
    }
}