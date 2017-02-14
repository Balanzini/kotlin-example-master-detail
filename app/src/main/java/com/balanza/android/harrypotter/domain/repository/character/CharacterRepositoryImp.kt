package com.balanza.android.harrypotter.domain.repository.character

import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import java.util.*

/**
 * Created by balanza on 14/02/17.
 */
class CharacterRepositoryImp(private val dataSource : CharacterDataSource) : CharacterRepository {

    var characterList = ArrayList<CharacterBasic>()

    override fun getAllCharacters(onCharacterAvailable: CharacterRepository.OnCharacterAvailable) {
        if(characterList.isEmpty()){
            dataSource.getAllCharacter(object : CharacterDataSource.OnCharacterAvailable{
                override fun onCharacterAvailable(characterListResource: List<CharacterBasic>) {
                    characterList.clear()
                    characterList.addAll(characterListResource)
                }

                override fun onError() {
                }

            })
        }
    }
}