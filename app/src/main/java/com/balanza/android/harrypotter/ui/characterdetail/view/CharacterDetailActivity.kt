package com.balanza.android.harrypotter.ui.characterdetail.view

import android.os.Build
import android.os.Bundle
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.app.base.BaseActivity
import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.component.DaggerActivityComponent
import com.balanza.android.harrypotter.ui.characterdetail.presenter.CharacterDetailPresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_details_layout.*
import javax.inject.Inject

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailActivity : BaseActivity(), CharacterDetailView {

  @Inject lateinit var presenter: CharacterDetailPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_details_layout)

    presenter.view = this
    presenter.getCharacter(0)
  }

  override fun onCharacterAvailable(name: String, lastName: String, birth: String, gender: String,
                                    house: String, wandDescription: String, patronus: String,
                                    urlImage: String, background: Int, primary: Int) {
    tv_detail_name.text = "$name $lastName"
    tv_detail_birth.text = birth
    tv_detail_gender.text = gender
    tv_detail_house.text = house
    tv_detail_wand_desc.text = wandDescription
    tv_detail_patronus.text = patronus
    Glide.with(this).load(urlImage).centerCrop().into(iv_detail_image_profile)
    Glide.with(this).load(background).centerCrop().into(iv_details_background)

    if (Build.VERSION.SDK_INT >= 21) {
      window.statusBarColor = resources.getColor(primary)
    }
  }

  override fun doInjection() {
    val activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(BaseApp.applicationComponent)
        .build()
    activityComponent.inject(this)
  }
}