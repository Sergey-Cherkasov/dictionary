package pt.svcdev.dictionary.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import pt.svcdev.dictionary.App
import pt.svcdev.dictionary.di.modules.*
import pt.svcdev.dictionary.di.modules.ViewModelModule
import pt.svcdev.dictionary.mvvm.view.main.MainActivity
import javax.inject.Singleton

@Component(
    modules = [
//        AppModule::class,
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : AppComponent
    }

    fun inject(activity: MainActivity)

}