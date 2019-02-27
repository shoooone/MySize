package com.example.mysize

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView

class HeightActivity : AppCompatActivity() {

    lateinit var mHeight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)
        mHeight = findViewById(R.id.height)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.setOnItemClickListener { parent, _, _, _ ->
            val item = parent.selectedItem as String
            if(!item.isEmpty()){
                mHeight.text = item
            }

        }

    }
}
