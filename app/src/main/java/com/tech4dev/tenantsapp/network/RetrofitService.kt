package com.tech4dev.tenantsapp.network


import com.tech4dev.tenantsapp.Balance
import com.tech4dev.tenantsapp.Payment
import com.tech4dev.tenantsapp.Tenants
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET(value =  "0gozoxhv6c9yi")
    fun getData() : Call<List<Tenants>>

    @GET(value =  "0gozoxhv6c9yi?sheet=payments")
    fun getPaymentData() : Call<List<Payment>>

    @POST(value =  "0gozoxhv6c9yi")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun createTenant(@Body params : Tenants):Call<Tenants>

    @POST(value =  "0gozoxhv6c9yi?sheet=payments")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun createPayment(@Body params: Payment):Call<Payment>

    @PATCH(value =  "0gozoxhv6c9yi/ID/{Id}")
    @Headers("Content-Type:application/json")
    fun changeBalance(@Path("Id") Id: String, @Body params: Balance):Call<Balance>
}