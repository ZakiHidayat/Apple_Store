//package com.example.appleproduct.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.appleproduct.model.MacItem
//
//@Database (entities = [MacItem::class], version = 1, exportSchema = false)
//
//abstract class RoomDB : RoomDatabase() {
//   abstract fun roomDao() : RoomDao
//
//   companion object{
//
//      private var roomdatabaseitem : RoomDB? = null
//
//      fun geRoomDatabaseItem(context: Context): RoomDB{
//         return roomdatabaseitem ?: synchronized(this){
//            roomdatabaseitem ?: Room.databaseBuilder(context,RoomDB::class.java, "item.db")
//               .fallbackToDestructiveMigration()
//               .build()
//         }
//      }
//   }
//}