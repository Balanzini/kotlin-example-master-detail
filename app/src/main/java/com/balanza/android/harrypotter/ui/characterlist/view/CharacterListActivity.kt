package com.balanza.android.harrypotter.ui.characterlist.view

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
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
  private lateinit var srlMainLayout: SwipeRefreshLayout


  private var adapter = CharacterAdapter()

  // region lifecycle
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_list_layout)
    ButterKnife.bind(this)

    rvCharacters = findViewById(R.id.rv_character_list) as RecyclerView
    srlMainLayout = findViewById(R.id.srl_main_swipe_layout) as SwipeRefreshLayout

    srlMainLayout.setOnRefreshListener {
      presenter.refreshCharacters()
    }

    initOptionsAdapter()
    presenter.view = this
    presenter.getCharacters()
  }
  // endregion

  override fun onCharactersAvailable(characterList: List<CharacterBasic>) {
    adapter.setCharacters(characterList)
    srlMainLayout.isRefreshing = false
  }

  private fun initOptionsAdapter() {
    rvCharacters.adapter = adapter
    adapter.setOnItemClick(object : CharacterAdapter.OnItemClick {
      override fun onClick(position: Int) {
        presenter.onItemClick(position)
      }
    })
  }


  override fun doInjection() {
    val activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(BaseApp.applicationComponent)
        .build()
    activityComponent.inject(this)
  }
}
