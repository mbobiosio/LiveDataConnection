package com.mbobiosio.lifecycleconnectivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lifecycleService = LifecycleService(this)
        lifecycleService.observe(this, {
            Log.d("Status", "$it")
            status.text = it.toString()
        })

    }

}