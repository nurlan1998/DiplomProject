package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.models.MonterData
import com.nurlan.diplomproject.databinding.FragmentMonterItemBinding

class MonterAdapter : RecyclerView.Adapter<MonterAdapter.ItemViewHolder>() {

    var model: List<MonterData> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var binding =
            FragmentMonterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int = model.size

    inner class ItemViewHolder(binding: FragmentMonterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.itemClaimsTvName
        val phone = binding.itemClaimsTvPhone

        fun bind(monterData: MonterData) {
            name.text = monterData.name
            phone.text = monterData.phone
        }
    }

}