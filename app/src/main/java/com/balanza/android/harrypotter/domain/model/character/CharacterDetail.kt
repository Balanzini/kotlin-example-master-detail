package com.balanza.android.harrypotter.data.character.retrofit.model

import com.balanza.android.harrypotter.domain.model.house.House

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetail(val characterId: Int, val name: String, val last_name: String,
                      val birth: String, val gender: String, val house: House,
                      val wand_description: String, val patronus: String, var urlImage : String = "")