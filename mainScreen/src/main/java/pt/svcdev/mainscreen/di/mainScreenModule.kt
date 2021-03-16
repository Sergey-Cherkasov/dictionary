package pt.svcdev.mainscreen.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pt.svcdev.mainscreen.MainActivity
import pt.svcdev.mainscreen.MainInteractor
import pt.svcdev.mainscreen.MainViewModel

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
    }
    viewModel { MainViewModel(get()) }
}

