package com.tech4dev.tenantsapp.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.tech4dev.tenantsapp.Payment
import com.tech4dev.tenantsapp.network.RetrofitInstance
import com.tech4dev.tenantsapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationsViewModel : ViewModel() {

    var paymentList = MutableLiveData<List<Payment>>()

    fun getApiDatas(){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.getPaymentData().enqueue(object : retrofit2.Callback<List<Payment>>
        {
            override fun onResponse(
                call: retrofit2.Call<List<Payment>>,
                response: Response<List<Payment>>
            ) {
                paymentList.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<List<Payment>>, t: Throwable) {
            }

        })
    }

}