package com.nhanhuynh.missing_number.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.nhanhuynh.missing_number.viewModel.NumberViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberScreen(viewModel: NumberViewModel = viewModel()) {
    val numbers = viewModel.numbers.collectAsState().value

    val missingNumber = viewModel.missingNumber.collectAsState().value
    val isFirstLoad = viewModel.isFirstLoad.collectAsState().value

    var inputText by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = inputText,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = { inputText = it },
            label = { Text("Enter a number") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {

            val number = inputText.toIntOrNull()


            if (number != null) {
                viewModel.addNumber(number)
                inputText = ""
            }
        }) {
            Text("Add Number")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Number added $numbers")


        if(numbers.isEmpty() && !isFirstLoad) {
            Text("The list of number must be not blank",color = MaterialTheme.colorScheme.error)
        }

        Button(onClick = {
            viewModel.findMissingNumber()
        }) {
            Text("Find Missing Number")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = missingNumber ?: "",color =  MaterialTheme.colorScheme.primary)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.clearNumbers()
        }) {
            Text("Clear Numbers")
        }
    }
}