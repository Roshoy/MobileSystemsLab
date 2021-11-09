package com.example.adrianmaciejhelloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun runTestActionsActivity(view: android.view.View) {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun runGameActivity(view: android.view.View) {
        var intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    fun runDiceRollActivity(view: android.view.View) {
        var intent = Intent(this, RollDiceActivity::class.java)
        startActivity(intent)
    }

    fun runBmiActivity(view: android.view.View) {
        var intent = Intent(this, BmiActivity::class.java)
        startActivity(intent)
    }
}