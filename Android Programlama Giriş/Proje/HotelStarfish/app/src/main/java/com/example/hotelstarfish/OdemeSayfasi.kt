package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class OdemeSayfasi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_odeme_sayfasi)
    }

    fun odeme(view: View){

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Ödeme İşlemleri")
        alert.setMessage("Ödemeyi gerçekleştirmek istediğinize emin misiniz?")
        alert.setPositiveButton("Devam Et"){dialog, which ->
            Toast.makeText(this,"Rezervasyon Başarılı!", Toast.LENGTH_LONG).show()
            var intent=Intent(applicationContext,GridView::class.java)
            startActivity(intent)
        }
        alert.setNegativeButton("Vazgeç"){dialog, which ->
            Toast.makeText(this,"Rezervasyon İptal Edildi!", Toast.LENGTH_LONG).show()
        }
        alert.show()

    }
}
