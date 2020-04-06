package com.antilog.lifestyleapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRvAdapter (val context: Context, val list:ArrayList<Model>) : RecyclerView.Adapter<MainRvAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvAdapter.Holder {
        //item 선언
        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, null)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        //item 갯수
        return list.size
    }

    override fun onBindViewHolder(holder: MainRvAdapter.Holder, position: Int) {
        //리스트에 값을 하나하나 가져와서 holer로 넘겨준다.
        holder.bind(list[position],context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //list에서 나온 아이템을 뿌려준다.
        //아이템 안에 view에 자리 잡아준다는 느낌
        val photo = itemView?.findViewById<ImageView>(R.id.image_area)
        val title = itemView?.findViewById<TextView>(R.id.text_area)

        fun bind(model: Model, context: Context) {
            title.text = model.title
        }


    }

}