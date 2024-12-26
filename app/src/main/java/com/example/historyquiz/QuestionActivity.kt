package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Кто был первым президентом России?",
        "В каком году началась Вторая мировая война?",
        "Кто написал 'Войну и мир'?",
        "Когда была подписана Конституция Российской Федерации?",
        "Какой город является столицей России?"
    )

    private val answers = arrayOf(
        arrayOf("Ельцин", "Путин", "Горбачёв"),
        arrayOf("1939", "1941", "1945"),
        arrayOf("Толстой", "Достоевский", "Пушкин"),
        arrayOf("1993", "1991", "2000"),
        arrayOf("Москва", "Санкт-Петербург", "Казань")
    )

    private val correctAnswers = arrayOf(0, 0, 0, 0, 0)
    private var currentQuestionIndex = 0
    private var result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val answer1: RadioButton = findViewById(R.id.answer1)
        val answer2: RadioButton = findViewById(R.id.answer2)
        val answer3: RadioButton = findViewById(R.id.answer3)
        val nextButton: Button = findViewById(R.id.nextButton)

        loadQuestion(questionTextView, answer1, answer2, answer3)

        nextButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                if (selectedId == answer1.id && correctAnswers[currentQuestionIndex] == 0 ||
                    selectedId == answer2.id && correctAnswers[currentQuestionIndex] == 1 ||
                    selectedId == answer3.id && correctAnswers[currentQuestionIndex] == 2) {
                    result += 100
                }

                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {
                    loadQuestion(questionTextView, answer1, answer2, answer3)
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("RESULT", result)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun loadQuestion(questionTextView: TextView, answer1: RadioButton, answer2: RadioButton, answer3: RadioButton) {
        questionTextView.text = questions[currentQuestionIndex]
        answer1.text = answers[currentQuestionIndex][0]
        answer2.text = answers[currentQuestionIndex][1]
        answer3.text = answers[currentQuestionIndex][2]
    }
}
