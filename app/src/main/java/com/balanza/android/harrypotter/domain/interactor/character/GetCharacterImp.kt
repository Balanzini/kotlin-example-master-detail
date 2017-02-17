package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
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
      characterRepository.getCharacter(characterId,
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