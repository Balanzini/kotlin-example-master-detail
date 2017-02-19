package com.balanza.android.harrypotter.app.di.module

import android.app.Application
import android.content.Context
import com.balanza.android.harrypotter.app.navigator.DefaultNavigator
import com.balanza.android.harrypotter.app.navigator.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by balanza on 13/02/17.
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    fun provideApplicationComponent(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return DefaultNavigator()
    }
//
//    @Provides
//    @Singleton
//    internal fun provideAccountManagerController(appContext: Context): AccountController {
//        return AccountControllerImp(appContext)
//    }
}