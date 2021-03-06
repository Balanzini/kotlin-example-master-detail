package com.balanza.android.harrypotter.app.di.module

import com.balanza.android.harrypotter.app.navigator.Navigator
import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharacters
import com.balanza.android.harrypotter.domain.interactor.character.FetchCharacter
import com.balanza.android.harrypotter.domain.interactor.character.GetCharacter
import com.balanza.android.harrypotter.domain.interactor.character.GetPointsWin
import com.balanza.android.harrypotter.ui.characterdetail.presenter.CharacterDetailPresenter
import com.balanza.android.harrypotter.ui.characterdetail.presenter.CharacterDetailPresenterImp
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
  fun provideCharacterListPresenter(navigator: Navigator,
                                    getAllCharacters: GetAllCharacters,
                                    fetchCharacter: FetchCharacter): CharacterListPresenter {
    return CharacterListPresenterImp(navigator, getAllCharacters, fetchCharacter)
  }

  @Provides
  fun provideCharacterDetailPresenter(getCharacter: GetCharacter,
                                      getPointsWin: GetPointsWin): CharacterDetailPresenter = CharacterDetailPresenterImp(
      getCharacter, getPointsWin)
}