package pt.svcdev.historyscreen.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pt.svcdev.historyscreen.HistoryActivity
import pt.svcdev.historyscreen.HistoryInteractor
import pt.svcdev.historyscreen.HistoryViewModel

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
    }
    viewModel { HistoryViewModel(get()) }
}
