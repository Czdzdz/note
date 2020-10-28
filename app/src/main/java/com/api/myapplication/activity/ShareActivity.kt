package com.api.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.api.myapplication.R
import kotlinx.android.synthetic.main.activity_share.*
import java.util.*

class ShareActivity : AppCompatActivity() {
    private var lastTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        mClock.setTime(
            Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
            Calendar.getInstance().get(Calendar.MINUTE),
            Calendar.getInstance().get(Calendar.SECOND)
        )
        mClock.start()

        mClock.setOnClickListener {
            val currentTimeMillis = System.currentTimeMillis()
            if (currentTimeMillis - lastTime > 3000) {
                println(
                    "${Calendar.getInstance().get(Calendar.MINUTE)}:${
                        Calendar.getInstance().get(Calendar.SECOND)
                    }"
                )
            }
            lastTime = currentTimeMillis
        }
    }
}