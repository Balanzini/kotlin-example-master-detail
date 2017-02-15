package com.balanza.android.harrypotter.ui.characterlist.view

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.app.base.BaseActivity
import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.component.DaggerActivityComponent
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.balanza.android.harrypotter.ui.characterlist.adapter.CharacterAdapter
import com.balanza.android.harrypotter.ui.characterlist.presenter.CharacterListPresenter
import javax.inject.Inject

class CharacterListActivity : BaseActivity(), CharacterListView {

  @Inject lateinit var presenter: CharacterListPresenter

  private lateinit var rvCharacters: RecyclerView

  private var adapter = CharacterAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_list_layout)
    ButterKnife.bind(this)

    rvCharacters = findViewById(R.id.rv_character_list) as RecyclerView


    initOptionsAdapter()
    presenter.view = this
    presenter.getCharacters()
  }

  override fun onResume() {
    super.onResume()
    presenter.getCharacters()
  }

  override fun onCharactersAvailable(characterList: List<CharacterBasic>) {
    adapter.setCharacters(characterList)
  }

  private fun initOptionsAdapter() {
    rvCharacters.adapter = adapter

  }

  override fun doInjection() {
    val activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(BaseApp.applicationComponent)
        .build()
    activityComponent.inject(this)
  }
}
