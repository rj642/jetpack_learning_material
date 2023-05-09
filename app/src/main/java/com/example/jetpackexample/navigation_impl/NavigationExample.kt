package com.example.jetpackexample.navigation_impl

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackexample.R
import com.example.jetpackexample.navigation_impl.home.ui.HomeUi
import com.example.jetpackexample.navigation_impl.job.ui.JobUi
import com.example.jetpackexample.navigation_impl.mynetwork.ui.MyNetworkUi
import com.example.jetpackexample.navigation_impl.notification.ui.NotificationUi
import com.example.jetpackexample.navigation_impl.post.ui.PostUi
import com.example.jetpackexample.ui.theme.CustomTheme

class NavigationExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CustomTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    MainScreen()
                }

            }

        }
    }

}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeUi.HomeScreen()
        }
        composable(BottomNavItem.MyNetwork.screenRoute) {
            MyNetworkUi.MyNetworkScreen()
        }
        composable(BottomNavItem.Post.screenRoute) {
            PostUi.PostScreen()
        }
        composable(BottomNavItem.Notification.screenRoute) {
            NotificationUi.NotificationScreen()
        }
        composable(BottomNavItem.Job.screenRoute) {
            JobUi.JobScreen()
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MyNetwork,
        BottomNavItem.Post,
        BottomNavItem.Notification,
        BottomNavItem.Job
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.LightGray,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigation(navController = navController)
    }
    ) {
        NavigationGraph(navController = navController)
    }
}