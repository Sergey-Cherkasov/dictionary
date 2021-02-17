package pt.svcdev.dictionary.di.modules

import dagger.Module
import dagger.Provides
import pt.svcdev.dictionary.di.NAME_LOCAL
import pt.svcdev.dictionary.di.NAME_REMOTE
import pt.svcdev.dictionary.mvvm.interactor.MainInteractor
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.repository.Repository
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}