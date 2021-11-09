package com.example.adrianmaciejhelloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.bmi_layout.*
import kotlinx.android.synthetic.main.dice_thrower.*

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_layout)
    }

    fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun calculateBmi(view: android.view.View) {
        hideKeyboard()
        val weight: Float
        val height: Float
        try {
            weight = user_weight_kg.text.toString().toFloat()
        } catch (_: NumberFormatException) {
            var toast = Toast.makeText(this, "Improper format of weight", Toast.LENGTH_LONG)
            toast.show()
            return
        }
        try {
            height = user_height_cm.text.toString().toFloat()
        } catch (_: NumberFormatException) {
            var toast = Toast.makeText(this, "Improper format of height", Toast.LENGTH_LONG)
            toast.show()
            return
        }

        if(weight < 0)
        {
            var toast = Toast.makeText(this, "Weight cannot be less than 0", Toast.LENGTH_LONG)
            toast.show()
        }
        if(height < 0)
        {
            var toast = Toast.makeText(this, "Height cannot be less than 0", Toast.LENGTH_LONG)
            toast.show()
        }

        val bmi = weight * 10000f / (height*height)
        Log.i("MyApp", "Calculated bmi: $bmi")
        when {
            bmi < 18.5f -> bmi_image_outcome.setImageResource(R.drawable.underweight)
            bmi < 24.9f -> bmi_image_outcome.setImageResource(R.drawable.healthy)
            bmi < 29.9f -> bmi_image_outcome.setImageResource(R.drawable.overweight)
            else -> bmi_image_outcome.setImageResource(R.drawable.obesity)
        }
    }
}