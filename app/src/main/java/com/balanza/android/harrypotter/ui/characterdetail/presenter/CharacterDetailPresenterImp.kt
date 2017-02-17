package com.balanza.android.harrypotter.ui.characterdetail.presenter

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.interactor.character.GetCharacter

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailPresenterImp(
    val getCharacterInteractor: GetCharacter) : CharacterDetailPresenter() {

  override fun getCharacter(characterId: Int) {
    getCharacterInteractor.getCharacter(characterId, object : GetCharacter.OnCharacterAvailable {
      override fun onSuccess(character: CharacterDetail) {
        view?.onCharacterAvailable(character.name, character.last_name, character.birth,
            character.house.detailBackground)
      }

      override fun onError(message: String?) {
      }

    })
  }
}