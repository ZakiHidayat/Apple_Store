package com.example.appleproduct.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appleproduct.databinding.ItemKategoriBinding
import com.example.appleproduct.model.KategoriItem
import com.example.appleproduct.model.MacItem

class AdapterKategori : RecyclerView.Adapter <KategoriViewHolder>(){

    private var itemkategorilist = arrayListOf<KategoriItem>()

    fun addData (item: List<KategoriItem>){
        itemkategorilist.clear()
        itemkategorilist.addAll(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val binding = ItemKategoriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KategoriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        val data = itemkategorilist[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return itemkategorilist.size
    }


}