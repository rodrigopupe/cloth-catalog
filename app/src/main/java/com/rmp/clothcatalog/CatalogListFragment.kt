package com.rmp.clothcatalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rmp.clothcatalog.databinding.FragmentCatalogListBinding

class CatalogListFragment : Fragment() {

    private val binding: FragmentCatalogListBinding by lazy {
        FragmentCatalogListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}