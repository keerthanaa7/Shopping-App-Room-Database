package com.example.shoppingeventsudemy.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppingeventsudemy.customcomposables.ShoppingAppBar

@Composable
fun HomePage(navigateToAddEvent:() -> Unit) {
    Scaffold(topBar = {
        ShoppingAppBar(
            title = "Shopping event",
            canNavigate = false
        ) { }
    },
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToAddEvent) {
                Icon(Icons.Default.Add, null)
            }
        }) { paddingValues -> Text(text = "Home Page", modifier = Modifier.padding(paddingValues)) }

}