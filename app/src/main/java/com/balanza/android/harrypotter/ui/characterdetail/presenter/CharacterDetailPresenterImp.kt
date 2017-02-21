package com.balanza.android.harrypotter.ui.characterdetail.presenter

import android.util.Log
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.interactor.character.GetCharacter

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailPresenterImp(
    val getCharacterInteractor: GetCharacter) : CharacterDetailPresenter() {

  override fun getCharacter() {
    Log.i("balanzaa", "llega 0")

    val success : (CharacterDetail)->Unit = {
      Log.i("balanzaa", "llega 2")
      with(it) {
        Log.i("balanzaa", "llega 3 $name")
        view?.onCharacterAvailable(name, last_name, birth,
            gender, house.name, wand_description, patronus,
            urlImage, house.detailBackground, house.primaryColor)
      }
    }
    getCharacterInteractor.getCharacter( {
      Log.i("balanzaa", "llega 1")
      success(it)
    }, {

    })
  }
}