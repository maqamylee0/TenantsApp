package com.tech4dev.tenantsapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(value = "0gozoxhv6c9yi")
    fun getData(): Call<List<Tenants>>
}