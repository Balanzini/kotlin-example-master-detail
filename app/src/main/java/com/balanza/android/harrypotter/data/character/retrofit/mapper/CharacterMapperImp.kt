package com.balanza.android.harrypotter.data.character.retrofit.mapper

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 15/02/17.
 */
class CharacterMapperImp : CharacterMapper {
    override fun charactersApiToCharactersModel(charactersApi: List<CharacterBasicRetrofit>):
            List<CharacterBasic> {
        val listCharacter = charactersApi.map { singleCharacterApiToCharacterModel(it) }
        return listCharacter
    }

    private fun singleCharacterApiToCharacterModel(characterApi: CharacterBasicRetrofit) =
            CharacterBasic(characterApi.characterId, characterApi.name, characterApi.houseId,
                    characterApi.house, characterApi.imageUrl)

}