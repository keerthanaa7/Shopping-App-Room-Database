package com.example.shoppingeventsudemy

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingeventsudemy.addevent.AddEventpage
import com.example.shoppingeventsudemy.destinations.AddEventRoute
import com.example.shoppingeventsudemy.destinations.EventDetailsRoute
import com.example.shoppingeventsudemy.destinations.HomeRoutePage
import com.example.shoppingeventsudemy.eventdetails.EventDetailsPage
import com.example.shoppingeventsudemy.home.HomePage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingApp()
        }
    }
}

@Composable
fun ShoppingApp(){

    val navController = rememberNavController()
    NavHost(navController =  navController, startDestination = HomeRoutePage){
        composable<HomeRoutePage>{
            HomePage(navigateToAddEvent = {navController.navigate(route = AddEventRoute)})
        }

        composable<AddEventRoute>{
            AddEventpage(navigateUp = {navController.navigateUp()}, navigateBack = {navController.popBackStack()})
        }

        composable<EventDetailsRoute>{
            EventDetailsPage(navigateBack = {navController.popBackStack()}, navigateUp = {navController.navigateUp()})
        }
    }
}


