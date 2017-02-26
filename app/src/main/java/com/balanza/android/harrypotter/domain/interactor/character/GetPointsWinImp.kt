package com.balanza.android.harrypotter.domain.interactor.character

import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by balanza on 26/02/17.
 */
class GetPointsWinImp(val characterRepository: CharacterRepository) : GetPointsWin {

  override fun getPoints(callbackPoints: (Int, String) -> Unit) {
    doAsync {
      val character = characterRepository.getCharacter()
      val pointsWin = calculate(character?.name?.length ?: 0, character?.house!!.calculatePoints)
      uiThread {
        callbackPoints(pointsWin, character?.house.name)
      }
    }
  }

  private fun calculate(initialPoints: Int,
                        calculatePointsStrategy: (Int) -> Int): Int = calculatePointsStrategy(
      initialPoints)
}