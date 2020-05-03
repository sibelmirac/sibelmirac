package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import com.example.hotelstarfish.adapter.LanguageAdapter
import com.example.hotelstarfish.model.LanguageItem

class GridView : AppCompatActivity() , AdapterView.OnItemClickListener{

    private var arrayList: ArrayList<LanguageItem>? = null
    private var gridView: GridView? = null
    private var languageAdapter: LanguageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        gridView = findViewById(R.id.grid_view_list)
        arrayList = ArrayList()
        arrayList = setDataList()
        languageAdapter = LanguageAdapter(applicationContext, arrayList!!)
        gridView?.adapter = languageAdapter
        gridView?.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<LanguageItem> {
        var arrayList: ArrayList<LanguageItem> = ArrayList()

        arrayList.add(
            LanguageItem(
                R.drawable.odabilgi,
                "Oda Bilgileri",
                "Detaylı oda bilgileri için tıklayınız.."
            )
        )
        arrayList.add(
            LanguageItem(
                R.drawable.rezervasyonlar,
                "Rezervasyon",
                "Rezervasyon yapmak için tıklayınız.."
            )
        )
        arrayList.add(
            LanguageItem(
                R.drawable.otelhizmet,
                "Hizmetlerimiz",
                "Sunduğumuz Hizmetler için tıklayınız.."
            )
        )
        arrayList.add(
            LanguageItem(
                R.drawable.iletisim,
                "İletişim Bilgileri",
                "İletişim bilgilerimiz için tıklayınız.."
            )
        )
        arrayList.add(
            LanguageItem(
                R.drawable.anket,
                "Otel Anket",
                "Anketimize katılmak için tıklayınız.."
            )
        )
        arrayList.add(
            LanguageItem(
                R.drawable.hotel,
                "Otellerimiz",
                "Diğer Otellerimiz için tıklayınız.."
            )
        )

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if (position == 0) {
            val intent = Intent(applicationContext,OdaBilgileri::class.java)
            startActivity(intent)
        }
        if (position == 1) {
            val intent = Intent(applicationContext,Rezervasyon::class.java)
            startActivity(intent)
        }
        if (position == 2) {
            val intent = Intent(applicationContext,Hizmetler::class.java)
            startActivity(intent)
        }
        if (position == 3) {
            val intent = Intent(applicationContext,IletisimBilgi::class.java)
            startActivity(intent)
        }
        if (position == 4) {
            val intent = Intent(applicationContext,Anket::class.java)
            startActivity(intent)
        }
        if (position == 5) {
            val intent = Intent(applicationContext,DigerOteller::class.java)
            startActivity(intent)
        }



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.action_hakkimizda -> {

                var intent = Intent(this, Hakkimizda::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
