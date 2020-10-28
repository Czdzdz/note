package com.api.myapplication.activity.recyclerview

import com.api.myapplication.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @Author:460085087@qq.com
 * @Date:2020/10/28 15:41
 * @Description:
 **/

class MultiClickAdapter(data: MutableList<MultiClickItem>) :
    BaseQuickAdapter<MultiClickItem, BaseViewHolder>(
        R.layout.item_multi_click,
        data
    ) {
    override fun convert(holder: BaseViewHolder, item: MultiClickItem) {
        holder.setText(R.id.mTvTitle, item.title)
            .setText(R.id.mTvNumber, item.number)
    }
}
 