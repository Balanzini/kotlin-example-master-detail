package com.balanza.android.harrypotter.domain.model.house

import com.balanza.android.harrypotter.R

/**
 * Created by balanza on 17/02/17.
 */
class Slytherin : House(){
  override val background: Int
    get() = R.drawable.slytherin_background
  override val name: String
    get() = "Slytherin"

  override val detailBackground: Int
    get() = R.drawable.slytherin_details_bg

  override val primaryColor: Int
    get() = R.color.slytherin_primary

  override val calculatePoints: (Int) -> Int = {
    (it - (Math.random() * 10)).toInt()
  }
}