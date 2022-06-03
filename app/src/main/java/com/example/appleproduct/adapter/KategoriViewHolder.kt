package com.example.appleproduct.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appleproduct.databinding.ItemKategoriBinding
import com.example.appleproduct.model.KategoriItem

class KategoriViewHolder (val kategoribinding : ItemKategoriBinding) : RecyclerView.ViewHolder (kategoribinding.root){

    fun bindData (item: KategoriItem){

        val adapterkategori = MacAdapter()

        itemView.run {
            kategoribinding.txtTitle.text = item.title
            kategoribinding.reciphone.setHasFixedSize(true)
            kategoribinding.reciphone.layoutManager = LinearLayoutManager(context)
            kategoribinding.reciphone.adapter = adapterkategori
        }
        adapterkategori.addData(item.data)
        adapterkategori.notifyDataSetChanged()
    }

}
