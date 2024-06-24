package com.dilip.contentproviderexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilip.contentproviderexample.databinding.ViewHolderMainBinding

class MainAdapter(private val list: List<String>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    // Inner ViewHolder class to hold view references
    inner class MyViewHolder(val viewDataBinding: ViewHolderMainBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    // Called when creating a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {
        val binding =
            ViewHolderMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // Called to bind data to the views in each ViewHolder
    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        val binding = holder.viewDataBinding
        binding.tvName.text = list[position] // Set text for the TextView
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int {
        return list.size
    }
}
