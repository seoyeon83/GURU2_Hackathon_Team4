package com.example.brementownmusicians

import android.media.SoundPool
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PianoActivity : AppCompatActivity() {
    // soundpool 객체를 사용해 Builder()의 bulid() 메소드를 사용
    // setMaxStreams()를 사용해 가지고 올 수 있는 최대 음원 수 지정
    private val soundPool = SoundPool.Builder().setMaxStreams(8).build()
    private val sounds = listOf(
        Pair(R.id.piano_do1, R.raw.piano_do1),
        Pair(R.id.piano_re,R.raw.piano_re),
        Pair(R.id.piano_mi,R.raw.piano_mi),
        Pair(R.id.piano_fa,R.raw.piano_fa),
        Pair(R.id.piano_sol,R.raw.piano_sol),
        Pair(R.id.piano_la,R.raw.piano_la),
        Pair(R.id.piano_si,R.raw.piano_si),
        Pair(R.id.piano_do2,R.raw.piano_do2)
    )

    // listof() 함수를 사용하여 텍스트 뷰(또는 버튼)의 iD와 음원 파일의 리소스 ID를 연관지은 pair 객체 8개를 리스트 객체 sounds로 만든다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piano)
        // sounds 리스트를 forEach()함수를 사용하여 요소를 하나씩 꺼내서 tune()메서드에 전달
        sounds.forEach { turn(it) }
    }

    // tune()메서드는 Pair 객체를 받아서 load() 메소드로 음원의 id를 얻는다
    // findViewById() 메서드로 텍스트뷰(버튼)의 ID에 해당하는 뷰를 얻고 텍스트 뷰를 클릭했을 때 음원 재생
    private fun turn(pair:Pair<Int,Int>) {
        val soundId = soundPool.load(this, pair.second,1)
        findViewById<TextView>(pair.first).setOnClickListener {
            soundPool.play(soundId,1.0F,1.0F,0,0,1.0F)
        }

    }

    override fun onDestroy() {
        // 앱을 종료할 때는 반드시 release() 메서드를 호출하여 SoundPool 객체의 자원을 해제함
        super.onDestroy()
        soundPool.release()
    }
}