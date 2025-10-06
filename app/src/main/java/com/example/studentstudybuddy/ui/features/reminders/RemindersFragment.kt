package com.example.studentstudybuddy.ui.features.reminders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.studentstudybuddy.databinding.FragmentRemindersBinding
import com.example.studentstudybuddy.utils.NotificationHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RemindersFragment : Fragment() {
    private var _binding: FragmentRemindersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRemindersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notificationHelper = NotificationHelper(requireContext())

        binding.setReminderButton.setOnClickListener {
            val title = binding.reminderTitleEditText.text.toString().trim()
            if (title.isNotBlank()) {
                notificationHelper.showNotification(title, "Time to study!")
                Toast.makeText(context, "Reminder set!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please enter a title.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}