package com.example.appleproduct.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appleproduct.adapter.MacAdapter
import com.example.appleproduct.databinding.FragmentMacbookBinding
import com.example.appleproduct.model.MacItem
import com.example.appleproduct.network.RetrofitInterface
import com.example.appleproduct.network.RetrofitService
import kotlinx.coroutines.launch

class MacbookFragment : Fragment() {

    private lateinit var binding: FragmentMacbookBinding
    private lateinit var adapterMac : MacAdapter
//    private lateinit var roomDB: RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMacbookBinding.inflate(inflater, container, false)

//        roomDB = context?.let { RoomDB.geRoomDatabaseItem(it) }!!

        adapterMac = MacAdapter()
        binding.recyclermac.adapter = adapterMac
        binding.recyclermac.setHasFixedSize(true)
        binding.recyclermac.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val dataItemMac = roomDB.roomDao().getDatabyType("Mac")
//
//        dataItemMac.observe(viewLifecycleOwner, Observer {
//            Log.e("Banyaknya Data", it.size.toString())
//            if(it.isNotEmpty()) {
//                adapterMac.addData(it)
//                adapterMac.notifyDataSetChanged()
//            } else{
//                Toast.makeText(context, "Database Kosong Bro", Toast.LENGTH_SHORT).show()
//            }
//        })

        val retrofitService = RetrofitService.buildservice(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val  mintadataMac = retrofitService.getDataMac()

            if (mintadataMac.isSuccessful){
                val dataMac = mintadataMac.body() as List<MacItem>
                adapterMac.addData(dataMac)
                adapterMac.notifyDataSetChanged()
//                dataMac.forEach {
//                    it.type = "Mac"
//                }
//                roomDB.roomDao().insertData(dataMac)
            }
        }
    }
}