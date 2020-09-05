package com.mbobiosio.lifecycleconnectivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lifecycleService = LifecycleService(this)
        lifecycleService.observe(this, {
            Log.d("TAG", "$it")
        })

        /*val lifecycleService = LifecycleService(this)
        lifecycleService.observe(this, {
            Log.d("TAG", "Status $it")
            when(it) {
                true -> status.text = "Connected"
                false -> status.text = "Disconnected"
            }
        })*/

    }
}