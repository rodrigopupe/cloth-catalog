package com.rmp.clothcatalog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rmp.clothcatalog.databinding.FragmentCatalogListBinding
import com.rmp.clothcatalog.utils.BaseState
import com.rmp.clothcatalog.view.adapter.CatalogListAdapter
import com.rmp.clothcatalog.view.model.ProductUIModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogListFragment : Fragment() {

    private val binding: FragmentCatalogListBinding by lazy {
        FragmentCatalogListBinding.inflate(layoutInflater)
    }

    private val catalogAdapter = CatalogListAdapter(::onProductClick)

    private val viewModel: CatalogListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerObservers()
        setupView()

        viewModel.getProductsList()
    }

    private fun registerObservers() {
        viewModel.productsResponse.observe(viewLifecycleOwner, productsObserver)
    }

    private fun setupView() {
        binding.rvProductsCatalog.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = catalogAdapter
        }
    }

    private val productsObserver = Observer<BaseState<List<ProductUIModel>>> {
        hideLoading()

        when (it) {
            is BaseState.Loading -> showLoading()

            is BaseState.Success -> updateList(it.data)

            is BaseState.Error -> {
                // TODO Implementar
            }
        }
    }

    private fun updateList(list: List<ProductUIModel>) {
        catalogAdapter.submitList(list)
        binding.rvProductsCatalog.visibility = View.VISIBLE
    }

    private fun onProductClick(product: ProductUIModel) {
        // TODO Implementar
    }

    private fun showLoading() {
        binding.progressIndicator.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.progressIndicator.visibility = View.GONE
    }
}