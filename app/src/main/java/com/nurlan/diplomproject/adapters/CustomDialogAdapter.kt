package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.databinding.ItemCustomDialogBinding

class CustomDialogAdapter: RecyclerView.Adapter<CustomDialogAdapter.CustomDialogViewHolder>() {

    var models: MutableList<CitiesData> = mutableListOf()

    fun setData(data: MutableList<CitiesData>){
        models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomDialogViewHolder {
        var view = ItemCustomDialogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomDialogViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: CustomDialogViewHolder, position: Int) {
        holder.bind(models[position])
    }

    inner class CustomDialogViewHolder(binding: ItemCustomDialogBinding): RecyclerView.ViewHolder(binding.root){
        val name = binding.itemCustomDialogTvName

        fun bind(citiesData: CitiesData){
            name.text = citiesData.name
        }
    }

}