package com.balanza.android.harrypotter.data.character.retrofit.model

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailApi(val characterId: Int, val name: String, val last_name: String,
                         val birth: String, val gender: String, val house: Int,
                         val wand_description: String, val patronus: String)