package com.zte.aook.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.zte.aook.R
import com.zte.aook.adapter.BannerAdapter
import com.zte.aook.animations.ScaleTransformer
import com.zte.aook.widget.MiuiLoadingDialog
import kotlinx.android.synthetic.main.banner_activity.*


class BannerActivity : AppCompatActivity() {
    val TAG: String = "BannerActivity"
    val mList: ArrayList<String> = ArrayList()
    var bannerAdapter: BannerAdapter? = null
    val transformer: ScaleTransformer = ScaleTransformer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.banner_activity)
        mList.add("http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg")
        mList.add("http://img.kaiyanapp.com/c043f72eeaf7cf30d5b3bb410fc127e3.png?imageMogr2/quality/60/format/jpg")
        mList.add("http://img.kaiyanapp.com/920aa45f3abacad813d475e9bd0b2c73.jpeg?imageMogr2/quality/60/format/jpg")
        bannerAdapter = BannerAdapter(this, mList)
        viewpager.adapter = bannerAdapter
        viewpager.pageMargin = 20
        viewpager.currentItem = 1
        viewpager.offscreenPageLimit = 3 //若没有设置这个，下一页则不会加载
        viewpager.setPageTransformer(true, transformer)
        viewpager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        test_miui_loading.setOnClickListener {
            var mDialog: MiuiLoadingDialog? = MiuiLoadingDialog(this)
            mDialog?.setOnCancelListener {
                Log.i(TAG, " setOnCancelListener ")
                mDialog?.dismiss()
                mDialog = null
            }
            mDialog?.show()
        }
    }
}
