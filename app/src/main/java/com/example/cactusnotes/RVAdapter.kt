package com.example.cactusnotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext: Context, private val notesList: List<NotesDate>) :
    RecyclerView.Adapter<RVAdapter.CardViveDesignObjectsTaker>() {
    inner class CardViveDesignObjectsTaker(view: View) : RecyclerView.ViewHolder(view) {

        var noteCardview: CardView
        var titleTextview: TextView
        var paragraphTextview: TextView

        init {
            noteCardview = view.findViewById(R.id.noteCardview)
            titleTextview = view.findViewById(R.id.titleTextview)
            paragraphTextview = view.findViewById(R.id.paragraphTextview)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViveDesignObjectsTaker {
        val design = LayoutInflater.from(mContext).inflate(R.layout.note_cardview, parent, false)

        return CardViveDesignObjectsTaker(design)
    }

    override fun onBindViewHolder(holder: CardViveDesignObjectsTaker, position: Int) {

        val note = notesList[position]
        holder.titleTextview.text = note.notesTitleName
        holder.paragraphTextview.text = note.notesParagraph

        holder.noteCardview.setOnClickListener() {
            Toast.makeText(mContext, "we are not using this feature now .", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}