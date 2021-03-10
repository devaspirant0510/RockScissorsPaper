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
        // 컴퓨터가 낸값을 랜덤으로 설정
        val comRand = rand(-1,2)
        // 내가 낸 값과 컴퓨터가 낸값으로 승리여뷰 판단
        val state = check(this.you,comRand)
        // 결과값을 보여줄 텍스트 뷰 아이디값 연결
        resultTv = view.findViewById<TextView>(R.id.result)
        // 상태값을 받아와 텍스트 뷰에 적용 -> UI 연결
        updateStateMessage(state)
        // 이미지 뷰 적용 -> UI 연결
        updateUi(view,this.you,comRand)

        // 버튼 눌렀을때 다이얼로그 종료
        val exit:Button = view.findViewById<Button>(R.id.exit)
        exit.setOnClickListener{
            dismiss()
        }



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
        return if (checkNum==1 && checkNum == -2){
            Define.WIN
        } else{
            Define.LOSE
        }

    }
    private fun rand(start: Int, end: Int) : Int {
        // 기본적으로 nextInt(n) 일경우 0,1,... n-1
        return random.nextInt(end - start) + start
    }
}
