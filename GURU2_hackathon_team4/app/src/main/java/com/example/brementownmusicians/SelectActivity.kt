package com.example.brementownmusicians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectActivity : AppCompatActivity() {
    lateinit var pianoBtn : Button      // 피아노
    lateinit var drumBtn : Button       // 드럼
    lateinit var elecBtn : Button       // 일렉기타
    lateinit var acousticBtn : Button   // 통기타
    
    lateinit var storyBtn : Button      // 스토리 보러가기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        pianoBtn = findViewById(R.id.pianoBtn)
        drumBtn = findViewById(R.id.drumBtn)
        elecBtn = findViewById(R.id.elecBtn)
        acousticBtn = findViewById(R.id.acousticBtn)
        storyBtn = findViewById(R.id.storyBtn)

        // 각 버튼 클릭 시, 맞는 화면으로 이동(activity 시작)
        
        // 피아노
        pianoBtn.setOnClickListener {
            val intent = Intent(this, PianoActivity::class.java)
            startActivity(intent)
        }
        
        // 드럼
        drumBtn.setOnClickListener {
            val intent = Intent(this, DrumActivity::class.java)
            startActivity(intent)
        }

        // 일렉기타
        elecBtn.setOnClickListener {
            val intent = Intent(this, ElecActivity::class.java)
            startActivity(intent)
        }

        // 통기타
        acousticBtn.setOnClickListener {
            val intent = Intent(this, AcousticActivity::class.java)
            startActivity(intent)
        }

        // 스토리 보러가기
        storyBtn.setOnClickListener {
            val intent = Intent(this, StoryActivity::class.java)
            startActivity(intent)
        }
    }
}