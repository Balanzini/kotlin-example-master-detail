package com.balanza.android.harrypotter.domain.interactor.character

import android.util.Log
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.concurrent.Executors

/**
 * Created by balanza on 15/02/17.
 */
class GetAllCharactersImp(val characterRepository : CharacterRepository) : GetAllCharacters {

  override fun getAllCharacters(onCharactersAvailable: GetAllCharacters.OnCharactersAvailable) {
    doAsync{
      characterRepository.getAllCharacters(object : CharacterRepository.OnCharacterAvailable{
        override fun onSuccess(characterList: List<CharacterBasic>) {
          Log.i("balanzaa","vuelve del getall")
          uiThread {
            onCharactersAvailable.onSuccess(characterList)
          }
        }

        override fun onError(message: String?) {
          onCharactersAvailable.onError(message)
        }

      })
    }
    Log.i("balanzaa", "despues del async")
  }

}