package com.jew.lab7

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.adapter_vertical.view.*

class MyAdapter constructor(private val layout: Int, private val data: ArrayList<Item>)
    : BaseAdapter() {   //繼承BaseAdapter
    //回傳資料來源筆數
    override fun getCount() = data.size
    //回傳某筆項目
    override fun getItem(position: Int) = data[position]
    //回傳某筆項目Id
    override fun getItemId(position: Int) = 0L
    //取得畫面
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //建立畫面
        val view = View.inflate(parent.context, layout, null)
        //根據position顯示圖片到ImageView
        view.img_photo.setImageResource(data[position].photo)
        //根據position顯示名稱到TextView
        view.tv_name.text = data[position].name

        //取得xml畫面
        return view
    }
}