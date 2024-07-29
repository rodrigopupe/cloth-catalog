package com.rmp.clothcatalog.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rmp.clothcatalog.databinding.ItemProductBinding
import com.rmp.clothcatalog.view.model.ProductUIModel

class CatalogListAdapter(
    private val onItemClick: (ProductUIModel) -> Unit
) : ListAdapter<ProductUIModel, CatalogListAdapter.ViewHolder>(ProductsDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogListAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CatalogListAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductUIModel) {

        }
    }


    class ProductsDiffCallback : DiffUtil.ItemCallback<ProductUIModel>() {
        override fun areItemsTheSame(oldItem: ProductUIModel, newItem: ProductUIModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductUIModel, newItem: ProductUIModel): Boolean {
            return oldItem == newItem
        }

    }
}