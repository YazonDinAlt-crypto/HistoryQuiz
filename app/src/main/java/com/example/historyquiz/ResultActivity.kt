package com.example.historyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val characteristicTextView: TextView = findViewById(R.id.characteristicTextView)

        val totalScore = intent.getIntExtra("RESULT", 0)
        resultTextView.text = "Ваши баллы: $totalScore"

        val characteristic = when {
            totalScore == 500 -> "Отличный знаток истории!"
            totalScore >= 400 -> "Хороший знаток истории."
            totalScore >= 300 -> "Удовлетворительный уровень знаний."
            totalScore >= 200 -> "Низкий уровень знаний."
            else -> "Плохой знаток истории."
        }

        characteristicTextView.text = characteristic
    }
}