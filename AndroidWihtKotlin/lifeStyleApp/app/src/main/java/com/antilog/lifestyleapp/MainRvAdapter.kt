package com.antilog.lifestyleapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainRvAdapter(val context: Context, val list: ArrayList<Model>) :
    RecyclerView.Adapter<MainRvAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvAdapter.Holder {
        //item 선언
        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, null)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        //item 갯수
        return list.size
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null


    override fun onBindViewHolder(holder: MainRvAdapter.Holder, position: Int) {

        //item을 클릭한 경우
        if (itemClick != null) {
            //어뎁터에서 itemView에 클릭 리스너로
            holder?.itemView?.setOnClickListener { v ->
                //아이템 클릭에 클릭했을 경우 해당 view와 몇번째 인지 넘겨준다.
                itemClick?.onClick(v, position)
            }
        }

        //리스트에 값을 하나하나 가져와서 holer로 넘겨준다.
        holder.bind(list[position], context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //list에서 나온 아이템을 뿌려준다.
        //아이템 안에 view에 자리 잡아준다는 느낌
        val photo = itemView?.findViewById<ImageView>(R.id.image_area)
        val title = itemView?.findViewById<TextView>(R.id.text_area)

        fun bind(model: Model, context: Context) {
            title.text = model.title
            Picasso.get().load(model.image).into(photo)
        }


    }

}