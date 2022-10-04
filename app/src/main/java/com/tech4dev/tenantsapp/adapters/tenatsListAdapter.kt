package com.tech4dev.tenantsapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.tenantsapp.Balance
import com.tech4dev.tenantsapp.Data
import com.tech4dev.tenantsapp.R
import com.tech4dev.tenantsapp.Tenants
import com.tech4dev.tenantsapp.network.RetrofitInstance
import com.tech4dev.tenantsapp.network.RetrofitService
import com.tech4dev.tenantsapp.ui.details.TenantDeataiFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class TenantsListAdapter(
    var context: Context,
    val listOfTenants: List<Tenants>,
    val fragmentManager: FragmentManager
): RecyclerView.Adapter<TenantsListAdapter.TLViewHolder>(){

    var count : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TLViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)

        return TLViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return listOfTenants.size
    }

    override fun onBindViewHolder(holder: TLViewHolder, position: Int) {
        var tenant = listOfTenants[position]
     //   var balance :Int
//        val c = Calendar.getInstance()
//        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm aa")
//        val getCurrentDateTime = sdf.format(c.time)
//        val getMyTime = "10/4/2022 5:35 PM "
////        Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1
//        if (getCurrentDateTime == getMyTime && count == 0){
//          balance =  listOfTenants[position].BALANCE + listOfTenants[position].AMOUNT
//            holder.tenantName.text = listOfTenants[position].NAME
//            holder.tenantBalnce.text = balance.toString()
//            val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
//            var nbalance = Data(balance.toString())
//
//            var bal = Balance(nbalance)
//            var id = Integer.parseInt(tenant.ID)
//            retrofitService.changeBalance(id.toString(),bal).enqueue(object : Callback<Balance> {
//                override fun onResponse(call: Call<Balance>, response: Response<Balance>) {
//                   Toast.makeText(context,"!st of month", Toast.LENGTH_LONG).show()
//                    count += 1
//                }
//                override fun onFailure(call: Call<Balance>, t: Throwable) {
////                Toast.makeText(this@DetailsViewModel,"Failed",Toast.LENGTH_LONG).show()
//                    Log.d("APICALLLLLLLLLLLLL","${t}")
//                }
//
//
//
//            })
//
//        }else{
            holder.tenantName.text = listOfTenants[position].NAME
            holder.tenantBalnce.text =  listOfTenants[position].BALANCE.toString()
      //  }



        holder.itemView.setOnClickListener{
                TenantDeataiFragment(tenant).show(fragmentManager,"tag")

//            val bundle = Bundle()
//            bundle.putString("id",listOfTenants[position].ID)
//            bundle.putString("name",listOfTenants[position].NAME)
//            bundle.putInt("amount",listOfTenants[position].AMOUNT)
//            bundle.putString("cell",listOfTenants[position].CELL)
//            bundle.putInt("balance", listOfTenants[position].BALANCE)
//
//            val fragment: Fragment = HomeFragment()
//            val fragmentManager: FragmentManager =(context as MainActivity).supportFragmentManager
//            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
//
//            val detailsFragment = TenantDetail()
//            detailsFragment.arguments = bundle
//            transaction.replace(R.id.container, detailsFragment)
//            transaction.disallowAddToBackStack()
//            transaction.commit()
//            var i = Intent(context, DetailsFragment::class.java)
//            startActivity(context,i,bundle)

        }
    }


    class TLViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tenantName: TextView = itemView.findViewById(R.id.tenantName)
        val tenantBalnce: TextView = itemView.findViewById(R.id.amountDue)

       }
    }


