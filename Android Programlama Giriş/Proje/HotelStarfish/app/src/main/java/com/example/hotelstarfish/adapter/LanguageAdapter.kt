package com.example.hotelstarfish.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hotelstarfish.R
import com.example.hotelstarfish.model.LanguageItem

class LanguageAdapter(var context: Context, var arrayList: ArrayList<LanguageItem>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.cardview_item_grid, null)
        var icons: ImageView = view.findViewById(R.id.img_icon)
        var name: TextView = view.findViewById(R.id.text_name)
        var desc: TextView = view.findViewById(R.id.text_aciklama)

        var listItem: LanguageItem = arrayList.get(position)

        icons.setImageResource(listItem.icons!!)
        name.text = listItem.name
        desc.text = listItem.desc

        return view
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}
