package com.jew.lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent?.extras?.let {                   //判斷Intent不為空，並檢查是否夾帶資料
            val value1 = it.getInt("key1")    //以key標籤找到對應的資料並取出
            val value2 = it.getString("key2")

            btn_getData.setOnClickListener {
                ed_getMessage.setText(value2)
            }
            btn_exit.setOnClickListener {
                val bundle = Bundle()   //宣告Bundle
                bundle.putString("key", ed_getMessage.text.toString())  //把ed_getMessage內的文字放入Bundle
                val i = Intent().putExtras(bundle)  //夾帶Bundle
                //2) 使用setResult()方法儲存要返回資料
                setResult(Activity.RESULT_OK, i)
                finish()    //3) 使用finish()方法結束MainActivity2，並返回MainActivity
            }
        }
    }
}