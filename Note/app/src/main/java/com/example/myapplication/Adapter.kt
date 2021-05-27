package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var data : MutableSet<String> ) : RecyclerView.Adapter<Adapter.NoteViewHolder>() {



    class NoteViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val note = view.findViewById<TextView>(R.id.item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.note.text = data.elementAt(position)
        holder.itemView.setOnClickListener {
            data.remove(data.elementAt(position))
            initNewNotes(data)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun initNewNotes(newList : MutableSet<String>){
        data = newList
        notifyDataSetChanged()
    }
}