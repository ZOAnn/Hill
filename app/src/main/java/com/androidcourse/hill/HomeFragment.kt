package com.androidcourse.hill

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_home.view.*

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View= inflater!!.inflate(R.layout.main_home, container, false)

        view.random_chat.setOnClickListener { view ->
            val intent = Intent(this.context, ChatActivity::class.java)
            //intent.putExtra("key", value)
            startActivity(intent)
        }
        view.select_chat.setOnClickListener { view ->
            val intent = Intent(this.context, ChatActivity::class.java)
            startActivity(intent)
        }
        return view
    }
    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}