package com.example.brementownmusicians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StoryActivity : AppCompatActivity() {
    lateinit var backBtn : Button   // 연주하러 돌아가기 버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        backBtn = findViewById<Button>(R.id.gotoSelectBtn)

        // 연주하러 돌아가기 버튼 클릭 시, 악기 선택 activity 시작
        backBtn.setOnClickListener {
            val intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)
        }

    }
}
