package com.balanza.android.harrypotter.domain.model.character

import com.balanza.android.harrypotter.domain.model.house.House

/**
 * Created by balanza on 14/02/17.
 */
data class CharacterBasic(val characterId: Int, val name: String, val house: House,
                          val imageUrl: String)