package com.example.studentstudybuddy.ui.features.resources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentstudybuddy.data.model.Book
import com.example.studentstudybuddy.databinding.ListItemBookBinding

class ResourcesAdapter(private val books: List<Book>) : RecyclerView.Adapter<ResourcesAdapter.BookViewHolder>() {

    inner class BookViewHolder(private val binding: ListItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.bookTitleTextView.text = book.title
            binding.bookAuthorTextView.text = book.authorName?.joinToString(", ") ?: "Unknown Author"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ListItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size
}