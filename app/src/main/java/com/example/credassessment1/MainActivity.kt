package com.example.credassessment1

import android.os.Bundle
import android.widget.StackView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var stackView: StackView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stackView = findViewById(R.id.stack_view)
        val adapter = MainAdapter(numberWord(), numberImage(), R.layout.item_view, this)
        stackView.adapter = adapter
    }

    private fun numberWord(): List<String> {
        return listOf("One", "Two", "Three", "Four")
    }

    private fun numberImage(): List<Int> {
        return listOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
        )
    }
}