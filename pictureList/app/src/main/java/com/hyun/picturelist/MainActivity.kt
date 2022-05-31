package com.hyun.picturelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image1 = findViewById<ImageView>(R.id.image_1)
        image1.setOnClickListener{
            Toast.makeText(this,"1번 클릭", Toast.LENGTH_LONG).show()

            //화면 이동
            val intent = Intent(this, FlowerActivity::class.java)
            startActivity(intent)
        }

    }
}