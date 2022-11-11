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
import java.text.NumberFormat
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

            holder.tenantName.text = listOfTenants[position].NAME
            val bal = NumberFormat.getIntegerInstance().format(listOfTenants[position].BALANCEdUP);
            holder.tenantBalnce.text =  bal.toString()
      //  }



        holder.itemView.setOnClickListener{
                TenantDeataiFragment(tenant).show(fragmentManager,"tag")

        }
    }


    class TLViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tenantName: TextView = itemView.findViewById(R.id.tenantName)
        val tenantBalnce: TextView = itemView.findViewById(R.id.amountDue)

       }
    }


