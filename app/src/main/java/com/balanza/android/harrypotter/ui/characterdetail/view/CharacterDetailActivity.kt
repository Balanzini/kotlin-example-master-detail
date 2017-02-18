package com.balanza.android.harrypotter.ui.characterdetail.view

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.app.base.BaseActivity
import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.component.DaggerActivityComponent
import com.balanza.android.harrypotter.ui.characterdetail.presenter.CharacterDetailPresenter
import com.bumptech.glide.Glide
import javax.inject.Inject

/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailActivity : BaseActivity(), CharacterDetailView {

  @Inject lateinit var presenter: CharacterDetailPresenter

  private lateinit var tvName: TextView
//  private lateinit var tvLastName: TextView
  private lateinit var tvBirth: TextView
  private lateinit var ivBackground: ImageView
  private lateinit var ivProfile: ImageView
  private lateinit var tvGender: TextView
  private lateinit var tvHouse: TextView
  private lateinit var tvWandDesc: TextView
  private lateinit var tvPatronus: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_details_layout)

    tvName = findViewById(R.id.tv_detail_name) as TextView
//    tvLastName = findViewById(R.id.tv_detail_last_name) as TextView
    tvBirth = findViewById(R.id.tv_detail_birth) as TextView
    ivBackground = findViewById(R.id.iv_details_background) as ImageView
    ivProfile = findViewById(R.id.iv_detail_image_profile) as ImageView
    tvGender = findViewById(R.id.tv_detail_gender) as TextView
    tvHouse = findViewById(R.id.tv_detail_house) as TextView
    tvWandDesc = findViewById(R.id.tv_detail_wand_desc) as TextView
    tvPatronus = findViewById(R.id.tv_detail_patronus) as TextView

    presenter.view = this

    presenter.getCharacter(0)

  }

  override fun onCharacterAvailable(name: String, lastName: String, birth: String, gender: String,
                                    house: String, wandDescription: String, patronus: String,
                                    urlImage: String, background: Int, primary: Int) {
    tvName.text = "$name $lastName"
//    tvLastName.text = lastName
    tvBirth.text = birth
    tvGender.text = gender
    tvHouse.text = house
    tvWandDesc.text = wandDescription
    tvPatronus.text = patronus
    Glide.with(this).load(urlImage).centerCrop().into(ivProfile)
    Glide.with(this).load(background).centerCrop().into(ivBackground)

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