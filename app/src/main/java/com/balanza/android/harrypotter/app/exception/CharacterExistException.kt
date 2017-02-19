package com.balanza.android.harrypotter.app.exception

/**
 * Created by balanza on 17/02/17.
 */
class CharacterExistException(characterId: Int,
                              message: String = "Character with id $characterId  doesn't exists") : Exception(
    message)