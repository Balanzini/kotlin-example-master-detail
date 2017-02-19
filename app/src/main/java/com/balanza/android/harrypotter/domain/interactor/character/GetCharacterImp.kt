package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by balanza on 17/02/17.
 */
class GetCharacterImp(val characterRepository: CharacterRepository) : GetCharacter {
  override fun getCharacter(characterId: Int,
                              onCharacterAvailable: GetCharacter.OnCharacterAvailable) {
    doAsync {
      val character = characterRepository.getCharacter(characterId)
      uiThread {
        if(character != null) {
          onCharacterAvailable.onSuccess(character)
        }
        else{
          onCharacterAvailable.onError("character unavailable")
        }
      }
    }
  }
}