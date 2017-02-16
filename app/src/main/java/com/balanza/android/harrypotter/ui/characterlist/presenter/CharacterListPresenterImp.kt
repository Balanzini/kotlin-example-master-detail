package com.balanza.android.harrypotter.ui.characterlist.presenter

import android.util.Log
import com.balanza.android.harrypotter.app.navigator.Navigator
import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharacters
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 13/02/17.
 */
class CharacterListPresenterImp(private val navigator: Navigator,
                                private val getAllCharacters: GetAllCharacters) : CharacterListPresenter() {

  override fun getCharacters() {
    getCharacters(false)
  }

  override fun refreshCharacters() {
    getCharacters(true)
  }

  internal fun getCharacters(refresh: Boolean) {
    getAllCharacters.getAllCharacters(refresh, object : GetAllCharacters.OnCharactersAvailable {
      override fun onSuccess(characters: List<CharacterBasic>) {
        view?.onCharactersAvailable(characters)
      }

      override fun onError(message: String?) {
        Log.i("balanzaa", "presenter error")
      }

    })
  }
}