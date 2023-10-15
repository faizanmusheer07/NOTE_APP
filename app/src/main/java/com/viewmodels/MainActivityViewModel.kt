package com.viewmodels

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.database.DatabaseNote
import com.database.Note


class MainActivityViewModel(  application: Application) : AndroidViewModel(application) {

    lateinit var notesList: LiveData<List<Note>>


    init {
        notesList = DatabaseNote.getDB(application).dbDao().getAllNote()
    }
}