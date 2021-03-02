package pt.svcdev.dictionary

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pt.svcdev.dictionary.di.application
import pt.svcdev.dictionary.di.historyScreen
import pt.svcdev.dictionary.di.mainScreen

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }

}
