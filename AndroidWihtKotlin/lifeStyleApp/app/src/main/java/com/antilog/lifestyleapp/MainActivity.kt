package com.antilog.lifestyleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Model(Vo)로 리스트를 생성하여 해당 내용을 담는다.
        var modelList = arrayListOf<Model>(
            Model("a","b"),
            Model("c","d")
        )

        //mAdapter에 커스텀한 Adapter를 연결한다.
        var mAdapter = MainRvAdapter(this, modelList)
        //recycleview와 mAdapter를 연결한다.
        recycleview.adapter = mAdapter

        //onItemClick
        mAdapter.itemClick = object : MainRvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Log.e("position", position.toString())
            }

        }

        //layout 설정 1줄에 1개씩 리니어 레이아웃으로
        /*val layoutManager = LinearLayoutManager(this)
        recycleview.layoutManager = layoutManager*/

        //1줄에 2개씩 나오도록 GridLayout 사용
        recycleview.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

    }
}
