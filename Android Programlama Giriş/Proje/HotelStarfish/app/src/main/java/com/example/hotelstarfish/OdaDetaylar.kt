package com.example.hotelstarfish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_oda_detaylar.*

class OdaDetaylar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oda_detaylar)

        var bundle: Bundle = intent.extras!!
        var adi=bundle.getString("constAdi")
        var aciklama=bundle.getString("constAciklama")
        var resim = bundle.getInt("constResim")

        oda_numara.text=adi
        oda_aciklama.text=aciklama
        detay_resim.setImageResource(resim)



    }
}
