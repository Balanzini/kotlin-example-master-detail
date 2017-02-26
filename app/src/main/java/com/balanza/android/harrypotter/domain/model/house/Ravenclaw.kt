package com.balanza.android.harrypotter.domain.model.house

import com.balanza.android.harrypotter.R

/**
 * Created by balanza on 17/02/17.
 */
class Ravenclaw : House() {
  override val background: Int
    get() = R.drawable.ravenclaw_background

  override val name: String
    get() = "Ravenclaw"

  override val detailBackground: Int
    get() = R.drawable.ravenclaw_detail_bg

  override val primaryColor: Int
    get() = R.color.ravenclaw_primary

  override val calculatePoints: (Int) -> Int = {
    (it + (Math.random() * 10)).toInt()
  }
}