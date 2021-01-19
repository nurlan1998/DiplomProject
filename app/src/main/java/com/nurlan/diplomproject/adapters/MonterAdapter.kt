package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.models.MonterData

class MonterAdapter:RecyclerView.Adapter<MonterAdapter.ItemViewHolder>() {


    var model:List<MonterData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }



    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

            fun bind(monterData: MonterData){

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_monter_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
      holder.bind(model[position])

    }

    override fun getItemCount(): Int = model.size


}