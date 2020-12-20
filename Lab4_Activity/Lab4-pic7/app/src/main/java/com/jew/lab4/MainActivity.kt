package com.jew.lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //判斷Intent不為空，並檢查是否夾帶資料
        data?.extras?.let {
            //驗證發出對象
            if (requestCode==1 && resultCode==Activity.RESULT_OK){
                    tv_return.text = it.getString("key")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnClickListener {
            val bundle = Bundle()   //宣告Bundle
            bundle.putInt("key1", 123)  //把123放入Bundle
            bundle.putString("key2", ed_message.text.toString())  //把ed_message內的文字放入Bundle
            //宣告意圖，透過Intent從MainActivity切換到MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle) //藉由Intent夾帶Bundle到新頁面
            //1) 使用startActivityForResult()方法啟動MainActivity2
            startActivityForResult(intent, 1)
        }
    }
}