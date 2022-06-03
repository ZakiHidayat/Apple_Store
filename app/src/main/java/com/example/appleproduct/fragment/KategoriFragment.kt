package com.example.appleproduct.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appleproduct.adapter.AdapterKategori
import com.example.appleproduct.databinding.FragmentKategoriBinding
import com.example.appleproduct.model.KategoriItem
import com.example.appleproduct.network.RetrofitInterface
import com.example.appleproduct.network.RetrofitService
import kotlinx.coroutines.launch

class KategoriFragment : Fragment() {

    private lateinit var binding: FragmentKategoriBinding
    private lateinit var adapterKategori: AdapterKategori
//    private lateinit var roomDB: RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKategoriBinding.inflate(inflater, container, false)

//        roomDB = context?.let { RoomDB.geRoomDatabaseItem(it) }!!

        adapterKategori = AdapterKategori()
        binding.reckategori.setHasFixedSize(true)
        binding.reckategori.layoutManager = GridLayoutManager(context, 2)
        binding.reckategori.adapter = adapterKategori

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildservice(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadatakategori = retrofitService.getDataKategori()

            if (mintadatakategori.isSuccessful){
                val dataKategori = mintadatakategori.body() as List<KategoriItem>
                adapterKategori.addData(dataKategori)
                adapterKategori.notifyDataSetChanged()
            }
        }
    }
}