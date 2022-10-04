package com.tech4dev.tenantsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.tenantsapp.Payment
import com.tech4dev.tenantsapp.R

    class PaymentListAdapter(private val listOfPayments: List<Payment>): RecyclerView.Adapter<PaymentListAdapter.PLViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PLViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_payment, parent, false)

            return PLViewHolder(itemView)
        }


        override fun getItemCount(): Int {
            return listOfPayments.size
        }

        override fun onBindViewHolder(holder: PLViewHolder, position: Int) {
            holder.payer.text = listOfPayments[position].PAYER
            holder.amount.text = listOfPayments[position].AMOUNT.toString()
            holder.date.text = listOfPayments[position].DATE

        }


        class PLViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val payer: TextView = itemView.findViewById(R.id.payer)
            val amount: TextView = itemView.findViewById(R.id.amount)
            val date: TextView = itemView.findViewById(R.id.date)


            }
        }


