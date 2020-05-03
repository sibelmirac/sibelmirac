package com.example.hotelstarfish

import android.content.Context
import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hizmet_liste.view.*
import kotlinx.android.synthetic.main.activity_hizmetler.*

class Hizmetler : AppCompatActivity() {

    var constListe=ArrayList<Hizmetbilgi>()
    var adapter: HizmetlerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hizmetler)

        constListe.add(Hizmetbilgi("AÇIK BÜFE","Otelimizde açık büfe yemek hizmeti sunulmaktadır.",R.drawable.acikbufe))
        constListe.add(Hizmetbilgi("SPA","Otelimizde dinlenmeniz için spa hizmeti sunulmaktadır. .",R.drawable.spa))
        constListe.add(Hizmetbilgi("SU PARKI","Otelimizde daha fazla eğlenmeniz için su kaydırakları bulunmaktadır.",R.drawable.su))
        constListe.add(Hizmetbilgi("SPOR","Otelimizde fit kalmanız için spor salonu hizmetimiz bulunmaktadır.",R.drawable.spor))
        constListe.add(Hizmetbilgi("CANLI MÜZİK","Otelimizde geceleri canlı müzik ve eğlence aktiviteleri bulunmaktadır.",R.drawable.canli))
        constListe.add(Hizmetbilgi("ODA TEMİZLİĞİ","Otelimizde sağlığınız için hergün belirli saatlerde oda temizliği yapılmaktadır.",R.drawable.temizlik))
        adapter = HizmetlerAdapter(this,constListe)
        list_hizmet.adapter=adapter
    }

    class HizmetlerAdapter:BaseAdapter{
        var constList=ArrayList<Hizmetbilgi>()
        var context:Context?=null

        constructor(context: Context,constList: ArrayList<Hizmetbilgi>):super(){
            this.constList=constList
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posHizmetler=constList[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var hizmetbilgii=inflator.inflate(R.layout.activity_hizmet_liste,null)
            hizmetbilgii.txthizmet.text = posHizmetler.constBaslik
            hizmetbilgii.txthizmetbilgi.text = posHizmetler.constAcikla
            hizmetbilgii.imghizmet.setImageResource(posHizmetler.constFoto!!)

            hizmetbilgii.imghizmet.setOnClickListener {
                if (position==0){
                    Toast.makeText(context,"Açık Büfe Hizmeti",Toast.LENGTH_LONG).show()
                }
                if (position==1){
                    Toast.makeText(context,"Spa ve Masaj Hizmeti",Toast.LENGTH_LONG).show()
                }
                if (position==2){
                    Toast.makeText(context,"Su Parkı Hizmeti",Toast.LENGTH_LONG).show()
                }
                if (position==3){
                    Toast.makeText(context,"Spor Salonu Hizmeti",Toast.LENGTH_LONG).show()
                }
                if (position==4){
                    Toast.makeText(context,"Canlı Müzik ve Eğlence Hizmeti",Toast.LENGTH_LONG).show()
                }
                if (position==5){
                    Toast.makeText(context,"Oda Temizlik Hizmeti",Toast.LENGTH_LONG).show()
                }
            }

            return hizmetbilgii
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

