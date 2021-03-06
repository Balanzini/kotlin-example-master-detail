package com.balanza.android.harrypotter.app.di.component

import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.module.ApplicationModule
import com.balanza.android.harrypotter.app.di.module.DataSourceModule
import com.balanza.android.harrypotter.app.di.module.MapperModule
import com.balanza.android.harrypotter.app.di.module.RepositoryModule
import com.balanza.android.harrypotter.app.navigator.Navigator
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by balanza on 13/02/17.
 */
@Singleton
@Component(
    modules = arrayOf(ApplicationModule::class, RepositoryModule::class, DataSourceModule::class,
        MapperModule::class))
interface ApplicationComponent {

  fun inject(baseApp: BaseApp)

  fun navigator(): Navigator

  fun characterRepository(): CharacterRepository
//
//    fun accountController(): AccountController
//
//    fun userRepository(): UserRepository
//
//    fun filesRepository(): FilesRepository
}