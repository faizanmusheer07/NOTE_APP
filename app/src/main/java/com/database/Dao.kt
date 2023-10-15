package com.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {


@Query("SELECT * FROM Note")
   fun getAllNote(): LiveData<List<Note>>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertNote(note: Note)

   @Update
   fun updateNote(note: Note)

   @Delete
   fun deleteNote(note: Note)

}