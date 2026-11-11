package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Male : AppCompatActivity() {

    private lateinit var bmiValue: TextView
    private lateinit var bmiStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_male)

        // Connect XML TextViews
        bmiValue = findViewById(R.id.bmiValue)
        bmiStatus = findViewById(R.id.bmiStatus)

        // Receive Height and Weight
        val height = intent.getStringExtra("height")?.toDoubleOrNull()
        val weight = intent.getStringExtra("weight")?.toDoubleOrNull()

        // Calculate BMI
        if (height != null && weight != null && height > 0 && weight > 0) {

            val bmi = calculateBMI(height, weight)

            bmiValue.text = String.format("%.2f", bmi)

            // BMI Status
            bmiStatus.text = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25.0 -> "Normal"
                bmi < 30.0 -> "Overweight"
                else -> "Obese"
            }

        }
    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        val heightInMeter = height / 100
        return weight / (heightInMeter * heightInMeter)
    }
}
