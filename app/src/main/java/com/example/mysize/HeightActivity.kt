package com.example.mysize

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView

class HeightActivity : AppCompatActivity() {

    companion object {
        const val HEIGHT_KEY = "HEIGHT"
    }

    lateinit var mHeight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt(HEIGHT_KEY, 160)

        mHeight = findViewById(R.id.height)
        mHeight.text = height.toString()
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = requireNotNull(parent).selectedItem as String
                if (!item.isEmpty()) {
                    mHeight.text = item
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        // SeekBar
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.progress = height
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mHeight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }


    override fun onPause() {
        super.onPause()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putInt(HEIGHT_KEY, mHeight.text.toString().toInt())
        editor.apply()
    }
}