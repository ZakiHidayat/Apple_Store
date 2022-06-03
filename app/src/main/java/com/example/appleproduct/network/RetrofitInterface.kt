package com.example.appleproduct.network

import com.example.appleproduct.model.KategoriItem
import com.example.appleproduct.model.KeunggulanKekurangan
import com.example.appleproduct.model.MacItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
//    @GET("/kategori/0/data.json")
//    suspend fun getDataiPhone() : Response<List<iPhoneItem>>

    @GET("/kategori/1/data.json")
    suspend fun getDataMac() : Response<List<MacItem>>

    @GET("/kategori.json")
    suspend fun getDataKategori() : Response<List<KategoriItem>>

    @GET("/kk.json")
    fun getDataKeunggulan() :Call<KeunggulanKekurangan>
}