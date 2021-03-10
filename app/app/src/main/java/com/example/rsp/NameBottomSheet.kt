package com.example.rsp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.rsp.R.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NameBottomSheet: BottomSheetDialogFragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // LayoutTnflater 에서 xml 붙이고 return
        val root = inflater.inflate(layout.dialog_user_name,container,false);
        init(root)

        return root

    }

    private fun init(root: View?) {
        // id 값 연결
        val confirmBtn = root?.findViewById<Button>(R.id.btn_confirm)
        val nameEt = root?.findViewById<EditText>(R.id.editText)
        // 확인버튼을 눌렀을때
        confirmBtn?.setOnClickListener {
            val name:String = nameEt?.text.toString()
            // 번들객체에 name 값 담고
            val bundle:Bundle = Bundle();
            bundle.putString("userName",name)
            val fr = RspFragment();
            fr.arguments = bundle
            val activity = activity as MainActivity
            // 프레그먼트 트랜잭션
            activity.setFragment(fr)
            dismiss()



        }

    }
}