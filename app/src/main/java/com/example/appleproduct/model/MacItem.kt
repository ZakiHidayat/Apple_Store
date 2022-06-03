package com.example.appleproduct.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "item")
@Parcelize
data class MacItem(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @Json(name = "Gambar")
    var Gambar : String?,
    @Json(name = "Nama")
    val Nama : String?,
    @Json(name = "Desk")
    val Desk : String?,
    @Json(name = "Spec")
    val Spec : String?,
    var type : String?
) : Parcelable

@Parcelize
data class KategoriItem(
    @Json(name = "title")
    var title : String?,
    @Json(name = "data")
    var data: List<MacItem> = arrayListOf()
):Parcelable

@Parcelize
data class KeunggulanKekurangan(
    @Json(name = "kekurangan")
    var  kekurangan: String?,
    @Json(name = "kelebihan")
    var kelebihan: String?
):Parcelable