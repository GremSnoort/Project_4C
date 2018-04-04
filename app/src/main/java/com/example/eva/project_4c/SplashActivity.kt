package com.example.eva.project_4c

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlin.concurrent.thread
import android.webkit.WebView
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*


class SplashActivity : Activity() {

    fun ClosedRange<Int>.random() = Random().nextInt(endInclusive + 1 - start) + start
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val rand_choice = (0..4).random()
        var Id: Int = R.anim.myalpha
        if (rand_choice==0)
            Id = R.anim.myalpha
        else if (rand_choice==1)
            Id = R.anim.mycombo
        else if (rand_choice==2)
            Id = R.anim.myrotate
        else if (rand_choice==3)
            Id = R.anim.myscale
        else if (rand_choice==4)
            Id = R.anim.mytrans

        val anm =  AnimationUtils.loadAnimation(this, Id)
        val mPic = findViewById<ImageView>(R.id.droid_pic)
        mPic.startAnimation(anm)


        val myThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)
                    val intent = Intent(applicationContext, StartUpActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        myThread.start()
    }
}
