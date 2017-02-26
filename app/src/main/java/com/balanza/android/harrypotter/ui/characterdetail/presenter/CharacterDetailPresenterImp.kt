package com.balanza.android.harrypotter.ui.characterdetail.presenter

import android.util.Log
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.interactor.character.GetCharacter
import com.balanza.android.harrypotter.domain.interactor.character.GetPointsWin

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailPresenterImp(
    val getCharacterInteractor: GetCharacter, val getPointsWin: GetPointsWin) : CharacterDetailPresenter() {

  override fun getCharacter() {

    val success : (CharacterDetail)->Unit = {
      with(it) {
        view?.onCharacterAvailable(name, last_name, birth,
            gender, house.name, wand_description, patronus,
            urlImage, house.detailBackground, house.primaryColor)
      }
    }
    getCharacterInteractor.getCharacter( {
      success(it)
    }, {

    })
  }

  override fun assignmentOfPoints(functionPoints: (Int, String) -> Unit) {
    getPointsWin.getPoints(functionPoints)
  }
}