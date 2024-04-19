package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.database.NoteDatabase
import com.example.todoapp.repository.NoteRepository
import com.example.todoapp.viewmodel.NoteViewModel
import com.example.todoapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
setupViewModel()

        }
    private fun setupViewModel(){
        val noteRepository=NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory= NoteViewModelFactory(application, noteRepository)
        noteViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }


    }
