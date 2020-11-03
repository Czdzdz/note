package com.api.myapplication.ext

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Author:460085087@qq.com
 * @Date:2020/11/2 13:58
 * @Description:
 **/

/**
 * 返回指定格式日期: 2020-6-3 11:30 星期三
 */
@SuppressLint("SimpleDateFormat")
fun formatDateYmdHmW(date: Date): String {
    TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"))
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss ${formatDateWeek(date)}")
    return simpleDateFormat.format(date)
}

/**
 * 格式化星期显示
 * <tt>0</tt> = Sunday,
 * <tt>1</tt> = Monday,
 * <tt>2</tt> = Tuesday,
 * <tt>3</tt> = Wednesday,
 * <tt>4</tt> = Thursday,
 * <tt>5</tt> = Friday,
 * <tt>6</tt> = Saturday
 */
fun formatDateWeek(date: Date): String {
    return when (date.day) {
        1 -> {
            "星期一"
        }
        2 -> {
            "星期二"
        }
        3 -> {
            "星期三"
        }
        4 -> {
            "星期四"
        }
        5 -> {
            "星期五"
        }
        6 -> {
            "星期六"
        }
        0 -> {
            "星期日"
        }

        else -> "未知"
    }
}