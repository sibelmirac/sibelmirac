package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_anket_cevap.*

class AnketCevap : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anket_cevap)

        val intent = intent
        val soru11 = intent.getStringExtra("soru1")
        val soru22 = intent.getStringExtra("soru2")
        val soru33 = intent.getStringExtra("soru3")
        val soru44 = intent.getStringExtra("soru4")
        val soru55 = intent.getStringExtra("soru5")

        text1.text = "Otelimizden memnun kaldınız mı? : " +soru11
        text2.text = "Otel çalışanlarımızdan memnun musunuz? : " +soru22
        text3.text = "Bu oteli bir kez daha tercih eder miydiniz? : " +soru33
        text4.text = "Otelimizde görmek istediğiniz farklı bir aktivite var mı? : " +soru44
        text5.text = "Son olarak eklemek istediğiniz birşey var mı? : " +soru55

    }

    fun cevaplar(view: View){

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Anket Sayfası")
        alert.setMessage("Anketimize verdiğiniz cevaplar kaydedilsin mi?")
        alert.setPositiveButton("Kaydet"){dialog, which ->
            Toast.makeText(this,"Ankete Katıldığınız İçin Teşekkür Ederiz!", Toast.LENGTH_LONG).show()
            var intent= Intent(applicationContext,GridView::class.java)
            startActivity(intent)
        }
        alert.setNegativeButton("Kaydetme"){dialog, which ->
            Toast.makeText(this,"Anket Cevaplarınız Kaydedilmedi!", Toast.LENGTH_LONG).show()
            var intent= Intent(applicationContext,GridView::class.java)
            startActivity(intent)
        }
        alert.show()
    }
}
