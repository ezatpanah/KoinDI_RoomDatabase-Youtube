package com.ezatpanah.koindi_roomdatabase_youtube.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezatpanah.koindi_roomdatabase_youtube.adapter.NoteAdapter
import com.ezatpanah.koindi_roomdatabase_youtube.databinding.ActivityMainBinding
import com.ezatpanah.koindi_roomdatabase_youtube.viewmodel.DatabaseViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private val noteAdapter by lazy { NoteAdapter() }
    private val viewModel: DatabaseViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.apply {

            btnAddNote.setOnClickListener {
                AddNoteFragment().show(supportFragmentManager, AddNoteFragment().tag)
            }

            viewModel.getAllNotes()
            viewModel.notesList.observe(this@MainActivity) {
                if (it.isNotEmpty()) {
                    showEmpty(true)
                    noteAdapter.differ.submitList(it)
                    rvNoteList.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = noteAdapter
                    }
                } else {
                    showEmpty(false)
                }
            }

        }
    }

    private fun showEmpty(isShown: Boolean) {
        binding!!.apply {
            if (isShown) {
                rvNoteList.visibility = View.VISIBLE
                tvEmptyText.visibility = View.GONE
            } else {
                rvNoteList.visibility = View.GONE
                tvEmptyText.visibility = View.VISIBLE
            }
        }
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}