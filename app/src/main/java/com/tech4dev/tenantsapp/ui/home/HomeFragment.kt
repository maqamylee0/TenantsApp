package com.tech4dev.tenantsapp.ui.home

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tech4dev.tenantsapp.adapters.TenantsListAdapter
import com.tech4dev.tenantsapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.getApiData()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvTenants.layoutManager = LinearLayoutManager(requireContext())

        val progress = ProgressDialog(requireContext())
        progress.setTitle("Loading")
        progress.setMessage("Wait while loading Tenants...")
        progress.setCancelable(false) // disable dismiss by tapping outside of the dialog
//
       progress.show()
        homeViewModel.tenantsList.observe(viewLifecycleOwner) {
            binding.rvTenants.adapter = TenantsListAdapter(
                requireContext(),
                it,
                childFragmentManager
            )
            progress.dismiss()
            var adapter2 = TenantsListAdapter(requireContext(),it,childFragmentManager)

        }
    }




}
