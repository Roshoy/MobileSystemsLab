package com.example.adrianmaciejhelloworld

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dice_thrower.*
import java.util.*
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.schedule
import kotlin.random.Random

class RollDiceActivity : AppCompatActivity() {
    private var dice1Value: Int = 1
    private var dice2Value: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dice_thrower)
    }

    fun rollDice(view: android.view.View) {
        delayedRandomization(5)
    }

    private fun calculateGameOutcome() {
        val userValue: Int
        try {
            userValue = Integer.parseInt(player_number_dice_editText.text.toString())
        } catch (_: NumberFormatException) {
            outcome_of_game_dice.text = "You loose!"
            return
        }

        if (userValue < 1 || userValue > 12) {
            outcome_of_game_dice.text = "You loose!"
            return
        }
        val computerValue = dice1Value + dice2Value
        outcome_of_game_dice.text = computerValue.toString()
        if (userValue == computerValue)
            outcome_of_game_dice.text = "You win!"
        else
            outcome_of_game_dice.text = "You loose!"

    }

    private fun delayedRandomization(depth: Int) {
        if (depth == 0) {
            calculateGameOutcome()
        } else
            Timer().schedule(100) {
                dice1Value = randomizeDiceImage(dice1)
                dice2Value = randomizeDiceImage(dice2)
                delayedRandomization(depth - 1)
            }
    }

    private fun randomizeDiceImage(dice: ImageView) : Int {
        val random = Random.nextInt(1,7)
        when (random) {
            1 -> dice.setImageResource(R.drawable.dice1)
            2 -> dice.setImageResource(R.drawable.dice2)
            3 -> dice.setImageResource(R.drawable.dice3)
            4 -> dice.setImageResource(R.drawable.dice4)
            5 -> dice.setImageResource(R.drawable.dice5)
            6 -> dice.setImageResource(R.drawable.dice6)
        }
        return random
    }
}