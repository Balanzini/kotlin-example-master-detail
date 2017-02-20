package com.balanza.android.harrypotter.ui.characterdetail.presenter

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.interactor.character.GetCharacter

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailPresenterImp(
    val getCharacterInteractor: GetCharacter) : CharacterDetailPresenter() {

  override fun getCharacter(characterId: Int) {
    val success : (CharacterDetail)->Unit = {
      with(it) {
        view?.onCharacterAvailable(name, last_name, birth,
            gender, house.name, wand_description, patronus,
            urlImage, house.detailBackground, house.primaryColor)
      }
    }
    getCharacterInteractor.getCharacter(characterId, {
      success(it)
    }, {

    })
  }
}