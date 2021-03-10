package com.example.rsp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.start_btn);

        startBtn.setOnClickListener {
            val dialog : NameBottomSheet = NameBottomSheet()
            dialog.show(supportFragmentManager,"d")
        }


    }

    public fun aa (){

    }
    public fun setFragment(fragment: Fragment){

        val ft = supportFragmentManager.beginTransaction()
        val fr = RspFragment();
        ft.replace(R.id.frame,fr).commit()

    }
    class Builder(context:Context){

    }
}