package com.balanza.android.harrypotter.data.character.retrofit.model

/**
 * Created by balanza on 14/02/17.
 */
open class CharacterBasicRetrofit(open val characterId : Int, open val name : String, open val house : String,
                                  open val houseId : Int, open val imageUrl : String)