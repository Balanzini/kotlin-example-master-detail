package com.balanza.android.harrypotter.ui.characterlist.presenter

import android.os.Handler
import android.util.Log
import com.balanza.android.harrypotter.app.navigator.Navigator
import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 13/02/17.
 */
class CharacterListPresenterImp(private val navigator: Navigator) : CharacterListPresenter() {

    override fun check() {
        Log.i("balanzaa", "presenter is function")
        dataSource.getAllCharacter(object : CharacterDataSource.OnCharacterAvailable{
            override fun onCharacterAvailable(characterList: List<CharacterBasic>) {
            }

            override fun onError() {
            }

        })
    }
}