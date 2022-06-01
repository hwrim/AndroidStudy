package com.hyun.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hyun.dice.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dice1 = binding.dice1
        val dice2 = binding.dice2

        binding.diceBtn.setOnClickListener {
            Toast.makeText(this,"주사위 돌림",Toast.LENGTH_LONG).show()

            var num1 = Random.nextInt(1,7)
            var num2 = Random.nextInt(1,7)

            val result1 : Int = when (num1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            val result2 : Int = when (num2) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            dice1.setImageResource(result1)
            dice2.setImageResource(result2)


        }

    }
}