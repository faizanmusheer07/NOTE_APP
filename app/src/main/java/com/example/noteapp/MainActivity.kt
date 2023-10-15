package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.RvAdapter
import com.database.Note
import com.example.noteapp.databinding.ActivityMainBinding
import com.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var noteList: List<Note>
    private lateinit var adapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteList = ArrayList()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val observer = Observer<List<Note>> {
            noteList = it
            adapter = RvAdapter(this, noteList)
            binding.rvRecycler.layoutManager = LinearLayoutManager(this)
            binding.rvRecycler.adapter = adapter
        }
        viewModel.notesList.observe(this, observer)

       adapter= RvAdapter(this, noteList)
        binding.rvRecycler.layoutManager = LinearLayoutManager(this)
        binding.rvRecycler.adapter = adapter
        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddEditActivity::class.java))
        }
    }


}