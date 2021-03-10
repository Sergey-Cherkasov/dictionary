package pt.svcdev.historyscreen.di

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import pt.svcdev.dictionary.di.application
import pt.svcdev.historyscreen.HistoryInteractor
import pt.svcdev.historyscreen.HistoryViewModel

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
