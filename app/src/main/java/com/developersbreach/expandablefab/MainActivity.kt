package com.example.expandablefab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.developersbreach.expandablefab.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var eachFabVisible: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseFab = findViewById<FloatingActionButton>(R.id.base_fab)
        val callFab = findViewById<FloatingActionButton>(R.id.call_fab)
        val videoFab = findViewById<FloatingActionButton>(R.id.video_call_fab)
        val textOne = findViewById<TextView>(R.id.text_one)
        val textTwo = findViewById<TextView>(R.id.text_two)

        videoFab.setVisibility(View.GONE)
        callFab.setVisibility(View.GONE)
        textOne.setVisibility(View.GONE)
        textTwo.setVisibility(View.GONE)

        eachFabVisible = false

        baseFab.setOnClickListener(
            View.OnClickListener {
                if (!eachFabVisible!!){
                    eachFabVisible = true
                    videoFab.show()
                    callFab.show()
                    textOne.setVisibility(View.VISIBLE)
                    textTwo.setVisibility(View.VISIBLE)
                } else {
                    videoFab.hide()
                    callFab.hide()
                    textOne.setVisibility(View.GONE)
                    textTwo.setVisibility(View.GONE)
                    eachFabVisible = false
                }
            })

        callFab.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this, "Connecting the audio call", Toast.LENGTH_LONG).show() })

        videoFab.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(
                    this, "Connecting the video call", Toast.LENGTH_LONG).show() })
    }
}