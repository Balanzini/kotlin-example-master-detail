package com.balanza.android.harrypotter.domain.interactor.character

/**
 * Created by balanza on 26/02/17.
 */
interface GetPointsWin {
  fun getPoints(callbackPoints: (Int, String) -> Unit)
}