package com.jew.lab9_1

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //建立兩個計數暫存，用於計算烏龜與兔子的進度
    private var rabprogress = 0 //兔子
    private var torprogress = 0 //烏龜

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //開始按鈕監聽事件
        btn_start.setOnClickListener {
            //關閉Button
            btn_start.isEnabled = false
            //初始化兔子的暫存與SeekBar
            rabprogress = 0
            seekBar.progress = 0
            //初始化烏龜的暫存與SeekBar
            torprogress = 0
            seekBar2.progress = 0
            //執行龜兔賽跑
            //執行副程式來執行Thread
            runThread()
            //執行副程式來執行AsyncTask
            runAsyncTask()
        }
    }

    //編寫一個Thread來模擬兔子移動
    private fun runThread() {
        object : Thread() {
            override fun run() {
                //重複執行到計數器不小於100為止
                while (rabprogress < 100 && torprogress < 100)
                    try {
                        //延遲100ms
                        sleep(100)
                        //隨機增加計數器0~2的值
                        rabprogress += (Math.random() * 3).toInt()
                        //建立Message物件
                        val msg = Message()
                        //加入代號
                        msg.what = 1
                        //透過sendMessage傳送訊息
                        mHandler.sendMessage(msg)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
            }
        }.start()   //執行Thread
    }

    //建立Handler物件等待接收訊息
    private val mHandler = Handler(Handler.Callback { msg ->
        when (msg.what) {
            //判斷代號，寫入計數器數值到SeekBar
            1 -> {
                seekBar.progress = rabprogress
                //重複執行到計數器大於等於100為止
                if (rabprogress >= 100 && torprogress < 100) {
                    //用Toast顯示兔子勝利
                    Toast.makeText(this, "兔子勝利", Toast.LENGTH_SHORT).show()
                    //啟動Button
                    btn_start.isEnabled = true
                }
            }
        }
        true
    })

    @SuppressLint("StaticFieldLeak")
    //編寫一個AsyncTask來模擬烏龜移動
    private fun runAsyncTask() {
        object : AsyncTask<Void, Int, Boolean>() {
            override fun doInBackground(vararg voids: Void): Boolean? {
                //重複執行到計數器大於100為止
                while (torprogress < 100 && rabprogress < 100)
                    try {
                        //延遲100ms
                        Thread.sleep(100)
                        //隨機增加計數器0~2的值
                        torprogress += (Math.random() * 3).toInt()
                        //更新進度條進度，傳入烏龜計數器
                        publishProgress(torprogress)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                return true
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                values[0]?.let {
                    //寫入計數器數值到SeekBar
                    seekBar2.progress = it
                }
            }

            override fun onPostExecute(status: Boolean?) {
                if (torprogress >= 100 && rabprogress < 100) {
                    //用Toast顯示烏龜勝利
                    Toast.makeText(this@MainActivity,"烏龜勝利", Toast.LENGTH_SHORT).show()
                    //啟動Button
                    btn_start.isEnabled = true
                }
            }
        }.execute() //執行AsyncTask
    }
}