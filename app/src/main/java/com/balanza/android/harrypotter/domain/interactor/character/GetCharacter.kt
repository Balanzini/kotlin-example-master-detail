package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail

/**
 * Created by balanza on 17/02/17.
 */
interface GetCharacter {
  fun getCharacter(characterId: Int, callbackSuccess: (CharacterDetail) -> Unit,
                   callbackError: (String) -> Unit)
}