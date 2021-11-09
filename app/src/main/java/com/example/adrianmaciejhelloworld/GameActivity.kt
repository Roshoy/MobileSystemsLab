package com.example.adrianmaciejhelloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun compareNumbers(view: android.view.View) {
        hideKeyboard()
        val userValue: Int
        try {
            userValue = Integer.parseInt(player_number_editText.text.toString())
        } catch (_: NumberFormatException)
        {
            outcome_of_game.setText(getString(R.string.game_value_error_msg))
            return
        }

        if (userValue < 1 || userValue > 10) {
            outcome_of_game.setText(getString(R.string.game_value_error_msg))
            return
        }
        val computerValue = Random.nextInt(1,11)
        computer_outcome_game.setText(computerValue.toString())
        if (userValue == computerValue)
            outcome_of_game.setText("You win!")
        else
            outcome_of_game.setText("You loose!")
    }
}