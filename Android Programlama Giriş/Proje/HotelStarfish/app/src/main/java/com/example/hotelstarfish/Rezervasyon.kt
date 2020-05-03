package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_rezervasyon.*

class Rezervasyon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rezervasyon)
    }

    fun rezervasyon(view: View){

        val intent = Intent(applicationContext,OdemeSayfasi::class.java)
        startActivity(intent)

    }

}
