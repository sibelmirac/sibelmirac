package com.example.hotelstarfish

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_oda_bilgileri.*
import kotlinx.android.synthetic.main.activity_oda_liste.view.*

class OdaBilgileri : AppCompatActivity() {

    var constList=ArrayList<Odalar>()
    var adapter:OdalarAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oda_bilgileri)

        constList.add(Odalar("A201", "Odamız çift kişiliktir. Odamızın gecelik fiyatı 90$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir. ", R.drawable.a201))
        constList.add(Odalar("A202", "Odamız çift kişiliktir. Odamızın gecelik fiyatı 120$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir. ", R.drawable.a202))
        constList.add(Odalar("A203", "Odamız tek kişiliktir. Odamızın gecelik fiyatı 75$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir. ", R.drawable.a203))
        constList.add(Odalar("A204", "Odamız çift kişiliktir. Odamızın gecelik fiyatı 100$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir. ", R.drawable.a204))
        constList.add(Odalar("A205", "Odamız çift kişiliktir. Odamızın gecelik fiyatı 115$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir.", R.drawable.a205))
        constList.add(Odalar("A206", "Odamız çift kişiliktir. Odamızın gecelik fiyatı 90$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir.", R.drawable.a206))
        constList.add(Odalar("A207", "Odamız tek kişiliktir. Odamızın gecelik fiyatı 85$'dır. Oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir.", R.drawable.a207))
        constList.add(Odalar("A208", "Odamız aile odasıdır. Odamızın gecelik fiyatı 95$'dır. Oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir.", R.drawable.a208))
        constList.add(Odalar("A209", "Odamız çift odasıdır. Odamızın gecelik fiyatı 120$'dır. Deniz manzaralı ve oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir.", R.drawable.a209))
        constList.add(Odalar("A210", "Odamız tek kişiliktir. Odamızın gecelik fiyatı 65$'dır. Oldukça konforlu olan bu odada klima sistemi, lüks banyo bulunmaktadır. Odamız hergün belirli saatlerde temizlenmekte, ayrıca çarşaf ve havlular değiştirilmektedir.", R.drawable.a210))

        adapter= OdalarAdapter(this,constList)
        list_odabilgi.adapter=adapter

    }
    class OdalarAdapter: BaseAdapter {

        var constList=ArrayList<Odalar>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<Odalar>):super(){
            this.constList=constList
            this.context=context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posOdalar=constList[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var Odabilgii=inflator.inflate(R.layout.activity_oda_liste,null)
            Odabilgii.txt201.text=posOdalar.constAdi
            Odabilgii.acikla201.text=posOdalar.constAciklama
            Odabilgii.img201.setImageResource(posOdalar.constResim!!)

            Odabilgii.img201.setOnClickListener {
                var intent = Intent (context,OdaDetaylar::class.java)
                intent.putExtra("constAdi",posOdalar.constAdi)
                intent.putExtra("constAciklama",posOdalar.constAciklama)
                intent.putExtra("constResim",posOdalar.constResim!!)
                context!!.startActivity(intent)

            }


            return Odabilgii

        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return constList.size
        }
    }
}
