package com.tech4dev.tenantsapp.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.tenantsapp.Balance

import com.tech4dev.tenantsapp.Payment
import com.tech4dev.tenantsapp.network.RetrofitInstance
import com.tech4dev.tenantsapp.network.RetrofitService
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TenantDetailViewModel : ViewModel() {

    var newPayment = MutableLiveData<Payment>()
    var paid = MutableLiveData<String>()

    fun sendPayment(payment : Payment){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.createPayment(payment).enqueue(object : Callback<Payment> {
            override fun onResponse(call: Call<Payment>, response: Response<Payment>) {
                newPayment.postValue(payment)
                //

            }
            override fun onFailure(call: Call<Payment>, t: Throwable) {
            }



        })
    }
    fun changeBalance(id:String, paidCash: Balance){
//        val client = OkHttpClient().newBuilder()
//            .build()
//        val mediaType: MediaType? = MediaType.parse("application/json")
//        val body = RequestBody.create(mediaType, "\n\n {\"data\":{\"BALANCE\":\"${paidCash}\"}}\n\n")
//        val request: Request = Builder()
//            .url("ht" +
//                    "tps://sheetdb.io/api/v1/0gozoxhv6c9yi/ID/${id}")
//            .method("PUT", body)
//            .addHeader("Content-Type", "application/json")
//            .build()
//         val response: Response<*> = client.newCall(request).execute()
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        Log.d("APIiiiiiiiiiiiiiiiii","${id}--${paidCash}")

        retrofitService.changeBalance(id,paidCash).enqueue(object : Callback<Balance> {
            override fun onResponse(call: Call<Balance>, response: Response<Balance>) {
                paid.postValue(paidCash.toString())

                Log.d("APIiiiiiiiiiiiiiiiii","${id}--${paidCash}")
            }
            override fun onFailure(call: Call<Balance>, t: Throwable) {
//                Toast.makeText(this@DetailsViewModel,"Failed",Toast.LENGTH_LONG).show()
                Log.d("APICALLLLLLLLLLLLL","${t}")
            }



    })
}
}



