package com.example.socialsparkapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputTime: EditText
    private lateinit var suggestionText: TextView
    private lateinit var getSuggestionButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link UI elements
        inputTime = findViewById(R.id.editTextTime)
        suggestionText = findViewById(R.id.textViewSuggestion)
        getSuggestionButton = findViewById(R.id.buttonGetSuggestion)
        resetButton = findViewById(R.id.buttonReset)

        // Suggestion logic
        getSuggestionButton.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            val suggestion = when (timeOfDay) {
                "morning" -> "Send a cheerful good morning message!"
                "afternoon" -> "Share a fun meme with a friend!"
                "evening" -> "Call someone you haven’t spoken to in a while!"
                else -> "Please enter morning, afternoon, or evening."
            }
            suggestionText.text = suggestion
        }

        // Reset logic
        resetButton.setOnClickListener {
            inputTime.text.clear()
            suggestionText.text = ""
        }
    }
}