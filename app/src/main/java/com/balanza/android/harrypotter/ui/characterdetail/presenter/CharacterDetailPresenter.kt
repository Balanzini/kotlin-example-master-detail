package com.balanza.android.harrypotter.ui.characterdetail.presenter

import com.balanza.android.harrypotter.app.base.BasePresenter
import com.balanza.android.harrypotter.ui.characterdetail.view.CharacterDetailView

/**
 * Created by balanza on 17/02/17.
 */
abstract class CharacterDetailPresenter : BasePresenter<CharacterDetailView>(){

  abstract fun getCharacter(characterId : Int)
}