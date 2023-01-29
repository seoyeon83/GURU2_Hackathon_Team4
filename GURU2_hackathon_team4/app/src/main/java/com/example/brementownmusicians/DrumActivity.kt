package com.example.brementownmusicians

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DrumActivity : AppCompatActivity() {
    // soundpool 객체를 사용해 Builder()의 bulid() 메소드를 사용
    // setMaxStreams()를 사용해 가지고 올 수 있는 최대 음원 수 지정
    private val soundPool = SoundPool.Builder().setMaxStreams(6).build()
    private val sounds = listOf(
        Pair(R.id.drum1, R.raw.drum_crash),
        Pair(R.id.drum2, R.raw.drum_ride),
        Pair(R.id.drum3, R.raw.drum_snare),
        Pair(R.id.drum4, R.raw.drum_kick),
        Pair(R.id.drum5, R.raw.drum_tomtom),
        Pair(R.id.handstick, R.raw.drum_stick)
    )

    // listof() 함수를 사용하여 텍스트 뷰(또는 버튼)의 iD와 음원 파일의 리소스 ID를 연관지은 pair 객체 6개를 리스트 객체 sounds로 만든다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drum)
        // sounds 리스트를 forEach()함수를 사용하여 요소를 하나씩 꺼내서 tune()메서드에 전달
        sounds.forEach { turn(it) }
    }

    // tune()메서드는 Pair 객체를 받아서 load() 메소드로 음원의 id를 얻는다
    // findViewById() 메서드로 텍스트뷰(버튼)의 ID에 해당하는 뷰를 얻고 텍스트 뷰를 클릭했을 때 음원 재생
    private fun turn(pair: Pair<Int, Int>) {
        val soundId = soundPool.load(this, pair.second, 1)
        findViewById<TextView>(pair.first).setOnClickListener {
            soundPool.play(soundId, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    override fun onDestroy() {
        // 앱을 종료할 때는 반드시 release() 메서드를 호출하여 SoundPool 객체의 자원을 해제함
        super.onDestroy()
        soundPool.release()
    }
}

