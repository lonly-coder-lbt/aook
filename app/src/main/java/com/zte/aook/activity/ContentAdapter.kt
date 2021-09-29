package com.zte.aook.activity

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zte.aook.MainActivity
import com.zte.aook.R

class ContentAdapter(
    var mList: List<String>,
    var mFragmentList: List<Fragment>,
    var mActivity: MainActivity
) :
    RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {
    val TAG: String = "ContentAdapter"
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentAdapter.ContentViewHolder {
        var rootView = LayoutInflater.from(mActivity).inflate(R.layout.content_item, parent, false)
        return ContentViewHolder(rootView, mActivity)
    }

    override fun onBindViewHolder(holder: ContentAdapter.ContentViewHolder, position: Int) {
        Log.i(TAG, " onBindViewHolder text=${mList[position]} pos=${position} mList.size=${mList.size}")
        holder.mContentTv?.text = mList.get(position)
        holder.mContentTv?.setOnClickListener {
            mActivity.switchFragment(position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ContentViewHolder(itemView: View, mContext: Context) : RecyclerView.ViewHolder(itemView) {
        var mContentTv: TextView? = null

        init {
            mContentTv = itemView.findViewById(R.id.content_tv)
        }
    }
}
