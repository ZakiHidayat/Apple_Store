package com.example.appleproduct.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appleproduct.databinding.ItemMacBinding
import com.example.appleproduct.model.MacItem

class MacViewHolder(val macBinding: ItemMacBinding) :
    RecyclerView.ViewHolder(macBinding.root) {
    fun bindview (item: MacItem) {
        itemView.run {
            macBinding.txtjudul.text = item.Nama
            macBinding.txtdesk.text = item.Desk
            Glide.with(this).load(item.Gambar).into(macBinding.imgMac)
        }
    }
}