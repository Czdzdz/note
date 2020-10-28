package com.api.myapplication.activity.recyclerview;

import com.chad.library.adapter.base.listener.OnItemClickListener;

/**
 * @Author:460085087@qq.com
 * @Date:2020/10/28 16:12
 * @Description: 处理同时点击RecyclerView的Item事件拦截
 **/

public abstract class MultiClickListener implements OnItemClickListener {
    private long lastClickTime = 0L;

    public boolean isTimeEnable() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime > 1000) {
            lastClickTime = currentTimeMillis;
            return true;
        } else {
            return false;
        }
    }
}
