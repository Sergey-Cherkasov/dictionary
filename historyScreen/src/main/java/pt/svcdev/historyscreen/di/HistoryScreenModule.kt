package pt.svcdev.historyscreen.di

import org.koin.dsl.module
import pt.svcdev.historyscreen.HistoryInteractor
import pt.svcdev.historyscreen.HistoryViewModel

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
