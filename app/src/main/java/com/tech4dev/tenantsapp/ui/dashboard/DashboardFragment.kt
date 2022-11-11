package com.tech4dev.tenantsapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tech4dev.tenantsapp.Tenants
import com.tech4dev.tenantsapp.databinding.FragmentDashboardBinding
import java.text.NumberFormat
import java.util.*

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding.button.setOnClickListener(){
            createTenant()
//           var i = Intent(requireContext(),HomeFragment::class.java)
//            startActivity(i)
            Toast.makeText(requireContext(),"Tenant added successfully",Toast.LENGTH_LONG).show()
//            val transaction = requireActivity().supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, HomeFragment())
//            transaction.disallowAddToBackStack()
//            transaction.commit()
            binding.phone.text = null
            binding.name.text = null
            binding.amount.text = null}
    }

    private fun createTenant() {
        var phone = binding.phone.text.toString()
        if(binding.phone.text.toString() == null){
             phone = "000000000"
        }
        val numberAmount: String = (binding.amount.text.toString()).replace(",","")
        val tenant = Tenants( "",binding.name.text.toString(),Integer.parseInt(numberAmount),
           phone,Integer.parseInt(numberAmount),0)
        dashboardViewModel.sendApiData(tenant)
    }
}