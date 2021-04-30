package com.example.employeeslist.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeeslist.data.Employee
import com.example.employeeslist.databinding.ListItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var employeeList = emptyList<Employee>()

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = employeeList[position]
        holder.binding.textViewId.text = currentItem.id.toString()
        holder.binding.textViewFirstName.text = currentItem.firstName
        holder.binding.textViewLastName.text = currentItem.lastName
        holder.binding.textViewAge.text = currentItem.age.toString()
    }

    fun setData(employee: List<Employee>) {
        this.employeeList = employee
        notifyDataSetChanged()
    }
}