package com.balanza.android.harrypotter.app.base

import android.app.Activity
import android.os.Bundle
import com.balanza.android.harrypotter.ui.View

/**
 * Created by balanza on 13/02/17.
 */
abstract class BaseActivity : Activity(), View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doInjection()

    }

    abstract fun doInjection()
}