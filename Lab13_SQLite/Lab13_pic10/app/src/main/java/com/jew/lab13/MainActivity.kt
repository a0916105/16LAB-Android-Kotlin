package com.jew.lab13

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //建立MyDBHelper物件
    private lateinit var dbrw: SQLiteDatabase

    private var items: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //取得資料庫實體
        dbrw = MyDBHelper(this).writableDatabase
        //宣告Adapter並連結ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        //Step1：建立ContentValues物件，用於存放要新增的資料
        val cv = ContentValues()
        cv.put("book", "百科全書")  //填入book內容
        cv.put("price", 900)       //填入price內容
        //Step2：透過insert()放入ContentValues至myTable新增資料
        dbrw.insert("myTable", null, cv)

        cv.put("book", "英文雜誌")  //填入book內容
        cv.put("price", 500)       //填入price內容
        dbrw.insert("myTable", null, cv)
        cv.put("book", "歷史讀物")  //填入book內容
        cv.put("price", 300)       //填入price內容
        dbrw.insert("myTable", null, cv)

        //查詢book為'百科全書'的欄位後，透過delete()刪除資料
        dbrw.delete("myTable", "book='百科全書'", null)

        //查詢myTable資料表
        val c = dbrw.rawQuery("SELECT * FROM myTable",null)
        if(c.count>0) {  //判斷是否有資料(總筆數不為0)
            //從第一筆開始輸出
            c.moveToFirst()
            //使用迴圈將Cursor內的資料取出
            for (i in 0 until c.count) {
                //填入書名與價格
                items.add("書名:${c.getString(0)}\t\t\t\t價格:${c.getInt(1)}")
                //移動到下一筆
                c.moveToNext()
            }
        }

        //更新列表資料
        adapter.notifyDataSetChanged()
        //關閉Cursor
        c.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        //關閉資料庫
        dbrw.close()
    }
}