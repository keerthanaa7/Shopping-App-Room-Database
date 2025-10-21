package com.example.shoppingeventsudemy.addevent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class AddEventViewModel : ViewModel() {
    var addEventUiState by mutableStateOf(AddEventUIState())

    fun updateUiState(addEventDetails: AddEventDetails) {
        addEventUiState = AddEventUIState(addEventDetails = addEventDetails, isEntryValid = validateInput(addEventDetails))
    }

    private fun validateInput(eventDetails: AddEventDetails = addEventUiState.addEventDetails): Boolean {
        return with(eventDetails) {
            name.isNotBlank() && eventDate.isNotBlank()
        }
    }
}