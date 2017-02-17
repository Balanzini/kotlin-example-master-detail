package com.balanza.android.harrypotter.ui.characterdetail.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
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
class CharacterDetailActivity : BaseActivity(), CharacterDetailView{

  @Inject lateinit var presenter: CharacterDetailPresenter

  private lateinit var tvName: TextView
  private lateinit var tvLastName: TextView
  private lateinit var rlBackground: RelativeLayout
  private lateinit var ivBackground : ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_details_layout)

    tvName = findViewById(R.id.tv_detail_name) as TextView
    tvLastName = findViewById(R.id.tv_detail_last_name) as TextView
    rlBackground = findViewById(R.id.rl_details_background) as RelativeLayout
    ivBackground = findViewById(R.id.iv_details_background) as ImageView

    presenter.view = this

    presenter.getCharacter(0)
  }

  override fun onCharacterAvailable(name: String, lastName: String, birth: String, background : Int) {
    tvName.text = name
    tvLastName.text = lastName
    Glide.with(this).load(background).centerCrop().into(ivBackground)
  }

  override fun doInjection() {
    val activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(BaseApp.applicationComponent)
        .build()
    activityComponent.inject(this)
  }
}