package com.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.AddEditActivity
import com.database.Note
import com.example.noteapp.databinding.RvItemsBinding

class RvAdapter(private var context: Context, private var noteList: List<Note>) :
    RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    class RvViewHolder(var binding: RvItemsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(RvItemsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val dataStore = noteList[position]
        holder.binding.descRVITEM.text = dataStore.descriptionEntity
        holder.binding.titleRVITEM.text = dataStore.titleEntity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, AddEditActivity::class.java)
            intent.putExtra("NOTE_EDIT", noteList[position])

            context.startActivity(intent)
        }
    }
}