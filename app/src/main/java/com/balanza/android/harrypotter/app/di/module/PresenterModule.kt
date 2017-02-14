package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.app.navigator.Navigator
import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.ui.characterlist.presenter.CharacterListPresenter
import com.balanza.android.harrypotter.ui.characterlist.presenter.CharacterListPresenterImp
import dagger.Module
import dagger.Provides

/**
 * Created by balanza on 13/02/17.
 */
@Module
class PresenterModule {

    @Provides
    fun provideCharacterListPresenter(navigator: Navigator, characterDataSource: CharacterDataSource) : CharacterListPresenter{
        return CharacterListPresenterImp(navigator, characterDataSource)
    }
}