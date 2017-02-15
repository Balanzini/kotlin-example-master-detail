package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharacters
import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharactersImp
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import dagger.Module
import dagger.Provides

/**
 * Created by balanza on 15/02/17.
 */
@Module
class InteractorModule {

  @Provides
  fun provideGetAllCharacters(characterRepository : CharacterRepository) : GetAllCharacters{
    return GetAllCharactersImp(characterRepository)
  }
}