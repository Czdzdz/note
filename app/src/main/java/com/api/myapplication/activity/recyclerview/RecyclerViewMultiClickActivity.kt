package com.api.myapplication.activity.recyclerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.api.myapplication.R
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.activity_recycler_view_multi_click.*

/**
 * @Author:460085087@qq.com
 * @Date:2020/10/28 15:35
 * @Description: RecyclerView多个Item点击拦截
 **/

class RecyclerViewMultiClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_multi_click)

        mRvMultiClick.layoutManager = GridLayoutManager(this, 3)
        val multiClickAdapter = MultiClickAdapter(initInflaterData())
        mRvMultiClick.adapter = multiClickAdapter


        multiClickAdapter.setOnItemClickListener(object : MultiClickListener() {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                if (position > 3) {
                    if (isTimeEnable) {
                        println("position:${position}\ntitle:${initInflaterData()[position].title},number:${initInflaterData()[position].number}")
                    }
                } else {
                    println("position:${position}\ntitle:${initInflaterData()[position].title},number:${initInflaterData()[position].number}")
                }
            }
        })
    }

    private fun initInflaterData(): MutableList<MultiClickItem> {
        val mutableListOf = mutableListOf<MultiClickItem>()
        for (index in 1..20) {
            mutableListOf.add(MultiClickItem("title--${index}", "number--${index}"))
        }
        return mutableListOf
    }
}
 