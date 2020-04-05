package com.antilog.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://api.github.com/search/"

    val arr = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 변경 가능한 retrofit에 Retrofit 객체를 빌더로 생성
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //api를 호출한다.
        var api = retrofit.create(API::class.java)

        var call: Call<UserData> = api.getUsers()

        call.enqueue(object : Callback<UserData>{
            override fun onFailure(call: Call<UserData>, t: Throwable) {
                //실패시 작동하는 메소드
                Log.e("MAINACTIVITY", "데이터 불러오지 못함")
            }

            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                //성공시 작동할 메소드

                //?와 !!
                //?는 null일 수 있을때 사용하며
                //!!는 null이 아님을 선언한다.
                Log.e("MAINACTIVITY", response.body()?.items.toString())

                for(str : UserInfo in response.body()?.items!!){
                    Log.e("MainActivity", str.login)
                    arr.add(str.login)
                }
                val list_adapter = MainListAdapter(this@MainActivity, arr)
                listview_api_id.adapter = list_adapter



            }

        })

        listview_api_id.setOnItemClickListener{parent, view, position, id ->
            Toast.makeText(this@MainActivity, arr.get(position), Toast.LENGTH_SHORT).show()
        }


    }
}
