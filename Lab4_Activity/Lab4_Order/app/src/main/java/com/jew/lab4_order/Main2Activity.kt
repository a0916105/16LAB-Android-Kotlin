package com.jew.lab4_order

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //『送出』按鈕點擊監聽
        btn_send.setOnClickListener {
            //判斷使用者是否輸入飲料名稱
            if(ed_drink.length()<1)
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            else{
                //宣告Bundle
                val b = Bundle()
                //取得EditText字串內容，並將飲料名稱、甜度、冰塊放入Bundle
                b.putString("drink", ed_drink.text.toString())
                b.putString("sugar", radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice", radioGroup2.findViewById<RadioButton>(radioGroup2.checkedRadioButtonId).text.toString())
                //透過setResult將資料回傳
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                //結束Main2Activity
                finish()
            }
        }
    }
}