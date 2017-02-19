package com.balanza.android.harrypotter.domain.interactor.character

import android.util.Log
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by balanza on 15/02/17.
 */
class GetAllCharactersImp(val characterRepository: CharacterRepository) : GetAllCharacters {

  override fun getAllCharacters(refresh: Boolean,
                                onCharactersAvailable: GetAllCharacters.OnCharactersAvailable) {

    doAsync {
      if (refresh) {
        characterRepository.clear()
      }

      characterRepository.getAllCharacters(object : CharacterRepository.OnCharacterAvailable {
        override fun onSuccess(characterList: List<CharacterBasic>) {
          uiThread {
            onCharactersAvailable.onSuccess(characterList)
          }
        }

        override fun onError(message: String?) {
          uiThread {
            onCharactersAvailable.onError(message)
          }
        }

      })
    }
  }

}