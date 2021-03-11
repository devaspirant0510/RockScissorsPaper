package com.example.rsp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class RspFragment: Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = arguments?.getInt("winScore")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_rsp,container,false);
        init(root)
        return root;
    }

    private fun init(root: View?) {
        // 화면에 있는 뷰를 findVidwById 로 연결
        val scissor = root?.findViewById<ImageButton>(R.id.btn_scissor)
        val rock = root?.findViewById<ImageButton>(R.id.btn_rock)
        val paper = root?.findViewById<ImageButton>(R.id.btn_paper)
        val winScore: TextView? = root?.findViewById<TextView>(R.id.win_score)
        val loseScore: TextView? = root?.findViewById<TextView>(R.id.lose_score)
        val drawScore: TextView? = root?.findViewById<TextView>(R.id.draw_score)
        // 가위 바위 보를 누르는거에 따라 콜백 메스드를 실행시키고
        // 승리,무승부,패배를 업데이트하기 위해 파라미터로 전달
        rock?.setOnClickListener{
            val dialog:ResultDialog = ResultDialog(Define.ROCK,winScore!!,loseScore!!, drawScore!!)
            dialog.show(activity!!.supportFragmentManager,"s");
        }
        scissor?.setOnClickListener {
            val dialog:ResultDialog = ResultDialog(Define.SICSSOR,winScore!!,loseScore!!, drawScore!!)
            dialog.show(activity!!.supportFragmentManager,"s");
        }
        paper?.setOnClickListener {
            val dialog:ResultDialog = ResultDialog(Define.PAPER,winScore!!,loseScore!!, drawScore!!)

            dialog.show(activity!!.supportFragmentManager,"s");

        }



    }

}