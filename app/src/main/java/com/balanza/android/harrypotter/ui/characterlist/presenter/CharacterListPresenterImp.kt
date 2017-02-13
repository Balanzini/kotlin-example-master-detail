package com.balanza.android.harrypotter.ui.characterlist.presenter

import android.os.Handler
import android.util.Log
import com.balanza.android.harrypotter.app.navigator.Navigator

/**
 * Created by balanza on 13/02/17.
 */
class CharacterListPresenterImp(val navigator: Navigator) : CharacterListPresenter() {

    override fun check() {
        Log.i("balanzaa", "presenter is function")
        val handler = Handler()
        handler.postDelayed({
            navigator.finish()
        }, 3000)
    }
}