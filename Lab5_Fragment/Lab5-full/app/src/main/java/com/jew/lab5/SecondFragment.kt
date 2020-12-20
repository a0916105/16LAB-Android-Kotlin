package com.jew.lab5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {  //舊版是繼承supportv4的Fragment類別；新版是繼承androidx的Fragment類別
    companion object {
        const val TAG = "SecondFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化頁面
        Log.e(TAG,"onCreate")   //使用Log追蹤SecondFragment生命週期
    }

    //在onCreateView中定義SecondFragment的畫面為fragment_second
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //連結畫面
        Log.e(TAG,"onCreateView")   //使用Log追蹤SecondFragment生命週期
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //連結Fragment與Activity
        Log.e(TAG,"onActivityCreated")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onStart() {
        super.onStart()
        //頁面可見
        Log.e(TAG,"onStart")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onResume() {
        super.onResume()
        //頁面與使用者開始互動
        Log.e(TAG,"onResume")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onPause() {
        super.onPause()
        //離開頁面
        Log.e(TAG,"onPause")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onStop() {
        super.onStop()
        //頁面不可見
        Log.e(TAG,"onStop")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //移除畫面
        Log.e(TAG,"onDestroyView")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onDestroy() {
        super.onDestroy()
        //回收頁面
        Log.e(TAG,"onDestroy")   //使用Log追蹤SecondFragment生命週期
    }

    override fun onDetach() {
        super.onDetach()
        //移除Fragment
        Log.e(TAG,"onDetach")   //使用Log追蹤SecondFragment生命週期
    }
}