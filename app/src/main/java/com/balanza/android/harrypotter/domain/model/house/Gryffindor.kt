package com.balanza.android.harrypotter.domain.model.house

import com.balanza.android.harrypotter.R

/**
 * Created by balanza on 17/02/17.
 */
class Gryffindor : House() {

  override val background: Int
    get() = R.drawable.gryffindor_background

  override val name: String
    get() = "Gryffindor"

  override val detailBackground: Int
    get() = R.drawable.gryffindor_detail_bg
}