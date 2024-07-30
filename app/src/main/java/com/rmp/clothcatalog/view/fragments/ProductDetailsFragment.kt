package com.rmp.clothcatalog.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.rmp.clothcatalog.databinding.FragmentProductDetailsBinding
import com.rmp.clothcatalog.utils.setImageFromUrl
import com.rmp.clothcatalog.utils.toCurrencyFormatted
import com.rmp.clothcatalog.utils.toFormattedRating
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private val binding: FragmentProductDetailsBinding by lazy {
        FragmentProductDetailsBinding.inflate(layoutInflater)
    }

    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        with(args.product) {
            binding.apply {
                tvProductName.text = title
                ivProduct.setImageFromUrl(imageUrl)
                tvProductDescription.text = description
                tvCategory.text = category
                tvPrice.text = price.toCurrencyFormatted()
                tvProductRate.text = rating.toFormattedRating()
            }
        }
    }
}