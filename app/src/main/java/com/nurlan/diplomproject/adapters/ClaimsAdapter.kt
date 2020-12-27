package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.data.models.ClaimData
import com.nurlan.diplomproject.databinding.ItemClaimsBinding

class ClaimsAdapter: RecyclerView.Adapter<ClaimsAdapter.ClaimsViewHolder>() {

    var models: List<ClaimData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaimsViewHolder {
        var binding = ItemClaimsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ClaimsViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: ClaimsViewHolder, position: Int) {
        holder.bind(models[position])
    }

    inner class ClaimsViewHolder(binding: ItemClaimsBinding): RecyclerView.ViewHolder(binding.root){

        var name = binding.itemClaimsTvName
        var phone = binding.itemClaimsTvPhone
        var task = binding.itemClaimsTvTask

        fun bind(claimData: ClaimData){
            name.text = claimData.name
            phone.text = claimData.phone
            task.text = claimData.task
        }
    }
}