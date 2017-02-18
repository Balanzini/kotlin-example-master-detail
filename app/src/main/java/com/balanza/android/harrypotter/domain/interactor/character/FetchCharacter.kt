package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail

/**
 * Created by balanza on 17/02/17.
 */
interface FetchCharacter {
  fun fetchCharacter(characterId: Int, onCharacterAvailable: OnCharacterAvailable)

  interface OnCharacterAvailable {
    fun onSuccess(character: CharacterDetail)
    fun onError(message: String?)
  }
}