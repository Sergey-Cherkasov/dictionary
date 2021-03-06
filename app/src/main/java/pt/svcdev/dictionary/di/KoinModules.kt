package pt.svcdev.dictionary.di

import androidx.room.Room
import org.koin.dsl.module
import pt.svcdev.model.room.HistoryDatabase
import pt.svcdev.repository.LocalRepository
import pt.svcdev.repository.LocalRepositoryImpl
import pt.svcdev.repository.Repository
import pt.svcdev.repository.RepositoryImpl
import pt.svcdev.repository.datasource.RetrofitImpl
import pt.svcdev.repository.datasource.RoomDatabaseImpl

val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }

    single<Repository<List<pt.svcdev.model.DataModel>>> {
        RepositoryImpl(
            RetrofitImpl()
        )
    }
    single<LocalRepository<List<pt.svcdev.model.DataModel>>> {
        LocalRepositoryImpl(
            RoomDatabaseImpl(get())
        )
    }
}
