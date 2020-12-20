package com.jew.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent?.extras?.let {                   //判斷Intent不為空，並檢查是否夾帶資料
            val data = it.getInt("key")    //以key標籤找到對應的資料並取出
        }
    }
}