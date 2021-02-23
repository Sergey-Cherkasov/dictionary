package pt.svcdev.dictionary

import android.app.Application
import org.koin.core.context.startKoin
import pt.svcdev.dictionary.di.modules.app
import pt.svcdev.dictionary.di.modules.mainScreen

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(app, mainScreen))
        }
    }

}
