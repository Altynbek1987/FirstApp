package com.example.firstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_change.*
import kotlinx.android.synthetic.main.activity_main.*

class ChangeActivity : AppCompatActivity() {
    private var data:String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)
        getIntentData()
        returnDataAction()
    }
    private fun getIntentData(){
        data = intent.getStringExtra("text")
        edit_change.setText(data)
    }
    private fun returnDataAction(){
        btn_change.setOnClickListener {
            val newData = edit_change.text.toString()
            if (newData == data) this.showToast("Поменяйте данные")
            else returnData(newData)
        }
    }
    private fun returnData(data: String) {
        val editdata =edit_change.text.toString().trim()
        if (editdata.isEmpty()){
            //Проверка на пустоту
            inputLayout_change.isErrorEnabled = true
            inputLayout_change.error = "error"
            this.showToast("Введите данные")
        }else{
            val intent = Intent()
            intent.putExtra("result",data)
            setResult(Activity.RESULT_OK,intent)
            inputLayout_change.isErrorEnabled = false
            finish()
        }


    }
}