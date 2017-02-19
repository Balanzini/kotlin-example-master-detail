package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by balanza on 15/02/17.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(characterDataSource: CharacterDataSource) : CharacterRepository{
        return CharacterRepositoryImp(characterDataSource)
    }
}