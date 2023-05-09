package com.example.jetpackexample.navigation_impl

import com.example.jetpackexample.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {

    object Home: BottomNavItem("Home", R.drawable.ic_home, "home")
    object MyNetwork: BottomNavItem("My Network", R.drawable.ic_network, "my_network")
    object Post: BottomNavItem("Post", R.drawable.ic_add_post, "post")
    object Notification: BottomNavItem("Notification", R.drawable.ic_notification, "notification")
    object Job: BottomNavItem("Jobs", R.drawable.ic_job, "jobs")

}
