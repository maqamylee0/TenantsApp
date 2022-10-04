package com.tech4dev.tenantsapp.ui.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.tech4dev.tenantsapp.Tenants
import com.tech4dev.tenantsapp.network.RetrofitInstance
import com.tech4dev.tenantsapp.network.RetrofitService
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class HomeViewModel : ViewModel() {

    var tenantsList = MutableLiveData<List<Tenants>>()


    fun getApiData(){
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.getData().enqueue(object : retrofit2.Callback<List<Tenants>>
        {
            override fun onResponse(
                call: retrofit2.Call<List<Tenants>>,
                response: Response<List<Tenants>>
            ) {
                tenantsList.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<List<Tenants>>, t: Throwable) {
//                Toast.makeText(this,"Faileld to getData ",Toast.LENGTH_LONG).show()

            }

        })
    }
}