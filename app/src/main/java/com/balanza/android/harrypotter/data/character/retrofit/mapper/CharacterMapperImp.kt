package com.balanza.android.harrypotter.data.character.retrofit.mapper

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetailApi
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.balanza.android.harrypotter.domain.model.factory.HouseFactory

/**
 * Created by balanza on 15/02/17.
 */
class CharacterMapperImp : CharacterMapper {
  override fun charactersApiToCharactersModel(charactersApi: List<CharacterBasicRetrofit>):
      List<CharacterBasic> {
    val listCharacter = charactersApi.map { singleCharacterApiToCharacterModel(it) }
    return listCharacter
  }

  override fun characterApiToCharacterModel(
      characterDetailApi: CharacterDetailApi): CharacterDetail = CharacterDetail(
      characterDetailApi.name, characterDetailApi.last_name, characterDetailApi.birth,
      characterDetailApi.gender, HouseFactory.createHouse(characterDetailApi.house),
      characterDetailApi.wand_description, characterDetailApi.patronus)

  private fun singleCharacterApiToCharacterModel(characterApi: CharacterBasicRetrofit) =
      CharacterBasic(characterApi.characterId, characterApi.name,
          HouseFactory.createHouse(characterApi.houseId), characterApi.imageUrl)

}