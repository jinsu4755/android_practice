package com.antilog.lifestyleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(
            Model("a","b"),
            Model("c","d")
        )
        var mAdapter = MainRvAdapter(this, modelList)
        recycleview.adapter = mAdapter

        //layout
        val layoutManager = LinearLayoutManager(this)
        recycleview.layoutManager = layoutManager
    }
}
