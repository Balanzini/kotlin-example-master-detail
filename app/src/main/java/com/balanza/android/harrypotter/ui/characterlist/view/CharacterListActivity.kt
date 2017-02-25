package com.balanza.android.harrypotter.ui.characterlist.view

import android.os.Bundle
import android.view.View
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.app.base.BaseActivity
import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.component.DaggerActivityComponent
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.balanza.android.harrypotter.ui.characterlist.adapter.CharacterAdapter
import com.balanza.android.harrypotter.ui.characterlist.presenter.CharacterListPresenter
import kotlinx.android.synthetic.main.character_list_layout.*
import javax.inject.Inject

class CharacterListActivity : BaseActivity(), CharacterListView {

  @Inject lateinit var presenter: CharacterListPresenter

  private var adapter = CharacterAdapter {
    ll_loading.visibility = View.VISIBLE
    presenter.onItemClick(it.characterId)
  }

  // region lifecycle
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_list_layout)

    srl_main_swipe_layout.setOnRefreshListener {
      presenter.refreshCharacters()
    }

    initOptionsAdapter()
    presenter.view = this
    ll_loading.visibility = View.VISIBLE
    presenter.getCharacters()
  }

  override fun onResume() {
    super.onResume()
    adapter.reset()
  }
  // endregion

  override fun onCharactersAvailable(characterList: List<CharacterBasic>) {
    hideLoading()
    adapter.setCharacters(characterList)
    srl_main_swipe_layout.isRefreshing = false
  }

  override fun hideLoading() {
    ll_loading.visibility = View.GONE
  }

  private fun initOptionsAdapter() {
    rv_character_list.adapter = adapter
  }

  override fun doInjection() {
    val activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(BaseApp.applicationComponent)
        .build()
    activityComponent.inject(this)
  }
}
