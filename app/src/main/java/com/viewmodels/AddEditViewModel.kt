package com.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import androidx.room.Update
import com.database.DatabaseNote
import com.database.Note
import kotlinx.coroutines.launch

class AddEditViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(note: Note, context: Context) {
        DatabaseNote.getDB(context).dbDao().insertNote(note)

    }
    fun update(note: Note, context: Context){
        DatabaseNote.getDB(context).dbDao().updateNote(note)
    }
}