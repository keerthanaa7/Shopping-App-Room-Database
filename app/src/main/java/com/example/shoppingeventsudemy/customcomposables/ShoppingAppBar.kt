package com.example.shoppingeventsudemy.customcomposables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingAppBar(
    title: String,
    canNavigate: Boolean,
    onNavigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(title) }, modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            if (canNavigate) {
                IconButton(onNavigateUp) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
            }
        }
    )
}