package com.example.employeeslist.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeeslist.R
import com.example.employeeslist.data.EmployeeViewModel
import com.example.employeeslist.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var mEmployeeViewModel: EmployeeViewModel

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        //Recyclerview
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //EmployeeViewModel
        mEmployeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        mEmployeeViewModel.readAllData.observe(viewLifecycleOwner, Observer { employee ->
            adapter.setData(employee)
        })

        binding.fabAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

}