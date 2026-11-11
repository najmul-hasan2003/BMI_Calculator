package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var maleImage: CircleImageView
    private lateinit var femaleImage: CircleImageView
    private lateinit var maleText: TextView
    private lateinit var femaleText: TextView
    private lateinit var continueBtn: Button

    private var selectedGender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect XML with Kotlin

        maleImage = findViewById(R.id.maleImage)
        femaleImage = findViewById(R.id.femaleImage)
        maleText = findViewById(R.id.maleText)
        femaleText = findViewById(R.id.femaleText)
        continueBtn = findViewById(R.id.continueBtn)

        // Male Selection

        maleImage.setOnClickListener {

            selectedGender = "Male"

            maleImage.alpha = 1f
            femaleImage.alpha = 0.4f

            maleText.alpha = 1f
            femaleText.alpha = 0.4f
        }

        // Female Selection

        femaleImage.setOnClickListener {

            selectedGender = "Female"

            femaleImage.alpha = 1f
            maleImage.alpha = 0.4f

            femaleText.alpha = 1f
            maleText.alpha = 0.4f
        }

        // Continue Button

        continueBtn.setOnClickListener {

            if (selectedGender.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please select Male or Female",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val intent = Intent(this, SecondActivity::class.java)

                intent.putExtra("gender", selectedGender)

                startActivity(intent)
            }
        }
    }
}
