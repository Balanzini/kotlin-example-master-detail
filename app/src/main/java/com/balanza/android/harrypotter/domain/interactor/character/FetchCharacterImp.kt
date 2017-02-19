package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by balanza on 17/02/17.
 */
class FetchCharacterImp(val characterRepository: CharacterRepository) : FetchCharacter {
  override fun fetchCharacter(characterId: Int,
                              onCharacterAvailable: FetchCharacter.OnCharacterAvailable) {
    doAsync {
      characterRepository.fetchCharacter(characterId,
          object : CharacterRepository.OnCharacterDetails {
            override fun onCharacterDetailsAvailable(characterDetails: CharacterDetail) {
              uiThread {
                onCharacterAvailable.onSuccess(characterDetails)
              }
            }

            override fun onError(message: String?) {
              uiThread {
                onCharacterAvailable.onError(message)
              }
            }

          })
    }
  }
}