package com.example.cactusnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notesList: List<Notes>) :
    RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    class NoteHolder(view: View) : RecyclerView.ViewHolder(view) {

        val noteCardView: CardView = view.findViewById(R.id.noteCardView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val paragraphTextView: TextView = view.findViewById(R.id.paragraphTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_cardview, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val note = notesList[position]
        holder.titleTextView.text = note.title
        holder.paragraphTextView.text = note.content
    }

    override fun getItemCount() = notesList.size
}