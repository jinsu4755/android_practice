package com.antilog.lifestyleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        /*val myWebView : WebView = findViewById(R.id.webview_id)
        myWebView.loadUrl("https://www.naver.com/")
        */
        //위와 동일한 표현
        webview_id.loadUrl("https://www.naver.com/")

    }
}
