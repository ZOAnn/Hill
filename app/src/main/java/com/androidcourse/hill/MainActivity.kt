package com.androidcourse.hill

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        //toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)

        //toolbar.title = "首页"
        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment)

        bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    //toolbar.title = "首页"
                    val homeFragment = HomeFragment.newInstance()
                    openFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_contact -> {
                    //toolbar.title = "好友"
                    val contactFragment = ContactFragment.newInstance()
                    openFragment(contactFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_me -> {
                    //toolbar.title = "我的"
                    val meFragment = MeFragment.newInstance()
                    openFragment(meFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}