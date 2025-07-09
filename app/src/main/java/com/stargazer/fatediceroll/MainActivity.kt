package com.stargazer.fatediceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val battomimage: ImageView= findViewById(R.id.imageView8)
        battomimage.showContextMenu()

        val rollbutton: Button = findViewById(R.id.button_roll)
        rollDice()
        val rollbutton3: Button = findViewById(R.id.button_roll)
        rollDice()
        val rollbutton2: Button = findViewById(R.id.button_roll)
        rollDice()
        rollbutton.setOnClickListener {
            //rollDice()


            val diceImage: ImageView = findViewById(R.id.imageView)
            val diceImage2: ImageView = findViewById(R.id.imageView2)
            val diceImage3: ImageView = findViewById(R.id.imageView3)
            val diceImage4: ImageView = findViewById(R.id.imageView4)

            animateDice(listOf(diceImage, diceImage2, diceImage3, diceImage4)) {
                rollDice()
            }

        }
    }

    private fun rollDice() {
        val diceMA = Dice(6)
        val diceMA2 = Dice(6)
        val diceMA3 = Dice(6)
        val diceMA4 = Dice(6)

        val cubeRoll = diceMA.rolldice()
        val cubeRoll2 = diceMA2.rolldice()
        val cubeRoll3 = diceMA3.rolldice()
        val cubeRoll4 = diceMA4.rolldice()

        //val fakezarmız: TextView = findViewById(R.id.fakezar)
        //fakezarmız.text= cubeRoll.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val diceImage3: ImageView = findViewById(R.id.imageView3)
        val diceImage4: ImageView = findViewById(R.id.imageView4)
        val buttonimage : ImageView= findViewById(R.id.imageView8)
        buttonimage.setImageResource(R.drawable.newbutton)
        /*val battomimamge : ImageView = findViewById(R.id.imageView6)
        battomimamge.setImageResource(R.drawable.bottom)*/


        when (cubeRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice1)
            2 -> diceImage.setImageResource(R.drawable.dice2)
            3 -> diceImage.setImageResource(R.drawable.dice3)
            4 -> diceImage.setImageResource(R.drawable.dice4)
            5 -> diceImage.setImageResource(R.drawable.dice5)
            6 -> diceImage.setImageResource(R.drawable.dice6)
        }

        when (cubeRoll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice1)
            2 -> diceImage2.setImageResource(R.drawable.dice2)
            3 -> diceImage2.setImageResource(R.drawable.dice3)
            4 -> diceImage2.setImageResource(R.drawable.dice4)
            5 -> diceImage2.setImageResource(R.drawable.dice5)
            6 -> diceImage2.setImageResource(R.drawable.dice6)
        }

        when (cubeRoll3) {
            1 -> diceImage3.setImageResource(R.drawable.dice1)
            2 -> diceImage3.setImageResource(R.drawable.dice2)
            3 -> diceImage3.setImageResource(R.drawable.dice3)
            4 -> diceImage3.setImageResource(R.drawable.dice4)
            5 -> diceImage3.setImageResource(R.drawable.dice5)
            6 -> diceImage3.setImageResource(R.drawable.dice6)
        }

        when (cubeRoll4) {
            1 -> diceImage4.setImageResource(R.drawable.dice1)
            2 -> diceImage4.setImageResource(R.drawable.dice2)
            3 -> diceImage4.setImageResource(R.drawable.dice3)
            4 -> diceImage4.setImageResource(R.drawable.dice4)
            5 -> diceImage4.setImageResource(R.drawable.dice5)
            6 -> diceImage4.setImageResource(R.drawable.dice6)
        }
    }


    private fun animateDice (diceViews: List<ImageView>, onAnimationEnd: () -> Unit ) {
        val handler = android.os.Handler(android.os.Looper.getMainLooper())
        val diceFaces = listOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )

        var count = 0
        val maxCount = 10
        val runnable = object : Runnable {
            override fun run() {
                for (view in diceViews) {
                    val randomFace = diceFaces.random()
                    view.setImageResource(randomFace)
                }

                count++
                if (count < maxCount) {
                    handler.postDelayed(this, 50)
                } else {
                    onAnimationEnd()
                }

            }

        }
        handler.post(runnable)
    }

    class Dice (val numSidesMA: Int) {
        fun rolldice(): Int {
            return (1..numSidesMA).random()
        }
    }


}