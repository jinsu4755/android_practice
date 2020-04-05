package com.antilog.listviewprac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.listview_item.view.*

//ListView에 View를 그릴 데이터 값을 넣는 class
class MainListAdapter(val context: Context, val list: ArrayList<String>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // item의 view를 그리는 부분

        //view를 선언하여 listView_item 하나하나에 접근 할 수 있다.
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)
        view.List_sample_text.setText(list.get(position))

        return view

    }

    override fun getItem(position: Int): Any {
        //각각의 item을 return
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        //item의 숫자를 리턴
        return list.size
    }

}