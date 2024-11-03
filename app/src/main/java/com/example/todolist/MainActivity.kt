package com.example.todolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        taskAdapter = TaskAdapter(mutableListOf())

        binding.recyclerViewTasks.adapter = taskAdapter
        binding.recyclerViewTasks.layoutManager = LinearLayoutManager(this)

        binding.buttonAdd.setOnClickListener {
            val taskText = binding.editTextTask.text.toString()
            if (taskText.isNotEmpty()) {
                if (taskText.trim().isNotEmpty()) {
                    val task = Task(taskText.trim())
                    taskAdapter.addTask(task)
                }
                binding.editTextTask.text.clear()
            }
        }

        binding.buttonClear.setOnClickListener {
            val finished = taskAdapter.clearTasks()
            Toast.makeText(this, "Tasks finished: $finished", Toast.LENGTH_SHORT).show()

        }
    }
}