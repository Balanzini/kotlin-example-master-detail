package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by balanza on 17/02/17.
 */
class GetCharacterImp(val characterRepository: CharacterRepository) : GetCharacter {
  override fun getCharacter(
                            callbackSuccess: (CharacterDetail) -> Unit, callbackError: (String) -> Unit) {
    doAsync {
      val character = characterRepository.getCharacter()
      uiThread {
        if(character != null) {
          callbackSuccess(character)
        }
        else{
          callbackError("character unavailable")
        }
      }
    }
  }
}