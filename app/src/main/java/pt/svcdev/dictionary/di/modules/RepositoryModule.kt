package pt.svcdev.dictionary.di.modules

import dagger.Module
import dagger.Provides
import pt.svcdev.dictionary.di.NAME_LOCAL
import pt.svcdev.dictionary.di.NAME_REMOTE
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.datasource.DataSource
import pt.svcdev.dictionary.mvvm.model.datasource.RetrofitImpl
import pt.svcdev.dictionary.mvvm.model.datasource.RoomDatabaseImpl
import pt.svcdev.dictionary.mvvm.model.repository.Repository
import pt.svcdev.dictionary.mvvm.model.repository.RepositoryImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(
        @Named(NAME_REMOTE) datasourceRemote: DataSource<List<DataModel>>
    ): Repository<List<DataModel>> = RepositoryImpl(datasourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(
        @Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>
    ): Repository<List<DataModel>> = RepositoryImpl(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> = RetrofitImpl()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDatabaseImpl()

}