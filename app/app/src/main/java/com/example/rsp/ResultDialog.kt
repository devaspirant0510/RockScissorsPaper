package com.example.rsp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import java.util.Random
import java.util.logging.Level

class ResultDialog(var you: Int) : DialogFragment() {
    private val random = Random()
    private var resultTv: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.result_layout,container,false)
        init(view)
        return view

    }

    private fun init(view: View) {
        val comRand = rand(-1,2)
        val state = check(this.you,comRand)
        resultTv = view.findViewById<TextView>(R.id.result)
        val exit:Button = view.findViewById<Button>(R.id.exit)
        exit.setOnClickListener{
            dismiss()
        }
        updateStateMessage(state)

        updateUi(view,this.you,comRand)




    }
    private fun updateStateMessage(state: Int){
        if (state == Define.LOSE){
            resultTv?.text = "졌다"
        }
        else if (state == Define.WIN){
            resultTv?.text ="이겼다"
        }
        else{
            resultTv?.text = "무승부"
        }
    }
    private fun checkImg(num:Int): Int {
        if (num==-1){
            return R.drawable.r
        }
        else if (num==0){
            return R.drawable.s
        }
        else{
            return R.drawable.p
        }
    }
    private fun updateUi(view:View,you: Int,com: Int){
        val comImg = view.findViewById<ImageButton>(R.id.com_img)
        val myImg = view.findViewById<ImageButton>(R.id.my_img)
        comImg?.setBackgroundResource(checkImg(com))
        myImg?.setBackgroundResource(checkImg(you))



    }

    // 자바스크립트 로직 참고
    private fun check(user:Int,com:Int):Int{
        if (user==com){
            return Define.DRAW
        }

        val checkNum:Int = user-com
        Toast.makeText(context,checkNum.toString(),Toast.LENGTH_SHORT).show()
        if (checkNum==1 && checkNum == -2){
            return Define.WIN
        }
        else{
            return Define.LOSE
        }

    }
    private fun rand(start: Int, end: Int) : Int {
        // 기본적으로 nextInt(n) 일경우 0,1,... n-1

        return random.nextInt(end - start) + start
    }
}
