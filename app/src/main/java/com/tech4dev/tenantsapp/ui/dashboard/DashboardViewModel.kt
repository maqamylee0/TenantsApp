package com.tech4dev.tenantsapp.ui.dashboard


import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.tech4dev.tenantsapp.Tenants
import com.tech4dev.tenantsapp.network.RetrofitInstance
import com.tech4dev.tenantsapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {

    var newTenant = MutableLiveData<Tenants>()

    fun sendApiData(tenant :Tenants){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.createTenant(tenant).enqueue(object :Callback<Tenants>{
            override fun onResponse(call: Call<Tenants>, response: Response<Tenants>) {
                newTenant.postValue(tenant)
                //
//
//                val intent = Intent(this, HomeFragment::class.java)
//                startActivity(intent)
//                intent.finish()
            }
            override fun onFailure(call: Call<Tenants>, t: Throwable) {
            }



        })
    }
}