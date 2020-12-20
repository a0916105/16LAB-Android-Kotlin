package com.jew.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //宣告意圖，透過Intent從MainActivity切換到MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("key", 123) //藉由Intent夾帶資料到新頁面
            startActivity(intent)                    //開始動作
        }
    }
}