package com.jew.lab10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //啟動按鈕監聽事件
        btn_start.setOnClickListener {
            //啟動Service並結束MainActivity
            //使用startService，從目前Activity(this)啟動MyService
            startService(Intent(this, MyService::class.java))
            Toast.makeText(this, "啟動Service", Toast.LENGTH_SHORT).show()
            //關閉Activity
            finish()
        }
    }
}