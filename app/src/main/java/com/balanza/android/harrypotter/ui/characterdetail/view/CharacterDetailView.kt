package com.balanza.android.harrypotter.ui.characterdetail.view

import com.balanza.android.harrypotter.ui.View

/**
 * Created by balanza on 17/02/17.
 */
interface CharacterDetailView : View{
  companion object {
    val CHARACTER_ID = "characterId"
  }

  fun onCharacterAvailable(name : String, lastName : String, birth : String, background : Int)
}