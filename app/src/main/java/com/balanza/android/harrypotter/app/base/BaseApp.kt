package com.balanza.android.harrypotter.app.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.balanza.android.harrypotter.app.di.component.ApplicationComponent
import com.balanza.android.harrypotter.app.di.component.DaggerApplicationComponent

import com.balanza.android.harrypotter.app.di.module.ApplicationModule
import com.balanza.android.harrypotter.app.navigator.Navigator
import javax.inject.Inject

/**
 * Created by balanza on 13/02/17.
 */

class BaseApp : Application(), Application.ActivityLifecycleCallbacks {

    @Inject lateinit var navigator: Navigator

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var applicationComponent: ApplicationComponent
    }

//    private var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        buildApplicationComponent()
        registerActivityLifecycleCallbacks(this)

    }

    fun buildApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent?.inject(this)
    }

//    fun getApplicationComponent(): ApplicationComponent? {
//        return applicationComponent
//    }

    override fun onActivityStarted(p0: Activity?) {
    }

    override fun onActivityDestroyed(p0: Activity?) {
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(p0: Activity?) {
    }

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityResumed(p0: Activity?) {
        navigator?.activity = p0
    }

    override fun onActivityPaused(p0: Activity?) {
    }

}
