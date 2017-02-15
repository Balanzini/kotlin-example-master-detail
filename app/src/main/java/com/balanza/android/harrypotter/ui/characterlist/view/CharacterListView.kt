package com.balanza.android.harrypotter.ui.characterlist.view

import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.balanza.android.harrypotter.ui.View

/**
 * Created by balanza on 13/02/17.
 */
interface CharacterListView : View{
  fun onCharactersAvailable(characterList : List<CharacterBasic>)
}