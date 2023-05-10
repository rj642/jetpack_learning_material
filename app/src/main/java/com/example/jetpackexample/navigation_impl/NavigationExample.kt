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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackexample.MainActivity
import com.example.jetpackexample.navigation_impl.home.ui.HomeUi
import com.example.jetpackexample.navigation_impl.job.ui.JobUi
import com.example.jetpackexample.navigation_impl.mynetwork.ui.MyNetworkUi
import com.example.jetpackexample.navigation_impl.notification.ui.NotificationUi
import com.example.jetpackexample.navigation_impl.post.ui.PostUi
import com.example.jetpackexample.ui.theme.CustomTheme

class NavigationExample : ComponentActivity() {

    init {
        MainActivity.apply {
            ITEM
            whatMyName()
        }
    }

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

/**
 * Here we've created a navigation graph which is equivalent to xml navigation>nav_graph.xml file for a bottom sheet fragment
 */
@Composable
fun NavigationGraph(navController: NavHostController) {
    /**
     * To use this navHost and all the navigation component in compose.
     * Add the below dependency into your build.gradle(:app)
     * implementation "androidx.navigation:navigation-compose:2.6.0-beta01"
     */

    /**
     * NavHost is a composable function which accepts navController along with other arguments as well, but for this tutorial,
     * we'll stick with 2 parameters i.e. navController along with startDestination (Start destination is same as what we have in xml navigation_graph.xml)
     */
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        /**
         * Assume composable as a <fragment/> tag, since we don't have any fragment concept in jetpack compose hence, we'll be using composable extension to create those and add screens under it
         */

        /**
         * This extension function excepts you to pass route name along with Screen
         */
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

/**
 * Here, we're setting the BottomNavigation and adding a parameter for navController of type NavController
 */
@Composable
fun BottomNavigation(navController: NavController) {
    /**
     * It will have the list of item i.e. all the screen data
     */
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MyNetwork,
        BottomNavItem.Post,
        BottomNavItem.Notification,
        BottomNavItem.Job
    )
    /**
     * Added BottomNavigation which comes with compose
     */
    BottomNavigation(
        backgroundColor = Color.LightGray,
        contentColor = Color.Black
    ) {
        /**
         * For handling navigation and all
         */
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            /**
             * With this, you can style your bottom nav items by adding icon, label, show label along with handling clicks for redirection to different screens
             */
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
                alwaysShowLabel = false,
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

@Preview
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