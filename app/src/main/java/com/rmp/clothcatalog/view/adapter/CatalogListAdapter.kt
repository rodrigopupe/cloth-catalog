package com.rmp.clothcatalog.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rmp.clothcatalog.databinding.ItemProductBinding
import com.rmp.clothcatalog.utils.setImageFromUrl
import com.rmp.clothcatalog.utils.toCurrencyFormatted
import com.rmp.clothcatalog.utils.toFormattedRating
import com.rmp.clothcatalog.view.model.ProductUIModel

class CatalogListAdapter(
    private val onItemClick: (ProductUIModel) -> Unit
) : ListAdapter<ProductUIModel, CatalogListAdapter.ViewHolder>(ProductsDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogListAdapter.ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogListAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductUIModel) {
            with(binding) {
                ivProduct.setImageFromUrl(item.imageUrl)
                tvProductName.text = item.title
                tvProductPrice.text = item.price.toCurrencyFormatted()
                tvProductRate.text = item.rating.rate.toFormattedRating()

                root.setOnClickListener { onItemClick(item) }
            }
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