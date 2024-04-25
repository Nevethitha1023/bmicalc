package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalculator.ui.theme.BmicalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val weightStr = weightEditText.text.toString()
            val heightStr = heightEditText.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toDouble()
                val height = heightStr.toDouble()

                val bmi = calculateBMI(weight, height)
                resultTextView.text = "Your BMI is: %.2f".format(bmi)
            } else {
                resultTextView.text = "Please enter both weight and height."
            }
        }
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        // BMI formula: weight (kg) / (height (m) * height (m))
        return weight / (height * height)
    }
}