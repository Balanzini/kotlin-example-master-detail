package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapper
import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapperImp
import dagger.Module
import dagger.Provides

/**
 * Created by balanza on 15/02/17.
 */
@Module
class MapperModule {

  @Provides
  fun provideCharacterMapper() : CharacterMapper{
    return CharacterMapperImp()
  }
}