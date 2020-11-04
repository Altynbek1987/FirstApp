package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private var editdata:String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendAction()
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
        when(requestCode){
           0-> if (resultCode == Activity.RESULT_OK)edit.setText(data?.getStringExtra("result"))
        }
    }
}