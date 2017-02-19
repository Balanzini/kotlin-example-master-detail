package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 15/02/17.
 */
interface GetAllCharacters {

  fun getAllCharacters(refresh : Boolean, onCharactersAvailable: OnCharactersAvailable)

  interface OnCharactersAvailable {
    fun onSuccess(characters: List<CharacterBasic>)
    fun onError(message: String?)
  }
}