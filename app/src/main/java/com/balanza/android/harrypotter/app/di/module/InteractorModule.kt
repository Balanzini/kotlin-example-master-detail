package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.domain.interactor.character.*
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import dagger.Module
import dagger.Provides

/**
 * Created by balanza on 15/02/17.
 */
@Module
class InteractorModule {

  @Provides
  fun provideGetAllCharacters(
      characterRepository: CharacterRepository): GetAllCharacters = GetAllCharactersImp(
      characterRepository)

  @Provides
  fun provideFetchCharacter(
      characterRepository: CharacterRepository): FetchCharacter = FetchCharacterImp(
      characterRepository)

  @Provides
  fun provideGetCharacter(characterRepository: CharacterRepository): GetCharacter = GetCharacterImp(
      characterRepository)
}