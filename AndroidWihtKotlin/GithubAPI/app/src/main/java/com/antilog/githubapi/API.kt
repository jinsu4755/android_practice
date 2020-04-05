package com.antilog.githubapi

import retrofit2.Call
import retrofit2.http.GET

interface API {
    //API url을 받아올 API interface

    @GET("users?q=jinsu4")
    fun getUsers(): Call<UserData>

}