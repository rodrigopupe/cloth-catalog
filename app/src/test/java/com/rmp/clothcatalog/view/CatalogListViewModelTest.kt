package com.rmp.clothcatalog.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rmp.clothcatalog.MyApplication
import com.rmp.clothcatalog.ProductMockData
import com.rmp.clothcatalog.data.repository.contracts.ProductsRepository
import com.rmp.clothcatalog.utils.BaseState
import com.rmp.clothcatalog.view.model.ProductUIModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException

@ExperimentalCoroutinesApi
class CatalogListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val appMock: MyApplication = mockk {
        every { resources.getString(any()) } returns "Aqui está a mensagem de erro"
    }

    private val repository: ProductsRepository = mockk()

    private lateinit var viewModel: CatalogListViewModel

    private val dispatcher: TestDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = CatalogListViewModel(appMock, repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `When fetching Products unsuccessfully, both Loading and Error states are shown`() {
        coEvery { repository.getProductsList() } throws mockk<HttpException>()

        val uiStates = mutableListOf<BaseState<List<ProductUIModel>>>()
        viewModel.productsResponse.observeForever {
            uiStates.add(it)
        }

        viewModel.getProductsList()
        dispatcher.scheduler.advanceUntilIdle()

        assert(uiStates.first() is BaseState.Loading)
        assert(uiStates.last() is BaseState.Error)
    }

    @Test
    fun `When fetching Products successfully, both Loading and Success states are shown`() {
        coEvery { repository.getProductsList() } returns mockk()

        val uiStates = mutableListOf<BaseState<List<ProductUIModel>>>()
        viewModel.productsResponse.observeForever {
            uiStates.add(it)
        }

        viewModel.getProductsList()
        dispatcher.scheduler.advanceUntilIdle()

        assert(uiStates.first() is BaseState.Loading)
        assert(uiStates.last() is BaseState.Success)
    }

    @Test
    fun `When fetching Products successfully, it returns ProductUIModel list`() {
        val mockedResponse = ProductMockData.getFakeProductList()
        coEvery { repository.getProductsList() } returns mockedResponse

        viewModel.getProductsList()
        dispatcher.scheduler.advanceUntilIdle()

        assert((viewModel.productsResponse.value as BaseState.Success).data == mockedResponse)
    }

    @Test
    fun `When error fetching Products, there is an errorMessage`() {
        coEvery { repository.getProductsList() } throws mockk<HttpException>()

        viewModel.getProductsList()
        dispatcher.scheduler.advanceUntilIdle()

        assert((viewModel.productsResponse.value as BaseState.Error).errorMessage.isNotBlank())
    }
}