package com.tech4dev.tenantsapp.ui.notifications

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.tech4dev.tenantsapp.adapters.PaymentListAdapter
import com.tech4dev.tenantsapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val progress = ProgressDialog(requireContext())
        progress.setTitle("Loading")
        progress.setMessage("Wait while loading Payments...")
        progress.setCancelable(false) // disable dismiss by tapping outside of the dialog
//
        progress.show()
        notificationsViewModel.getApiDatas()
        notificationsViewModel.paymentList.observe(viewLifecycleOwner) {
//            binding.rvPayments.apply {
//                // set a LinearLayoutManager to handle Android
//                // RecyclerView behavior
//                layoutManager = LinearLayoutManager(activity)
//                // set the custom adapter to the RecyclerView
//                adapter = PaymentListAdapter(it)
//            }
            progress.dismiss()

            binding.rvPayments.layoutManager = LinearLayoutManager(requireContext())
            binding.rvPayments.adapter = PaymentListAdapter(it.reversed())
        }


    }

}