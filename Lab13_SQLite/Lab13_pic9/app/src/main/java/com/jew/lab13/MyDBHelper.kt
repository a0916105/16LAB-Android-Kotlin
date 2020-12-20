package com.jew.lab13

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//自訂建構子，只需傳入一個Context物件即可
//class MySQLiteOpenHelper (context: Context): SQLiteOpenHelper(context, name, null, version)
class MyDBHelper (context: Context, name: String = database, factory: SQLiteDatabase.CursorFactory? = null, version: Int = v) :
    SQLiteOpenHelper(context, name, factory, version){  //繼承SQLiteOpenHelper類別
    companion object {
        private const val database = "mdatabase.db" //資料庫名稱
        private const val v = 1 //資料庫版本
    }

    override fun onCreate(db: SQLiteDatabase) {
        //需要加入建立資料表的SQL語法
        //建立資料表『myTable』，包含一個book字串欄位和一個price整數欄位
        db.execSQL("CREATE TABLE myTable(book text PRIMARY KEY, price integer NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //需要加入刪除資料表的SQL語法
        //刪除舊有資料表
        db.execSQL("DROP TABLE IF EXISTS myTable")
        //重新執行onCreate，來重建資料庫
        onCreate(db)
    }
}