package com.nhanhuynh.inventory_management.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.nhanhuynh.inventory_management.model.ProductData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nhanhuynh.inventory_management.view_model.ProductViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(viewModel: ProductViewModel = viewModel()) {
    val products = viewModel.products.collectAsState().value
    val totalValue = viewModel.totalValue.collectAsState().value
    val searchResult = viewModel.searchResult.collectAsState().value

    var searchText by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
           modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Search product") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Button(onClick = { viewModel.searchProduct(searchText) }) {
                    Text("Search")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = { viewModel.toggleSortByPrice() }) {
                    Text("Sort by Price")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = { viewModel.toggleSortByQuantity() }) {
                    Text("Sort by Quantity")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = searchResult , color = MaterialTheme.colorScheme.primary)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Total Value: \$${"%.2f".format(totalValue)}")

            Spacer(modifier = Modifier.height(16.dp))

            for (product in products) {
                ProductItem(product)
            }
        }
    }
}

@Composable
fun ProductItem(product: ProductData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Text("Name: ${product.name}")
        Text("Price: ${product.price}")
        Text("Quantity: ${product.quantity}")
    }
}