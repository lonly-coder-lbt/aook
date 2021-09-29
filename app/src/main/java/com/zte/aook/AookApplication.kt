package com.zte.aook

import android.app.Application
import android.content.Context
import android.util.Log
import com.tencent.mmkv.MMKV

class AookApplication : Application() {
    var mContext:Context = this
    val TAG: String = "AookApplication"

    companion object{
        var appContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG," onCreate")
        MMKV.initialize(this)
        appContext = this
    }
}
