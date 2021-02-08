package com.nurlan.diplomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.models.ClaimData
import com.nurlan.diplomproject.data.models.MonterData
import com.nurlan.diplomproject.databinding.FragmentMonterItemBinding

class MonterAdapter : RecyclerView.Adapter<MonterAdapter.ItemViewHolder>() {

    var model: List<ClaimData> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private lateinit var itemClick: (ClaimData) -> Unit

    fun setItemClick(itemClick: (model: ClaimData) -> Unit) {
        this.itemClick = itemClick
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
        val task = binding.itemClaimsTvTask
        val selectClaim = binding.fragmentMonterItemSelectClaim

        fun bind(claimData: ClaimData) {
            name.text = claimData.name
            phone.text = claimData.phone
            task.text = claimData.task
            selectClaim.setOnClickListener {
                if(claimData.selectClaim){
                    selectClaim.text = "Принять"
                }else{
                    selectClaim.text = "Отменить"
                }
                itemClick.invoke(claimData)
            }
        }
    }

}