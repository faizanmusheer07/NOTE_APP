package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.database.Note
import com.example.noteapp.databinding.ActivityAddEditBinding
import com.viewmodels.AddEditViewModel

class AddEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding
    private lateinit var addEditActivityViewModel: AddEditViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEditActivityViewModel = ViewModelProvider(this).get(AddEditViewModel::class.java)


        if (intent.hasExtra("NOTE_EDIT")) {
            val note: Note = intent.getSerializableExtra("NOTE_EDIT") as Note
            binding.EditTitle.setText(note.titleEntity)
            binding.Editdescription.setText(note.descriptionEntity)

            binding.button.setOnClickListener {
                val title = binding.EditTitle.text.toString()
                val description = binding.Editdescription.text.toString()

                note.titleEntity = title
                note.descriptionEntity = description

                addEditActivityViewModel.update(note, this)
                finish()
            }
        } else {
            binding.button.setOnClickListener {
                val title = binding.EditTitle.text.toString()
                val description = binding.Editdescription.text.toString()
                val note = Note(titleEntity = title, descriptionEntity  = description)
                addEditActivityViewModel.insert(note, this)
                finish()
            }
        }
    }

}