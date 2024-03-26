package com.rpsouza.calculateimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputWeight: TextInputLayout
    private lateinit var editTextWeight: TextInputEditText

    private lateinit var textInputHeight: TextInputLayout
    private lateinit var editTextHeight: TextInputEditText

    private lateinit var buttonCalculateIMC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeInterfaceComponents()

        buttonCalculateIMC.setOnClickListener {
            calculateIMC()
        }
    }

    private fun initializeInterfaceComponents() {
        textInputWeight = findViewById(R.id.text_input_weight)
        editTextWeight = findViewById(R.id.edit_text_weight)

        textInputHeight = findViewById(R.id.text_input_height)
        editTextHeight = findViewById(R.id.edit_text_height)

        buttonCalculateIMC = findViewById(R.id.button_calculate_imc)
    }

    private fun calculateIMC() {
        val weight = editTextWeight.text.toString()
        val height = editTextHeight.text.toString()

        val validation = fieldValidation(weight, height)

        if (validation) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight", weight)
            intent.putExtra("height", height)

            startActivity(intent)
        }
    }

    private fun fieldValidation(weight: String, height: String): Boolean {
        textInputWeight.error = null
        textInputHeight.error = null

        if (weight.isEmpty()) {
            textInputWeight.error = "Digite o peso."
            return false
        }
        if (height.isEmpty()) {
            textInputHeight.error = "Digite a altura."
            return false
        }
        return true
    }
}
