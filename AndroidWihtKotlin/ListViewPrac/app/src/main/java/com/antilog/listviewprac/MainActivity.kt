package com.antilog.listviewprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list_sample = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //list sample에 예시 데이터 넣기
        list_sample.add("A")
        list_sample.add("B")
        list_sample.add("C")

        val list_adapter = MainListAdapter(this, list_sample)
        //listview_id 에 adapter 를 이용하여 list_adapter 의 내용을 넣는다
        listview_id.adapter = list_adapter


    }
}
