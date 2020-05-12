package com.antilog.semina_3rd_task2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.antilog.semina_3rd_task2.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        //App Compact Toolbar 인스턴스 얻기
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Status Bar 높이만큼 Padding 부여
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

    }

    //status bar 높이 계산
    private fun getStatusBarHeight(): Int {
        var result = 0
        var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}
