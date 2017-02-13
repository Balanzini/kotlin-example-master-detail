package com.balanza.android.harrypotter.app.di.component

import com.balanza.android.harrypotter.app.di.annotation.PerView
import com.balanza.android.harrypotter.app.di.module.PresenterModule
import com.balanza.android.harrypotter.ui.characterlist.view.CharacterListActivity
import dagger.Component

/**
 * Created by balanza on 13/02/17.
 */
@PerView
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(PresenterModule::class))
interface ActivityComponent {
    fun inject(characterListActivity : CharacterListActivity)
}