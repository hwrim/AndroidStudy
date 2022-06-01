package com.hyun.imagelistsplash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val data = intent.getStringExtra("data")
        val img = findViewById<ImageView>(R.id.flowerArea)
        if(data == "1"){
            img.setImageResource(R.drawable.flower_1);
        }
        if(data =="2"){
            img.setImageResource(R.drawable.flower_2);
        }
    }
}