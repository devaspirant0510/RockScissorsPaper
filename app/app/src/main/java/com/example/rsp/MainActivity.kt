package com.example.rsp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.start_btn);
        // 시작 버튼 눌렀을떄 바텀시트 다디얼로그 띄움
        startBtn.setOnClickListener {
            val dialog: CustomBottomSheet = CustomBottomSheet(applicationContext)

            dialog.show(supportFragmentManager, "MainActivity");
        }


    }

    // 프레그먼트를 파라미터로 받아 메인화면에 트랜잭션해주는 함수
    fun setFragment(fragment: Fragment) {

        val ft = supportFragmentManager.beginTransaction()
        val fr = RspFragment();
        ft.replace(R.id.frame, fr).commit()

    }


}