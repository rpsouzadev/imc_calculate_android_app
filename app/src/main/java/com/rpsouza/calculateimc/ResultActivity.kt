package com.rpsouza.calculateimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var textWeight: TextView
    private lateinit var textHeight: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initializeInterfaceComponents()
        showResult()
    }

    private fun initializeInterfaceComponents() {
        textWeight = findViewById(R.id.text_weight)
        textHeight = findViewById(R.id.text_height)
        textResult = findViewById(R.id.text_result)
    }

    private fun showResult() {
        val extras = intent.extras

        if (extras != null) {
            val weight = extras.getString("weight")
            val height = extras.getString("height")

            if (weight != null && height != null) {
                val newTextWeight = "Peso informado $weight kg"
                textWeight.text = newTextWeight


                val newTextHeight = "Altura informada $height m"
                textHeight.text = newTextHeight

                imcValidation(weight, height)
            }
        }
    }

    private fun imcValidation(weight: String, height: String) {
        val weightFloat = weight.toFloat()
        val heightFloat = height.toFloat()

        val imc = weightFloat / (heightFloat * heightFloat)

        val result = if (imc < 18.5) {
            "Baixo"
        } else if (imc in 18.5..24.9) {
            "Normal"
        } else if (imc in 25.0..29.9) {
            "Sobrepeso"
        } else {
            "Obesidade"
        }

        textResult.text = result
    }
}