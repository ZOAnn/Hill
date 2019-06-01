package com.androidcourse.hill

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        Handler().postDelayed(
                {
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                },
                2000
        )
    }
}