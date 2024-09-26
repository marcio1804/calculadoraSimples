package com.example.calculadorasimples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        textViewResult = findViewById(R.id.textViewResult)

        buttonAdd.setOnClickListener { realizarSoma() }
        buttonSubtract.setOnClickListener { realizarSubtracao() }
    }

    private fun realizarSoma() {
        val numero1 = editTextNumber1.text.toString().trim()
        val numero2 = editTextNumber2.text.toString().trim()

        if (numero1.isNotEmpty() && numero2.isNotEmpty()) {
            val resultado = numero1.toDoubleOrNull()?.let { n1 ->
                numero2.toDoubleOrNull()?.let { n2 ->
                    n1 + n2
                }
            }

            if (resultado != null) {
                textViewResult.text = String.format("Resultado: %.2f", resultado)
            } else {
                textViewResult.text = "Por favor, insira valores válidos."
            }
        } else {
            textViewResult.text = "Por favor, preencha ambos os campos."
        }
    }

    private fun realizarSubtracao() {
        val numero1 = editTextNumber1.text.toString().trim()
        val numero2 = editTextNumber2.text.toString().trim()

        if (numero1.isNotEmpty() && numero2.isNotEmpty()) {
            val resultado = numero1.toDoubleOrNull()?.let { n1 ->
                numero2.toDoubleOrNull()?.let { n2 ->
                    n1 - n2
                }
            }

            if (resultado != null) {
                textViewResult.text = String.format("Resultado: %.2f", resultado)
            } else {
                textViewResult.text = "Por favor, insira valores válidos."
            }
        } else {
            textViewResult.text = "Por favor, preencha ambos os campos."
        }
    }
}
