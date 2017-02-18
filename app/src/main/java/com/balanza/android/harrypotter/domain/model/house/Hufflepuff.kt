package com.balanza.android.harrypotter.domain.model.house

import com.balanza.android.harrypotter.R

/**
 * Created by balanza on 17/02/17.
 */
class Hufflepuff : House() {
  override val background: Int
    get() = R.drawable.hufflepuff_background
  override val name: String
    get() = "Hufflepuff"

  override val detailBackground: Int
    get() = R.drawable.hufflepuff_details_bg

  override val primaryColor: Int
    get() = R.color.hufflepuff_primary
}