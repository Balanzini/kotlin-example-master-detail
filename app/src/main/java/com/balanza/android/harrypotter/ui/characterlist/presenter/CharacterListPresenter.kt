package com.balanza.android.harrypotter.ui.characterlist.presenter

import com.balanza.android.harrypotter.app.base.BasePresenter
import com.balanza.android.harrypotter.ui.characterlist.view.CharacterListView

/**
 * Created by balanza on 13/02/17.
 */
abstract class CharacterListPresenter : BasePresenter<CharacterListView>() {

    abstract fun check()

}