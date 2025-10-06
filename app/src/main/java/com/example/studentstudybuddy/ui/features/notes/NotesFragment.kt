package com.example.studentstudybuddy.ui.features.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentstudybuddy.databinding.FragmentNotesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.notesRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.notes.observe(viewLifecycleOwner) { notesList ->
            binding.notesRecyclerView.adapter = NotesAdapter(notesList)
        }

        binding.addNoteFab.setOnClickListener {
            // Here you would typically show a dialog to add a new note.
            // For simplicity, we'll add a sample note.
            viewModel.addNote("New Note", "This is the content.")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}