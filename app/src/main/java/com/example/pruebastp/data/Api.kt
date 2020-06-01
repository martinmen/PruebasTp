package com.example.pruebastp.data

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Api {

    fun getApi():MercadoLibreAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return  retrofit.create(MercadoLibreAPI::class.java)
    }

    fun getArticle(id: String,callback: Callback<Article>){
        getApi().getitem(id).enqueue(callback)
    }
}