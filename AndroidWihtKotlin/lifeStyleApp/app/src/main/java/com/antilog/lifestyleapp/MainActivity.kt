package com.antilog.lifestyleapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Model(Vo)로 리스트를 생성하여 해당 내용을 담는다.
        var modelList = arrayListOf<Model>(
            Model("꿈으로 알아보는 나도 몰랐던 지금 내 상태! (정확해서 소름돋음)",
                "https://img1.daumcdn.net/thumb/R720x0/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fliveboard%2Fonehomelife%2Fbccab4207ca241ab96c9272fddd7b21a.png",
                "https://1boon.kakao.com/onehomelife/5e8e7fbfba44b67128c60822"),
            Model("자존감 바닥일 때 이거 한 번 꼭 봐 보세요!",
                "https://img1.daumcdn.net/thumb/R720x0/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fliveboard%2Fonehomelife%2Fd48c76560929469e8306ae9e062d7f5a.png",
                "https://1boon.kakao.com/onehomelife/5e8d28e9ba44b67128c5f827"),
            Model("5분만에 홈카페되는 새콤달콤 과일청 황금레시피",
                "https://img1.daumcdn.net/thumb/R720x0/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fliveboard%2Fonehomelife%2F45ce80b43a9f457f9d42e3aa7bc35d12.png",
                "https://1boon.kakao.com/onehomelife/5e8d276728657049099ab2d2")
        )

        //mAdapter에 커스텀한 Adapter를 연결한다.
        var mAdapter = MainRvAdapter(this, modelList)
        //recycleview와 mAdapter를 연결한다.
        recycleview.adapter = mAdapter

        //onItemClick
        mAdapter.itemClick = object : MainRvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Log.e("position", position.toString())

                //webView Activity 사용시
                /*val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                //intent 간 데이터 전달
                intent.putExtra("url", modelList.get(position).url)
                startActivity(intent)*/

                //webView Activity 미사용 액션뷰로 바로 띄우기ㄴ
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(modelList.get(position).url))
                startActivity(intent)

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
