package com.abrorbek_uz.currencyconverter.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.abrorbek_uz.retrofitt.databinding.RvItemBinding
import com.abrorbek_uz.retrofitt.models.TodoGetResponseItem


class MyAdapter(var list: List<TodoGetResponseItem>) : RecyclerView.Adapter<MyAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItemBinding):RecyclerView.ViewHolder(rvItemBinding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(user: TodoGetResponseItem, position: Int ){
            rvItemBinding.tv1.text = user.sarlavha.toString()
            rvItemBinding.tv2.text = user.batafsil
            rvItemBinding.diff2.text = user.oxirgi_muddat.toString()
            rvItemBinding.diff.text = user.sana


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}