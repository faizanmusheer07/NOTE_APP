package com.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class DatabaseNote : RoomDatabase() {
    abstract fun dbDao(): Dao

    companion object{
        var roomDB : DatabaseNote?=null
        fun getDB(context: Context): DatabaseNote{
            if (roomDB==null){
                roomDB= Room.databaseBuilder(context, DatabaseNote::class.java, "database_note.db").allowMainThreadQueries().build()
            }
            return roomDB!!
        }
    }
}


