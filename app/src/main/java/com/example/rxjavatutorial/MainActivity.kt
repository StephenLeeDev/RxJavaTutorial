package com.example.rxjavatutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rxjavatutorial.data.BookListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var bookListViewModel: BookListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {
        bookListViewModel = ViewModelProvider(this).get(BookListViewModel::class.java)
        bookListViewModel.makeApiCall("")
    }
}