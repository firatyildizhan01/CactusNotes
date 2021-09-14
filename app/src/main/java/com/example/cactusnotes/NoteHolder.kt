package com.example.cactusnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NoteHolder(private val notesList: List<Notes>) :
    RecyclerView.Adapter<NoteHolder.CardViveDesignObjectsTaker>() {
    class CardViveDesignObjectsTaker(view: View) : RecyclerView.ViewHolder(view) {

        val noteCardview: CardView
        val titleTextview: TextView
        val paragraphTextview: TextView

        init {
            noteCardview = view.findViewById(R.id.noteCardView)
            titleTextview = view.findViewById(R.id.titleTextView)
            paragraphTextview = view.findViewById(R.id.paragraphTextView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViveDesignObjectsTaker {
        val design =
            LayoutInflater.from(parent.context).inflate(R.layout.note_cardview, parent, false)

        return CardViveDesignObjectsTaker(design)
    }

    override fun onBindViewHolder(holder: CardViveDesignObjectsTaker, position: Int) {

        val note = notesList[position]
        holder.titleTextview.text = note.title
        holder.paragraphTextview.text = note.content

    }

    override fun getItemCount() = notesList.size

}