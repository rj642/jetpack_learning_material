package com.example.jetpackexample.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.View

object Util {

    @JvmStatic
    fun Context.log(message: String) {
        Log.d("TAG:: ", message)
    }

    @JvmStatic
    fun Activity.logMain(message: String) {
        Log.d("TAG::", message)
    }

    @JvmStatic
    fun Activity.createDialog(view: View): Dialog {
        return Dialog(this)
    }

}