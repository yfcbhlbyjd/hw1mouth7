package com.geektech.hw1mouth7.presentation.ui.notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.hw1mouth7.databinding.ItemNotesBinding
import com.geektech.hw1mouth7.domain.model.Note
import kotlin.reflect.KFunction1


class NoteAdapter(private val onClick: KFunction1<Note, Unit>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var list = listOf<Note>()

    fun submitList(list: List<Note>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


    inner class NoteViewHolder(private val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(note: Note) {
            binding.itemTitle.text=note.title
            binding.itemDescription.text=note.description
            binding.itemCreatedAt.text= note.createAt.toString()
            itemView.setOnClickListener {
                onClick.invoke(note)
            }
        }
    }
}


