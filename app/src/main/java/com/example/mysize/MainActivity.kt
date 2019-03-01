package com.example.mysize

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var editNeck: EditText
    private lateinit var editSleeve: EditText
    private lateinit var editWaist: EditText
    private lateinit var editInseam: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editNeck = findViewById(R.id.neck)
        editSleeve = findViewById(R.id.sleeve)
        editWaist = findViewById(R.id.waist)
        editInseam = findViewById(R.id.inseam)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        editNeck.setText(pref.getString(NECK, ""))
        editSleeve.setText(pref.getString(SLEEVE, ""))
        editWaist.setText(pref.getString(WAIST, ""))
        editInseam.setText(pref.getString(INSEAM, ""))

        findViewById<ImageButton>(R.id.height_button).setOnClickListener {
            startActivity(Intent(this, HeightActivity::class.java))
        }

    }

    fun onTappedSaveButton(view: View) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString(NECK, editNeck.text.toString())
        editor.putString(SLEEVE, editSleeve.text.toString())
        editor.putString(WAIST, editWaist.text.toString())
        editor.putString(INSEAM, editInseam.text.toString())
        editor.apply()
    }


    companion object {
        const val NECK = "NECK"
        const val SLEEVE = "SLEEVE"
        const val WAIST = "WAIST"
        const val INSEAM = "INSEAM"
    }
}
