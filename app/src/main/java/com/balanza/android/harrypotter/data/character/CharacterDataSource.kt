package com.balanza.android.harrypotter.data.character

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 14/02/17.
 */
interface CharacterDataSource {

    fun getAllCharacter(onCharacterAvailable: OnCharacterAvailable)

    fun getCharacter(characterId : Int, onSuccess: (CharacterDetail) -> Unit,
                     onError: (String?) -> Unit)

    interface OnCharacterAvailable{
        fun onCharacterAvailable(characterList : List<CharacterBasic>)
        fun onError(message : String?)
    }

}