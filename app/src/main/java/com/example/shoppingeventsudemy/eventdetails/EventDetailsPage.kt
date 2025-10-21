package com.example.shoppingeventsudemy.eventdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppingeventsudemy.customcomposables.ShoppingAppBar

@Composable
fun EventDetailsPage(navigateBack:() -> Unit,
                 navigateUp:() -> Unit) {
    Scaffold(topBar = {
        ShoppingAppBar(
            title = "Event details",
            canNavigate = true,

        ) { navigateUp}
    }) { paddingValues -> Text(text = "Add Event", modifier = Modifier.padding(paddingValues)) }

}