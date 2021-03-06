package pt.svcdev.mainscreen.di

import org.koin.dsl.module
import pt.svcdev.mainscreen.MainInteractor
import pt.svcdev.mainscreen.MainViewModel

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

