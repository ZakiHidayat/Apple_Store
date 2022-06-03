

package com.example.appleproduct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.appleproduct.databinding.ActivityDetailBinding
import com.example.appleproduct.databinding.ItemKategoriBinding
import com.example.appleproduct.model.MacItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_DATA = "p"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<MacItem>(EXTRA_DATA)

        binding.txtNamaDetail.text = data?.Nama
        binding.txtDeskDetail.text = data?.Desk
        binding.txtSpecDetail.text = data?.Spec
        Glide.with(this).load(data?.Gambar).into(binding.imgDetail)
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnBuydetail.setOnClickListener {
            Toast.makeText(this, "Barang anada sedang kami persiapkan...", Toast.LENGTH_LONG).show()
        }
    }
}