package com.antilog.githubapi

import com.google.gson.annotations.SerializedName

class UserData(

    /*
    @SerializedName?
    GSON - java 객체와 JSON 간의 직렬화 및 역직렬화를 위한 오픈소스 라이브러리
    Gson @SerializedName?
    @SerializedName annotation 의 value 는 객체를 직렬화 및 역직렬화 할 때 이름
    간단하게 api서버에서 json형태로 뽑혀오는 데이터의 진짜 이름
    */
    @SerializedName("total_count")
    val total_count: String,
    @SerializedName("incomplete_result")
    val incomplete_result: String,
    @SerializedName("items")
    val items: List<UserInfo>
)