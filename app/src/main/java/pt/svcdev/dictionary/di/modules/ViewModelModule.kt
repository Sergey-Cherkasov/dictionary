package pt.svcdev.dictionary.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.svcdev.dictionary.annotation.ViewModelKey
import pt.svcdev.dictionary.mvvm.viewmodel.MainViewModel
import pt.svcdev.dictionary.di.ViewModelFactory

@Module(includes = [InteractorModule::class])
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}