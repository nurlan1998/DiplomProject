package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.databinding.ItemAtsBinding

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    var models: List<CategoriesData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private lateinit var itemClick: (CategoriesData) -> Unit

    fun setItemClick(itemClick: (model: CategoriesData) -> Unit){
        this.itemClick = itemClick
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
        var ivAts = binding.ivAts

        fun bind(categoriesData: CategoriesData){
            name.text = categoriesData.atsName

            itemView.setOnClickListener {
                itemClick.invoke(categoriesData)
            }

            Glide.with(itemView.context).load("https://png.pngtree.com/png-clipart/20200225/original/pngtree-call-center-operator-icon-circle-png-image_5282415.jpg")
                .into(ivAts)
        }
    }
}