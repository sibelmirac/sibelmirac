package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class SplashEkrani : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_ekrani)

        val background = object  : Thread(){
            override fun run() {
                try {
                    Thread.sleep(4000)

                    val intent = Intent(baseContext,MainActivity::class.java)
                    startActivity(intent)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
