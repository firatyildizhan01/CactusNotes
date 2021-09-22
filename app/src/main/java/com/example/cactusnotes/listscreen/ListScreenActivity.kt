package com.example.cactusnotes.listscreen

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cactusnotes.NoteAdapter
import com.example.cactusnotes.Notes
import com.example.cactusnotes.R
import com.example.cactusnotes.databinding.ActivityListScreenBinding
import com.google.android.material.snackbar.Snackbar

class ListScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListScreenBinding
    private lateinit var notesList: ArrayList<Notes>
    private lateinit var adapter: NoteAdapter

    val LOADING = 0
    val EMPTY = 1
    val ERROR = 2
    val SUCCESS = 3
    var stateIndex = LOADING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUI(binding)

        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val u1 = Notes(1, "Remember", "Doing is important!")
        val u2 = Notes(2, "Shopping List", "Carrots\n" + "Bananas\n" + "Apples\n" + "Milk")
        val u3 = Notes(
            3,
            "Learn Kotlin",
            "Extensions functions are of a great help when creating a clean a..."
        )

        notesList = ArrayList<Notes>()
        notesList.add(u1)
        notesList.add(u2)
        notesList.add(u3)

        adapter = NoteAdapter(notesList)
        binding.recyclerview.adapter = adapter

        binding.floatingActionButton5.setOnClickListener() {
            incrementState()
            updateUI(binding)
        }
    }

    private fun incrementState() {
        stateIndex += 1

        if (stateIndex == 4) {
            stateIndex = 0
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    private fun updateUI(binding: ActivityListScreenBinding) {
        when (stateIndex) {

            LOADING -> {
                binding.customProgressDialog.isVisible = true
                binding.recyclerview.isVisible = false
                binding.emptyTextview.isVisible = false
                binding.imageView.isVisible = false

            }
            EMPTY -> {
                binding.customProgressDialog.isVisible = false
                binding.recyclerview.isVisible = false
                binding.emptyTextview.isVisible = true
                binding.imageView.isVisible = true
                binding.imageView.setImageResource(R.drawable.img_cactus)

            }
            ERROR -> {
                binding.customProgressDialog.isVisible = false
                binding.recyclerview.isVisible = false
                binding.emptyTextview.isVisible = false
                binding.imageView.isVisible = true
                binding.imageView.setImageResource(R.drawable.img_gray_cactus)
                Snackbar.make(
                    binding.root,
                    getString(R.string.couldnt_connect_to_servers),
                    Snackbar.LENGTH_LONG
                ).show()

            }
            SUCCESS -> {
                binding.customProgressDialog.isVisible = false
                binding.recyclerview.isVisible = true
                binding.emptyTextview.isVisible = false
                binding.imageView.isVisible = false

            }
        }
    }
}