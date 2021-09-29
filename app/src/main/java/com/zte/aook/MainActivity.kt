package com.zte.aook

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zte.aook.activity.ContentAdapter
import com.zte.aook.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    var mList:ArrayList<String>  = ArrayList()
    val mFragmentList:ArrayList<Fragment>  = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mList.let {
            it.add("广告翻页")
            it.add("开眼视频")
            it.add("狗狗")
            it.add("弹幕效果")
            it.add("网络数据存入数据库(not ok)")
        }
        mFragmentList.let {
            it.add(BannerFragment())
            it.add(HomeFragment())
            it.add(DogFragment())
            it.add(DanmuFragment())
            it.add(DogImageModelFragment())
        }
        val mContentAdapter = ContentAdapter(mList,mFragmentList,this)
        content_recyclerview.layoutManager = LinearLayoutManager(this)
        content_recyclerview.adapter = mContentAdapter
    }

    fun switchFragment(pos:Int){
        mFragmentList.forEach {
            if (!it.isHidden){
                supportFragmentManager.beginTransaction().hide(it)
            }
        }

        supportFragmentManager.beginTransaction().addToBackStack(mList[pos]).add(R.id.container,mFragmentList[pos]).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i(TAG," onBackPressed")
    }
}
