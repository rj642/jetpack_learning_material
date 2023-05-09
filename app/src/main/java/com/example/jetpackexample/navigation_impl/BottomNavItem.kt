package com.example.jetpackexample.navigation_impl

import com.example.jetpackexample.R

/**
 * Sealed class is created to have all the child item so that none of the cases is missed
 */

/**
 * This class consists of title along with icon and screenRouter name
 */
sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {

    /**
     * Assume these objects as a menu item just like how we create in standard xml
     */
    object Home: BottomNavItem("Home", R.drawable.ic_home, "home")
    object MyNetwork: BottomNavItem("My Network", R.drawable.ic_network, "my_network")
    object Post: BottomNavItem("Post", R.drawable.ic_add_post, "post")
    object Notification: BottomNavItem("Notification", R.drawable.ic_notification, "notification")
    object Job: BottomNavItem("Jobs", R.drawable.ic_job, "jobs")

}
