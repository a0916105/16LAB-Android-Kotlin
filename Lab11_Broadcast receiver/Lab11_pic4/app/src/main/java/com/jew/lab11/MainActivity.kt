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
            intent.extras?.let {
                //解析Intent取得字串訊息，並用Toast顯示訊息通知
                Toast.makeText(context, "剛剛傳入的是" +
                        "${it.getString("msg", "null")}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //3) 建立IntentFilter物件來指定要接收的識別字串MyMessage
        val intentFilter = IntentFilter("MyMessage")
        //4) 註冊Receiver
        registerReceiver(receiver, intentFilter)

        //自行觸發自訂廣播
        val intent = Intent("MyMessage")    //識別字串
        sendBroadcast(intent.putExtra("msg", "data"))   //對Receive發送Intent
    }
}