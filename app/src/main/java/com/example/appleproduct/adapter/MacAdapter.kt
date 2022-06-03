package com.example.appleproduct.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appleproduct.DetailActivity
import com.example.appleproduct.databinding.ItemMacBinding
import com.example.appleproduct.model.MacItem


class MacAdapter : RecyclerView.Adapter<MacViewHolder>(){
    private val listitemmac = arrayListOf<MacItem>()


    fun addData(items : List<MacItem>){
        listitemmac.clear()
        listitemmac.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MacViewHolder {
        val listitemmacbinding = ItemMacBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MacViewHolder(listitemmacbinding)
    }

    override fun onBindViewHolder(holder: MacViewHolder, position: Int) {
        val data = listitemmac[position]
        holder.bindview(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listitemmac.size
    }
}