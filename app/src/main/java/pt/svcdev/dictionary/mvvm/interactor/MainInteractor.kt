package pt.svcdev.dictionary.mvvm.interactor

import io.reactivex.Observable
import pt.svcdev.dictionary.di.NAME_LOCAL
import pt.svcdev.dictionary.di.NAME_REMOTE
import pt.svcdev.dictionary.mvvm.model.data.AppState
import pt.svcdev.dictionary.mvvm.model.data.DataModel
import pt.svcdev.dictionary.mvvm.model.repository.Repository
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote.getData(word).map { AppState.Success(it) }
        } else {
            repositoryLocal.getData(word).map { AppState.Success(it) }
        }
    }
}
