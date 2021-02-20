package pt.svcdev.dictionary

import android.app.Application
import pt.svcdev.dictionary.di.AppComponent
import pt.svcdev.dictionary.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}