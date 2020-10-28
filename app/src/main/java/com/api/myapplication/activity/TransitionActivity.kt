package com.api.myapplication.activity

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.transition.Explode
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.api.myapplication.R


class TransitionActivity : AppCompatActivity() {

    private lateinit var am: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.allowEnterTransitionOverlap = false
        Explode().apply {
            duration = 300
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }.also {
            window.exitTransition = it
            window.enterTransition = it
            window.reenterTransition = it
        }

        setContentView(
            R.layout.activity_transition
        )

        am = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        print(am.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            am.getStreamMinVolume(AudioManager.STREAM_MUSIC)
        }
    }

    fun adjustLower(view: View) {
        am.adjustStreamVolume(
            AudioManager.STREAM_MUSIC,
            AudioManager.ADJUST_LOWER,
            AudioManager.FLAG_SHOW_UI
        )
    }

    fun adjustRaise(view: View) {
        am.adjustStreamVolume(
            AudioManager.STREAM_MUSIC,
            AudioManager.ADJUST_RAISE,
            AudioManager.FLAG_PLAY_SOUND
        )
    }
}