package pt.svcdev.dictionary.di

import androidx.room.Room
import org.koin.dsl.module
import pt.svcdev.dictionary.mvvm.interactor.MainInteractor
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.datasource.RetrofitImpl
import pt.svcdev.dictionary.mvvm.model.datasource.RoomDatabaseImpl
import pt.svcdev.dictionary.mvvm.model.repository.LocalRepository
import pt.svcdev.dictionary.mvvm.model.repository.LocalRepositoryImpl
import pt.svcdev.dictionary.mvvm.model.repository.Repository
import pt.svcdev.dictionary.mvvm.model.repository.RepositoryImpl
import pt.svcdev.dictionary.mvvm.interactor.HistoryInteractor
import pt.svcdev.dictionary.mvvm.viewmodel.HistoryViewModel
import pt.svcdev.dictionary.mvvm.viewmodel.MainViewModel
import pt.svcdev.dictionary.room.HistoryDatabase

val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }

    single<Repository<List<DataModel>>> { RepositoryImpl(RetrofitImpl()) }
    single<LocalRepository<List<DataModel>>> { LocalRepositoryImpl(RoomDatabaseImpl(get())) }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
