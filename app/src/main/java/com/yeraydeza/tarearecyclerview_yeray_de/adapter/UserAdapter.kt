package com.yeraydeza.tarearecyclerview_yeray_de.adapter

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeraydeza.tarearecyclerview_yeray_de.R
import com.yeraydeza.tarearecyclerview_yeray_de.model.Repositories
import com.squareup.picasso.Picasso
import com.yeraydeza.tarearecyclerview_yeray_de.databinding.ItemListBinding


class UserAdapter(
    private val dataset: List<Repositories>,
    private val listener: (Repositories) -> Unit
):RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = ItemListBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.binding.tvName.text = item.name
        holder.binding.tvDescription.text = item.description
        Picasso.get()
            .load(item.picture)
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.binding.imgId)
        holder.binding.root.setOnClickListener { listener(item) }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }
    class ItemViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
}
