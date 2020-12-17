package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.models.CategoriesData


class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    var models: List<CategoriesData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories,parent,false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(models[position])
    }

    inner class CategoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(categoriesData: CategoriesData){

        }
    }
}