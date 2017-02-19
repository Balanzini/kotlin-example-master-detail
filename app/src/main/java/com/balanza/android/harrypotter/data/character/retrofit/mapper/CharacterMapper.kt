package com.balanza.android.harrypotter.data.character.retrofit.mapper

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetailApi
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 15/02/17.
 */
interface CharacterMapper {
  fun charactersApiToCharactersModel(
      charactersApi: List<CharacterBasicRetrofit>): List<CharacterBasic>

  fun characterApiToCharacterModel(characterDetailApi: CharacterDetailApi): CharacterDetail
}