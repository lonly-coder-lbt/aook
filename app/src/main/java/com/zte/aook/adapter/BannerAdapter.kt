package com.zte.aook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.zte.aook.R
import com.zte.aook.util.ImageLoadUtils

class BannerAdapter(var mContet:Context,var mList:List<String>) :PagerAdapter(){
    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val rootView = LayoutInflater.from(mContet).inflate(R.layout.banner_adapter_layout,container,false)
        val imageView:ImageView = rootView.findViewById(R.id.banner_adapter_item_imageview)
        ImageLoadUtils.display(mContet,imageView,mList[position%mList.size])
        container.addView(rootView)
        return rootView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
