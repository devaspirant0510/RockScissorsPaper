package com.example.rsp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ResultDialog(var you: Int) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.result_layout,container,false)
        init(view)
        return view

    }

    private fun init(view: View) {
        Toast.makeText(context,"dd",Toast.LENGTH_SHORT).show()


    }
}
