package com.example.brementownmusicians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var pianoBtn : Button
    lateinit var drumBtn : Button
    lateinit var elecBtn : Button
    lateinit var acousticBtn : Button
    lateinit var storyBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pianoBtn = findViewById(R.id.pianoBtn)
        drumBtn = findViewById(R.id.drumBtn)
        elecBtn = findViewById(R.id.elecBtn)
        acousticBtn = findViewById(R.id.acousticBtn)
        storyBtn = findViewById(R.id.storyBtn)

        // 각 버튼 클릭 시, 맞는 화면으로 이동
        pianoBtn.setOnClickListener {
            val intent = Intent(this, PianoActivity::class.java)
            startActivity(intent)
        }

        drumBtn.setOnClickListener {
            val intent = Intent(this, DrumActivity::class.java)
            startActivity(intent)
        }

        elecBtn.setOnClickListener {
            val intent = Intent(this, ElecActivity::class.java)
            startActivity(intent)
        }

        acousticBtn.setOnClickListener {
            val intent = Intent(this, AcousticActivity::class.java)
            startActivity(intent)
        }

        storyBtn.setOnClickListener {
            val intent = Intent(this, StoryActivity::class.java)
            startActivity(intent)
        }
    }
}