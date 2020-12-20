package com.jew.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //建立FragmentPagerAdapter物件
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //連接Adapter，讓畫面(Fragment)與ViewPager建立關聯
        viewPager.adapter = adapter
    }
}

//繼承FragmentPagerAdapter類別
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    //回傳對應位置的Fragment，決定頁面的呈現順序
    override fun getItem(position: Int) = when(position){
        0 -> FirstFragment()    //第一頁要呈現的Fragment
        1 -> SecondFragment()   //第二頁要呈現的Fragment
        else -> ThirdFragment() //第三頁要呈現的Fragment
    }
    //回傳Fragment頁數
    override fun getCount() = 3
}