package com.balanza.android.harrypotter.domain.repository.character

import com.balanza.android.harrypotter.domain.model.character.CharacterBasic

/**
 * Created by balanza on 14/02/17.
 */
interface CharacterRepository {
    fun getAllCharacters(onCharacterAvailable: OnCharacterAvailable)

    fun clear()

    interface OnCharacterAvailable {
        fun onSuccess(characterList: List<CharacterBasic>)
        fun onError(message : String?)
    }
}