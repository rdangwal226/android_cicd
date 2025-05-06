package com.exmaple.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmaple.localization.ui.main.SecondFragment

class SharedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment())
                .commitNow()
        }
    }
}