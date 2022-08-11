package com.android.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// This is the main activity for the dice app.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        //do a roll on app start up
        rollDice()
    }

    private fun rollDice() {
        //create new Dice object with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //determine which image to display based on the roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //set the image to the drawable resource
        diceImage.setImageResource(drawableResource)
        //set the content description to the roll
        diceImage.contentDescription = diceRoll.toString()
    }
}


// Create a class called Dice
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}