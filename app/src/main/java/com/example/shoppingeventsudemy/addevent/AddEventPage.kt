package com.example.shoppingeventsudemy.addevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppingeventsudemy.customcomposables.ShoppingAppBar

@Composable
fun AddEventpage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    viewModel: AddEventViewModel = viewModel()
) {
    Scaffold(topBar = {
        ShoppingAppBar(
            title = "Add event",
            canNavigate = true,
            onNavigateUp = navigateUp
        )
    }) { paddingValues ->
        EventForm(
            Modifier.padding(paddingValues), uiState = viewModel.addEventUiState,
            onEventValueChange = viewModel::updateUiState
        ) { }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventForm(
    modifier: Modifier, uiState: AddEventUIState,
    onEventValueChange: (AddEventDetails) -> Unit,
    onSaveClick: () -> Unit
) {
    val openDatePickerDialog by remember { mutableStateOf(false) }
    val datepickerstate = rememberDatePickerState()
    Column(
        modifier = modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextInputField(addEventDetails = uiState.addEventDetails,
            onEventValueChange = onEventValueChange)
    }
}


@Composable
fun TextInputField(
    addEventDetails: AddEventDetails,
    onEventValueChange: (AddEventDetails) -> Unit
) {
    Column {
        OutlinedTextField(
            value = addEventDetails.name,
            onValueChange = { onEventValueChange(addEventDetails.copy(name = it)) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Event name") }
        )

        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = addEventDetails.initialBudget,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            onValueChange = {
                onEventValueChange(addEventDetails.copy(initialBudget = it))
            })
    }

}