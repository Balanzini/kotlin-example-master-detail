package com.balanza.android.harrypotter.domain.model.factory

import android.util.Log
import com.balanza.android.harrypotter.app.HouseNotExistException
import com.balanza.android.harrypotter.domain.model.house.*

/**
 * Created by balanza on 17/02/17.
 */
object HouseFactory{
  fun createHouse(houseId : Int)  : House {
    Log.i("balanzaa", " house id $houseId")
    when (houseId) {
      0 -> return Gryffindor()
      1 -> return Hufflepuff()
      2 -> return Ravenclaw()
      3 -> return Slytherin()
      else -> throw HouseNotExistException()
    }
  }
}