package com.jew.lab11

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //1) 建立BroadcastReceiver物件
    private val receiver: BroadcastReceiver = object : BroadcastReceiver(){
        //2) 在onReceive()中加入接收廣播後要執行的動作
        override fun onReceive(context: Context, intent: Intent) {
            //用Toast顯示訊息通知
            Toast.makeText(context, "螢幕亮起", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //3) 建立IntentFilter物件來指定要接收的廣播(螢幕解鎖事件)
        val intentFilter = IntentFilter(Intent.ACTION_SCREEN_ON)
        //4) 註冊Receiver
        registerReceiver(receiver, intentFilter)
    }
}