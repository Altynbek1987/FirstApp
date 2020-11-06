package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(){
    private var dataFromEditChange:String?=""
    private var list=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendAction()
        textSave()
    }
    private fun sendAction(){
        btn_main.setOnClickListener {
            val editdata =edit.text.toString().trim()
            if (editdata.isEmpty()) {
                //Проверка на пустоту
                inputLayout_main.isErrorEnabled = true
                inputLayout_main.error = "error"
                this.showToast("Введите данные")
            }else{
                val intent = Intent(this,ChangeActivity::class.java)
                intent.putExtra("text",edit.text.toString())
                startActivityForResult(intent,0)
                inputLayout_main.isErrorEnabled = false
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var dataFromEditChange=data?.getStringExtra("result")
        when(requestCode){
           0-> if (resultCode == Activity.RESULT_OK)edit.setText(data?.getStringExtra("result"))
        }
        list.add(dataFromEditChange.toString())
        text_text.text = list.toString()
        text_text.visibility=View.GONE
    }
    private fun textSave(){
        btn_Show.setOnClickListener {
            if (text_text!=null){
                text_text.visibility= View.VISIBLE
            }else{
                text_text.error = "error"
            }
        }
    }
}