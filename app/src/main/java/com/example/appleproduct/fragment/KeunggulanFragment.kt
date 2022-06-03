package com.example.appleproduct.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.appleproduct.databinding.FragmentKeunggulanBinding
import com.example.appleproduct.model.KeunggulanKekurangan
import com.example.appleproduct.network.RetrofitInterface
import com.example.appleproduct.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KeunggulanFragment : Fragment() {

    private lateinit var binding: FragmentKeunggulanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKeunggulanBinding.inflate(inflater, container, false)

        val all = RetrofitService.buildservice(RetrofitInterface::class.java)

        val call = all.getDataKeunggulan()

        call.enqueue(object : Callback<KeunggulanKekurangan> {
            override fun onResponse(
                call: Call<KeunggulanKekurangan>,
                response: Response<KeunggulanKekurangan>
            ) {
                val response = response.body()!!
                binding.txtKeunggulan.text = response.kelebihan
                binding.txtKekurangan.text = response.kekurangan
            }

            override fun onFailure(call: Call<KeunggulanKekurangan>, t: Throwable) {
                Toast.makeText(context, "HARAP MENCOOBA LAGI... SEMOGA ALLAH BERIKAN KEMUDAHAN", Toast.LENGTH_LONG).show()
            }
        })


        return binding.root
    }
}