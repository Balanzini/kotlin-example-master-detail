package com.balanza.android.harrypotter.domain.repository.character

import android.util.Log
import com.balanza.android.harrypotter.app.exception.CharacterExistException
import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import java.util.*

/**
 * Created by balanza on 14/02/17.
 */
open class CharacterRepositoryImp(private val dataSource: CharacterDataSource) : CharacterRepository {

  private var characterList = ArrayList<CharacterBasic>()
  private var currentCharacterDetail: CharacterDetail? = null

  override fun getAllCharacters(onCharacterAvailable: CharacterRepository.OnCharacterAvailable) {
    if (characterList.isEmpty()) {
      fetchCharacters(onCharacterAvailable)
    } else {
      onCharacterAvailable.onSuccess(characterList)
    }
  }

  override fun fetchCharacter(characterId: Int,
                              onCharacterDetails: CharacterRepository.OnCharacterDetails) {
    dataSource.getCharacter(characterId, {
      currentCharacterDetail = it
      val characterBasic = getCharacterById(it.characterId)
      currentCharacterDetail?.urlImage = characterBasic.imageUrl
      onCharacterDetails.onCharacterDetailsAvailable(it)
    }, {
      onCharacterDetails.onError(it)
    })
  }

  override fun getCharacter(): CharacterDetail? {
    return currentCharacterDetail

  }

  private fun getCharacterById(characterId : Int) : CharacterBasic{
    characterList
        .filter { characterId == it.characterId }
        .forEach { return it }
    throw CharacterExistException(characterId)
  }

  override fun clear() {
    characterList.clear()
  }

  private fun fetchCharacters(onCharacterAvailable: CharacterRepository.OnCharacterAvailable) {
    dataSource.getAllCharacter(object : CharacterDataSource.OnCharacterAvailable {
      override fun onCharacterAvailable(characterListResource: List<CharacterBasic>) {
        characterList.clear()
        characterList.addAll(characterListResource)
        onCharacterAvailable.onSuccess(characterList)
      }

      override fun onError(message: String?) {
        onCharacterAvailable.onError(message)
      }

    })
  }
}