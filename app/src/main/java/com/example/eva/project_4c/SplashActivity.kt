package com.example.eva.project_4c

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import kotlin.concurrent.thread
import android.webkit.WebView


class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val mWebView = findViewById<WebView>(R.id.webview)
        //mWebView.loadUrl("https://i.gifer.com/WG94.gif")

        mWebView.setBackgroundColor(Color.TRANSPARENT)
        mWebView.setPadding(0, 0, 0, 0)

        mWebView.loadUrl("http://netsources.narod.ru/friday/alkocat.jpg");



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
