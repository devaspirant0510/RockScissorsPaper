package com.example.rsp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class RspFragment: Fragment(){
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
        val scissor = root?.findViewById<ImageButton>(R.id.btn_scissor)
        val rock = root?.findViewById<ImageButton>(R.id.btn_rock)
        val paper = root?.findViewById<ImageButton>(R.id.btn_paper)
        val winScore:Int = root?.findViewById<TextView>(R.id.win_score)?.text.toString().toInt()
        val loseScore:Int = root?.findViewById<TextView>(R.id.lose_score)?.text.toString().toInt()
        val drawScore:Int = root?.findViewById<TextView>(R.id.draw_score)?.text.toString().toInt()

        rock?.setOnClickListener{
            val dialog:ResultDialog = ResultDialog(Define.ROCK)

            dialog.show(activity!!.supportFragmentManager,"s");
        }
        scissor?.setOnClickListener {
            val dialog:ResultDialog = ResultDialog(Define.SICSSOR)

            dialog.show(activity!!.supportFragmentManager,"s");
        }
        paper?.setOnClickListener {
            val dialog:ResultDialog = ResultDialog(Define.PAPER)

            dialog.show(activity!!.supportFragmentManager,"s");

        }



    }

    override fun onPause() {
        super.onPause()
        Log.e("dd", "onPause:" )
    }

    override fun onStop() {
        super.onStop()
        Log.e("sd","onStop")
    }

}