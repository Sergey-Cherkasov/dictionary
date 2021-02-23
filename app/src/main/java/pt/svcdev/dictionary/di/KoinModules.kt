package pt.svcdev.dictionary.di.modules

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pt.svcdev.dictionary.di.NAME_LOCAL
import pt.svcdev.dictionary.di.NAME_REMOTE
import pt.svcdev.dictionary.mvvm.interactor.MainInteractor
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.datasource.RetrofitImpl
import pt.svcdev.dictionary.mvvm.model.datasource.RoomDatabaseImpl
import pt.svcdev.dictionary.mvvm.model.repository.Repository
import pt.svcdev.dictionary.mvvm.model.repository.RepositoryImpl
import pt.svcdev.dictionary.mvvm.viewmodel.MainViewModel

val app = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImpl(RetrofitImpl()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImpl(RoomDatabaseImpl()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    viewModel { MainViewModel(get()) }
}