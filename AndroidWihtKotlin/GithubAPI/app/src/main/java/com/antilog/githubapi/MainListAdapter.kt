package com.antilog.githubapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.listview_item.view.*

class MainListAdapter (
    val context: Context,
    val list: ArrayList<String>
) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        //position : list size만큼 0~size-1까지 그리고 그것을 view 객체로 만든 레이아웃에 item_id에 넣는다.
        view.listview_item_id.setText(list.get(position))

        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }

}