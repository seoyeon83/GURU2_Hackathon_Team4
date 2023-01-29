package com.example.brementownmusicians

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    
    lateinit var gotoSelectBtn: Button  // 연주하러 가기 버튼
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gotoSelectBtn = findViewById(R.id.gotoSelectBtn)
        
        // 연주하러 가기 버튼 클릭 시, 악기 선택 화면(Activity) 시작
        gotoSelectBtn.setOnClickListener {
            val intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)
        }
    }
}