package com.nhanhuynh.missing_number.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NumberViewModel : ViewModel() {
    private val _numbers = MutableStateFlow<List<Int>>(emptyList())
    val numbers: StateFlow<List<Int>> get() = _numbers

    private val _missingNumber = MutableStateFlow<String?>(null) // Thay đổi kiểu dữ liệu thành String
    val missingNumber: StateFlow<String?> get() = _missingNumber

    val isFirstLoad= MutableStateFlow <Boolean>(true)

    fun addNumber(number: Int) {
        _numbers.value += number
    }

    fun findMissingNumber() {
        isFirstLoad.value = false
        val n = _numbers.value.size + 1
        val total = (n * (n + 1)) / 2
        val sumOfNumbers = _numbers.value.sum()
        val missing = total - sumOfNumbers

        _missingNumber.value = if (missing in 1..n) {
            "Missing Number: $missing"
        } else {
            "No missing numbers"
        }
    }

    fun clearNumbers() {
        _numbers.value = emptyList()
        _missingNumber.value = null
    }
}