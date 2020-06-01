package com.example.pruebastp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MercadoLibreAPI{

@GET("items/{itemId}")
fun getitem(@Path("itemId") itemId:String): Call<Article>
}