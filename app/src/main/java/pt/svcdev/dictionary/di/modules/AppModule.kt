package pt.svcdev.dictionary.di.modules

import dagger.Module
import dagger.Provides
import pt.svcdev.dictionary.App

@Module
class AppModule(private val app: App) {

    @Provides
    fun app(): App = app
}