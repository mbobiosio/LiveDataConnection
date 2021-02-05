package com.mbobiosio.connectionlivedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this, {
            Log.d("Status", "$it")
            when(it) {
                true -> status.text = getString(R.string.connected)
                else -> status.text = getString(R.string.disconnected)
            }
        })
    }
}