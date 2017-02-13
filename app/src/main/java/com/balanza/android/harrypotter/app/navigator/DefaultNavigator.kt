package com.balanza.android.harrypotter.app.navigator

import android.app.Activity

/**
 * Created by balanza on 13/02/17.
 */
class DefaultNavigator : Navigator {
    override var activity: Activity? = null
        get() = field
        set(value) {
            field = value
        }


//    override fun setMyActivity(activity: Activity?) {
//        this.activity = activity
//    }

    override fun finish() {
        activity?.finish()
    }

}