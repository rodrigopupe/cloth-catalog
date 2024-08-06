package com.rmp.clothcatalog.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rmp.clothcatalog.databinding.FragmentCatalogListBinding
import com.rmp.clothcatalog.utils.BaseState
import com.rmp.clothcatalog.view.CatalogListViewModel
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

        loadData()
    }

    private fun loadData() {
        // Pra evitar o reload dos dados sempre que voltar da tela de detalhes
        if ((viewModel.productsResponse.value is BaseState.Success).not()) {
            viewModel.getProductsList()
        }
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

            is BaseState.Error -> showErrorMessage(it.errorMessage)
        }
    }

    private fun updateList(list: List<ProductUIModel>) {
        catalogAdapter.submitList(list)
        with(binding) {
            tvMessage.visibility = View.VISIBLE
            rvProductsCatalog.visibility = View.VISIBLE
        }
    }

    private fun onProductClick(product: ProductUIModel) {
        findNavController().navigate(
            CatalogListFragmentDirections.actionCatalogListToProductDetails(product)
        )
    }

    private fun showErrorMessage(message: String) {
        with(binding.includeErrorData) {
            tvErrorMessage.text = message

            btTryAgain.setOnClickListener {
                loadData()
                root.visibility = View.GONE
            }

            root.visibility = View.VISIBLE
        }
    }

    private fun showLoading() {
        binding.includeLoading.root.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.includeLoading.root.visibility = View.GONE
    }
}