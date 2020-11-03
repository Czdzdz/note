package com.api.myapplication.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.api.myapplication.R
import com.api.myapplication.activity.recyclerview.RecyclerViewMultiClickActivity
import com.api.myapplication.ext.formatDateYmdHmW
import com.instacart.library.truetime.TrueTimeRx
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayCurrentTime()

        Timber.e("这首诗写于1989年1月13日，距诗人在同年3月卧轨自杀只有两个多月的时间。作者是属于“黑夜给了我黑色的眼睛，我却用它寻找光明”的“一代人”，亲身经历了从二十世纪六七十年代扼杀物欲、只讲精神，到80年代末期的摒弃精神、物欲横流的社会转型过程。面对现实，理想主义者的作者困惑了，希望破灭了，觉得不能“诗意地栖居于世”了。同别人盲目沉醉于物质生活享受的幸福感比较起来，他更多地感到来自内心分裂矛盾的痛苦。这篇诗歌便是他人生痛苦体验的结晶")
    }

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun displayCurrentTime() {
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .map {
                formatDateYmdHmW(TrueTimeRx.now())
            }
            .doOnNext {
                runOnUiThread {
                    mTvCurrentTrueTime.text = "当前时间:${it}."
                }
            }
            .subscribe()
    }

    fun displayPropertyAnim(view: View) {
        ObjectAnimator.ofFloat(view, "translationX", 0f, -window.decorView.width / 2.0f).start()
        ObjectAnimator.ofFloat(view, "translationY", 0f, -window.decorView.width / 8.0f).start()
        scaleXAnim(view, "scaleX")
        scaleXAnim(view, "scaleY")
        ObjectAnimator.ofFloat(view, "alpha", 1f, 0.5f).start()
    }

    private fun scaleXAnim(view: View, propertyName: String) {
        val objectAnimation = ObjectAnimator.ofFloat(view, propertyName, 1f, 2f)
        objectAnimation.duration = 1000
        objectAnimation.repeatCount = ValueAnimator.INFINITE
        objectAnimation.repeatMode = ValueAnimator.REVERSE
        objectAnimation.interpolator = BounceInterpolator()
        objectAnimation.start()
    }

    fun displayShareElement(view: View) {
        //判断Android版本
        val bundle =
            ActivityOptions.makeSceneTransitionAnimation(this, ivShare, "activityTransform")
                .toBundle()
        startActivity(Intent(this, ShareActivity::class.java), bundle)
    }

    fun displayTransitionAnim(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(
                Intent(this, TransitionActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

    }

    fun displayMultiClick(view: View) {
        startActivity(Intent(this, RecyclerViewMultiClickActivity::class.java))
    }
}