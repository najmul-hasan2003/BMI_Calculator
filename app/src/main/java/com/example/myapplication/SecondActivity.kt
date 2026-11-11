package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var editheight: EditText
    private lateinit var editweight: EditText
    private lateinit var continueBtn: Button

    private var selectedGender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)



        editheight = findViewById(R.id.editheight)
        editweight = findViewById(R.id.editweight)
        continueBtn = findViewById(R.id.continueBtn)


        selectedGender = intent.getStringExtra("gender") ?: ""

//Continue Button working

        continueBtn.setOnClickListener {


            val height = editheight.text.toString()


            val weight = editweight.text.toString()

            if (height.isEmpty()) {
                editheight.error = "Please enter height"
                return@setOnClickListener
            }


            if (weight.isEmpty()) {
                editweight.error = "Please enter weight"
                return@setOnClickListener
            }

            val heightValue = height.toDoubleOrNull()
            val weightValue = weight.toDoubleOrNull()

            if (heightValue == null || heightValue <= 0) {
                editheight.error = "Enter a valid height"
                return@setOnClickListener
            }

            if (weightValue == null || weightValue <= 0) {
                editweight.error = "Enter a valid weight"
                return@setOnClickListener
            }
            if (selectedGender == "Male") {

                val intent = Intent(this, Male::class.java)

                intent.putExtra("height", heightValue.toString())
                intent.putExtra("weight", weightValue.toString())

                startActivity(intent)

            } else if (selectedGender == "Female") {

                val intent = Intent(this, Female::class.java)

                intent.putExtra("height", heightValue.toString())
                intent.putExtra("weight", weightValue.toString())

                startActivity(intent)
            }

        }

        fun calculateBMI(height: Double, weight: Double): Double {
            val heightInMeter = height / 100
            return weight / (heightInMeter * heightInMeter)
        }

    }

}
