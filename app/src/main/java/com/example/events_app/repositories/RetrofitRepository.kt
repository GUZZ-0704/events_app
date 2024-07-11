package com.example.events_app.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRepository {
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://dpg-cq7i7j5ds78s73d7m3jg-a.oregon-postgres.render.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}