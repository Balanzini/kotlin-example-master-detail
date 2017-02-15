package com.balanza.android.harrypotter.mapper

import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapper
import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapperImp
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import de.jodamob.kotlin.testrunner.KotlinTestRunner
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Created by balanza on 15/02/17.
 */
@RunWith(KotlinTestRunner::class)
class CharacterMapperTestKt {

  internal var character1 = mock<CharacterBasicRetrofit> {
    on { name }.doReturn("character1")
    on { characterId }.doReturn(0)
    on { house }.doReturn("house")
    on { houseId }.doReturn(0)
    on { imageUrl }.doReturn("imageUrl")
  }
  internal var character2 = mock<CharacterBasicRetrofit> {
    on { name }.doReturn("character2")
    on { characterId }.doReturn(0)
    on { house }.doReturn("house")
    on { houseId }.doReturn(0)
    on { imageUrl }.doReturn("imageUrl")
  }
  internal var character3 = mock<CharacterBasicRetrofit> {
    on { name }.doReturn("character3")
    on { characterId }.doReturn(0)
    on { house }.doReturn("house")
    on { houseId }.doReturn(0)
    on { imageUrl }.doReturn("imageUrl")
  }
  private lateinit var characterApiList: MutableList<CharacterBasicRetrofit>
  private lateinit var mapper: CharacterMapper

  @Before
  fun setup() {
    characterApiList = ArrayList<CharacterBasicRetrofit>()
    characterApiList.add(character1)
    characterApiList.add(character2)
    characterApiList.add(character3)
    mapper = CharacterMapperImp()
  }

  @Test
  fun doAction_doesSomething() {
    val characterBasics = mapper.charactersApiToCharactersModel(characterApiList)

    assertTrue(characterBasics[0].name === characterApiList[0].name)
    assertTrue(characterBasics[1].name === characterApiList[1].name)
  }
}