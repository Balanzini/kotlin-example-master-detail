package com.balanza.android.harrypotter.ui.characterlist.presenter

import android.util.Log
import com.balanza.android.harrypotter.app.navigator.Navigator
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.interactor.character.FetchCharacter
import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharacters
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 13/02/17.
 */
class CharacterListPresenterImp(private val navigator: Navigator,
                                private val getAllCharacters: GetAllCharacters,
                                private val fetchCharacter: FetchCharacter) : CharacterListPresenter() {

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
      }

    })
  }

  override fun onItemClick(position: Int) {
    fetchCharacter.fetchCharacter(position, object : FetchCharacter.OnCharacterAvailable {
      override fun onSuccess(character: CharacterDetail) {
        view?.hideLoading()
        navigator.goToDetails(character.characterId)
      }

      override fun onError(message: String?) {
      }

    })
  }
}