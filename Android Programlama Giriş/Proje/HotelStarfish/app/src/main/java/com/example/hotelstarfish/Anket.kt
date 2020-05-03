package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_anket.*

class Anket : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anket)

    }
    fun kaydet(view: View){

        val intent=Intent(applicationContext,AnketCevap::class.java)

        intent.putExtra("soru1",soru1.text.toString())
        intent.putExtra("soru2",soru2.text.toString())
        intent.putExtra("soru3",soru3.text.toString())
        intent.putExtra("soru4",soru4.text.toString())
        intent.putExtra("soru5",soru5.text.toString())

        startActivity(intent)

    }
}
