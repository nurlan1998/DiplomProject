package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.databinding.ItemAtsBinding

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    var models: List<CategoriesData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        var binding = ItemAtsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(models[position])
    }

    inner class CategoriesViewHolder(binding: ItemAtsBinding): RecyclerView.ViewHolder(binding.root){

        val name = binding.tvAtsName

        fun bind(categoriesData: CategoriesData){
            name.text = categoriesData.ats
        }
    }
}