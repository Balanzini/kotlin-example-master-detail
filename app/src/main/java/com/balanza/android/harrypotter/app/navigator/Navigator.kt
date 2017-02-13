package com.balanza.android.harrypotter.app.navigator

import android.app.Activity

/**
 * Created by balanza on 13/02/17.
 */
interface Navigator {
    var activity : Activity?
//        set(value) {
//            field = value
//        }
//    fun setActivity(activity: Activity?)
    fun finish()
}