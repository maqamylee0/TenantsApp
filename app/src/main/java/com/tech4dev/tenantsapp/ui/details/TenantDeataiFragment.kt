package com.tech4dev.tenantsapp.ui.details

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.tech4dev.tenantsapp.*
import com.tech4dev.tenantsapp.databinding.FragmentTenantDeataiListDialogBinding
import com.tech4dev.tenantsapp.ui.detail.TenantDetailViewModel
import com.tech4dev.tenantsapp.ui.notifications.NotificationsFragment
import java.text.SimpleDateFormat
import java.util.*



class TenantDeataiFragment(var tenant: Tenants) : BottomSheetDialogFragment() {

    private lateinit var _binding: FragmentTenantDeataiListDialogBinding
    private lateinit var tenantDetailsViewModel: TenantDetailViewModel
    private lateinit var date: Date
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tenantDetailsViewModel = ViewModelProvider(this).get(TenantDetailViewModel::class.java)
        _binding = FragmentTenantDeataiListDialogBinding.inflate(inflater, container, false)
        return binding.root

    }





        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        homeViewModel.tenantsList.observe(viewLifecycleOwner) {

            binding.txtName.text = tenant.NAME
            binding.textView10.text = tenant.AMOUNT.toString()
            binding.textView4.text =tenant.CELL
            binding.textView9.text = tenant.BALANCE.toString()

            binding.button2.setOnClickListener{
                createPayment()
                Toast.makeText(requireContext(),"Payment made successfully", Toast.LENGTH_LONG).show()
                binding.amountPaid.text = null

            }

        }

        private  fun createPayment() {
            date = Calendar.getInstance().time
            val payment = Payment(tenant.NAME,Integer.parseInt(binding.amountPaid.text.toString()),
                getCurrentDate(date))
            tenantDetailsViewModel.sendPayment(payment)
            changeBalances(Integer.parseInt(binding.amountPaid.text.toString()))
        }

        private  fun changeBalances(paid : Int) {
            var currentBalnce =  tenant.BALANCE
            var newBalnce:String = (currentBalnce-paid).toString()
            var list = Data(newBalnce)
            var balance = Balance(list)
//            var bal = Gson().toJson(balance)
            var id = Integer.parseInt(tenant.ID)
            tenantDetailsViewModel.changeBalance(id.toString(),balance)
//Toast.makeText(requireContext(),"${bal}",Toast.LENGTH_LONG).show()
            Log.d("dataaaaaaaa is", id.toString())
        }

        fun getCurrentDate(date: Date):String{
            val sdf = SimpleDateFormat("yyyy/MM/dd")
            return sdf.format(date)
        }

    }