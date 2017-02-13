package com.balanza.android.harrypotter.ui.characterlist.view

import android.os.Bundle
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.app.base.BaseActivity
import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.component.DaggerActivityComponent
import com.balanza.android.harrypotter.ui.characterlist.presenter.CharacterListPresenter
import javax.inject.Inject

class CharacterListActivity : BaseActivity(), CharacterListView {
    @Inject lateinit var presenter: CharacterListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
    }

    override fun onResume() {
        super.onResume()
        presenter.check()
    }
    override fun doInjection() {
        val activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(BaseApp.applicationComponent)
                .build()
        activityComponent.inject(this)
    }
}
