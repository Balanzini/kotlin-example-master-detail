package com.balanza.android.harrypotter.app.base

import com.balanza.android.harrypotter.ui.View

/**
 * Created by balanza on 13/02/17.
 */
abstract class BasePresenter<T : View> {
    val view : T? = null
}