package com.nhanhuynh.inventory_management.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhanhuynh.inventory_management.model.ProductData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<ProductData>>(emptyList())
    val products: StateFlow<List<ProductData>> get() = _products

    private val _totalValue = MutableStateFlow<Double>(0.0)
    val totalValue: StateFlow<Double> get() = _totalValue

    private val _searchResult = MutableStateFlow<String>("")
    val searchResult: StateFlow<String> get() = _searchResult

    private var isSortedAscending = true

    init {
        val initialProducts = listOf(
            ProductData("Laptop", 999.99, 5),
            ProductData("Smartphone", 499.99, 10),
            ProductData("Tablet", 299.99, 0),
            ProductData("Smartwatch", 199.99, 3)
        )
        _products.value = initialProducts
        updateTotalValue()
    }

    private fun updateTotalValue() {
        _totalValue.value = _products.value.sumByDouble( { it.price * it.quantity })
    }

    fun searchProduct(name: String) {
        val productFound = _products.value.find { it.name.equals(name, true) }
        _searchResult.value = if (productFound != null) {
            "Product is in the stock"
        } else {
            "Product is out of stock"
        }
    }

    fun toggleSortByPrice() {
        isSortedAscending = !isSortedAscending // Đảo ngược thứ tự sắp xếp
        _products.value = if (isSortedAscending) {
            _products.value.sortedBy { it.price }
        } else {
            _products.value.sortedByDescending { it.price }
        }
        updateTotalValue()
    }


    fun toggleSortByQuantity() {
        isSortedAscending = !isSortedAscending // Đảo ngược thứ tự sắp xếp
        _products.value = if (isSortedAscending) {
            _products.value.sortedBy { it.quantity }
        } else {
            _products.value.sortedByDescending { it.quantity }
        }
        updateTotalValue()
    }

}