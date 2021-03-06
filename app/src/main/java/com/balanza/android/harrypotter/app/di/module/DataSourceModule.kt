package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.data.character.retrofit.CharacterRetrofitSource
import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by balanza on 14/02/17.
 */
@Module
class DataSourceModule {
    @Provides
    fun provideDataSource(characterMapper: CharacterMapper) : CharacterDataSource{
        return CharacterRetrofitSource(characterMapper)
    }
}